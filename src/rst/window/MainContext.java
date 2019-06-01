package rst.window;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import rst.assets.Fonts;
import rst.assets.Sounds;
import rst.assets.Textures;

public class MainContext extends Context {

	private static final long serialVersionUID = 1L;
	
	private final Textures textures;
	private final Sounds sounds;
	private final Fonts fonts;

	public MainContext(StartContext start) {
		super(true,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 424,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 239,
				 new Dimension(848, 477), JFrame.MAXIMIZED_BOTH);
		
		this.textures = new Textures(start.getTexturesBar());
		this.sounds = new Sounds(start.getSoundsBar());
		this.fonts = new Fonts(start.getFontsBar());
		
		textures.execute();
		sounds.execute();
		fonts.execute();
		
		JButton exit = new JButton("Exit");
		exit.addActionListener((event) -> System.exit(0));
		
		add(exit);
	}
	
	public Textures getTextures() {
		return this.textures;
	}
	
	public Sounds getSounds() {
		return this.sounds;
	}
	
}
