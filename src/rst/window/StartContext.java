package rst.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import rst.assets.AssetRegistry;

public class StartContext extends Context {

	private static final long serialVersionUID = 1L;

	private final JProgressBar textures, sounds, fonts;
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	public StartContext() {
		super(false,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 200,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 200,
				new Dimension(400, 400), JFrame.NORMAL);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBackground(Color.BLACK);
		
		sounds = new JProgressBar();
		textures = new JProgressBar();
		fonts = new JProgressBar();
		
		bindProgress(sounds, AssetRegistry.getSounds());
		bindProgress(textures, AssetRegistry.getTextures());
		bindProgress(fonts, AssetRegistry.getFonts());
		
		sounds.setBackground(Color.BLACK);
		textures.setBackground(Color.BLACK);
		fonts.setBackground(Color.BLACK);
		
		sounds.setForeground(Color.WHITE);
		textures.setForeground(Color.WHITE);
		fonts.setForeground(Color.WHITE);
		
		JLabel start = new JLabel("Click to Start");
		start.setForeground(Color.WHITE);
		start.setBackground(Color.BLACK);
		
		start.setAlignmentX(CENTER_ALIGNMENT);
		start.setHorizontalAlignment(SwingConstants.CENTER);
		
		Thread t = new Thread(() -> {
			long startTime = System.currentTimeMillis();
			while(!Thread.interrupted()) {
				int fullTime = 3000;
				long delta = (System.currentTimeMillis() - startTime) % fullTime;
				
				int alpha;
				if((System.currentTimeMillis() - startTime) < fullTime / 4) {
					alpha = (int)(254 * Math.pow(Math.sin(2 * Math.PI * delta / fullTime), 2) + 0.5);
				}
				else {
					alpha = (int)(126 * Math.pow(Math.cos(Math.PI * (delta - (fullTime / 4)) / fullTime), 2) + 0.5) + 128;
				}
					start.setForeground(new Color(255, 255, 255, alpha));
				}
		});
				
		t.setDaemon(true);
		AtomicBoolean canStart = new AtomicBoolean(false);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(canStart.get()) {
					Contexts.MAIN.makeCurrent(StartContext.this);
					t.interrupt();
				}
			}
		});
		
		AssetRegistry.getTextures().onLoad(() -> this.getCurrent().setIconImages(Arrays.asList(
			AssetRegistry.getTextures().get("icon16").getImage(),
			AssetRegistry.getTextures().get("icon32").getImage(),
			AssetRegistry.getTextures().get("icon64").getImage(),
			AssetRegistry.getTextures().get("icon128").getImage())));
		
		AssetRegistry.getFonts().onLoad(() ->
		start.setFont(AssetRegistry.getFonts().get("Montserrat-Regular").getFont()
				.deriveFont((float)start.getFont().getSize())));
		
		ComponentAdapter awaitDone = new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {	
				if(!sounds.isVisible() && !textures.isVisible() && !fonts.isVisible() && !canStart.get()) {
					canStart.set(true);
					StartContext.this.setLayout(new BorderLayout());
					add(start, BorderLayout.CENTER);
					StartContext.this.revalidate();
					t.start();
				}
			}
		};
		
		sounds.addComponentListener(awaitDone);
		textures.addComponentListener(awaitDone);
		fonts.addComponentListener(awaitDone);
		
		sounds.setStringPainted(true);
		textures.setStringPainted(true);
		fonts.setStringPainted(true);
		
		TitledBorder soundBorder = BorderFactory.createTitledBorder("Sounds");
		soundBorder.setTitleColor(Color.WHITE);
		
		TitledBorder textureBorder = BorderFactory.createTitledBorder("Textures");
		textureBorder.setTitleColor(Color.WHITE);
		
		TitledBorder fontBorder = BorderFactory.createTitledBorder("Fonts");
		fontBorder.setTitleColor(Color.WHITE);
		
		sounds.setBorder(soundBorder);
		textures.setBorder(textureBorder);
		fonts.setBorder(fontBorder);
		
		add(sounds);
		add(textures);
		add(fonts);
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	private static void bindProgress(JProgressBar progress, AssetRegistry<?> registry) {
		progress.setMinimum(0);
		progress.setMaximum(100);
		progress.setValue(0);
		registry.addPropertyChangeListener((property) -> {
			if(property.getPropertyName().equals("progress")) {
				progress.setValue((Integer)property.getNewValue());
			}
		});
		registry.onLoad(() -> progress.setVisible(false));
		registry.onBatch(progress::setString);
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	JProgressBar getSoundsBar() {
		return sounds;
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	JProgressBar getTexturesBar() {
		return textures;
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	JProgressBar getFontsBar() {
		return fonts;
	}

}
