package rst.window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class StartContext extends Context {

	private static final long serialVersionUID = 1L;

	private final JProgressBar textures, sounds;
	
	public StartContext() {
		super(false,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 200,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 200,
				new Dimension(400, 400), JFrame.NORMAL);
		
		sounds = new JProgressBar();
		textures = new JProgressBar();
		
		final JButton start = new JButton("Start");
		start.setEnabled(false);
		start.addActionListener((event) -> Contexts.MAIN.makeCurrent(this));
		
		ComponentAdapter awaitDone = new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				if(!sounds.isVisible() && !textures.isVisible()) {
					start.setEnabled(true);
				}
			}
		};
		
		sounds.setStringPainted(true);
		textures.setStringPainted(true);
		
		sounds.addComponentListener(awaitDone);
		textures.addComponentListener(awaitDone);
		
		sounds.setBorder(BorderFactory.createTitledBorder("Sounds"));
		textures.setBorder(BorderFactory.createTitledBorder("Textures"));
		
		add(sounds);
		add(textures);
		
		add(start);
	}
	
	JProgressBar getSoundsBar() {
		return sounds;
	}
	
	JProgressBar getTexturesBar() {
		return textures;
	}

}
