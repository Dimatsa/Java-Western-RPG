package rst;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import rst.window.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Turn on audio for best playing experience\n"
				+ "Use WASD to interract, mouse click to shoot, and E to interact on things\n"
				+ "Hint: Cactii can't grow on paths", "Notice", JOptionPane.INFORMATION_MESSAGE);
		
		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		SwingUtilities.invokeLater(() -> {
			MainWindow window = new MainWindow();
			window.show();
		});
	}
}
