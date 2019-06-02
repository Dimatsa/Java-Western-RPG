package rst.window;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import rst.assets.AssetRegistry;

public class MainContext extends Context {

	private static final long serialVersionUID = 1L;
	
	public MainContext() {
		super(true,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 424,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 239,
				 new Dimension(848, 477), JFrame.MAXIMIZED_BOTH);
		
		JButton exit = new JButton("Exit");
		AssetRegistry.getFonts().onLoad(() -> exit.setFont(AssetRegistry.getFonts().get("Montserrat-Regular").getFont().deriveFont((float)exit.getFont().getSize())));
		exit.addActionListener((event) -> System.exit(0));
		
		add(exit);
	}
}
