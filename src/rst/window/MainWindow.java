package rst.window;

import javax.swing.JFrame;

import rst.assets.AssetRegistry;

public class MainWindow {

	private final JFrame frame;
	
	public MainWindow() {
		frame = new JFrame("Shootout at Sweaty Post");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		AssetRegistry.init();
		
		Contexts.START.makeCurrent(frame);
	}
	
	public void show() {
		frame.setVisible(true);
	}
}
