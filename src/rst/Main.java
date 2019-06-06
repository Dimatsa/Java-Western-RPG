package rst;

import javax.swing.SwingUtilities;

import rst.window.MainWindow;

public class Main {

	public static void main(String[] args) {
		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		SwingUtilities.invokeLater(() -> {
			MainWindow window = new MainWindow();
			window.show();
		});
	}
}
