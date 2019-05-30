package rst.window;

import javax.swing.JFrame;

public class MainWindow {

	private final JFrame frame;
	
	public MainWindow() {
		frame = new JFrame("Shootout at Sweaty Post");
		
		Contexts.START.makeCurrent(frame);
	}
	
	public void show() {
		frame.setVisible(true);
	}
}
