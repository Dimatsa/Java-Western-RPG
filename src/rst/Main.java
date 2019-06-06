package rst;

import javax.swing.SwingUtilities;

import rst.window.MainWindow;
import rst.character.Character;

public class Main {

	public static void main(String[] args) {
		createAndShowGUI();

		//Creates Dalton brothers
		Character slimy = new Character("Slimy", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character sneaky = new Character("Sneaky", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character shifty = new Character("Shifty", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character snitchy = new Character("Snitchy", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1);

		//Creates Earps
		Character marshallVirgil = new Character("Marshal Virgil", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character wyatt = new Character("Wyatt", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character morgan = new Character("Morgan", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character docHolliday = new Character("Doc Holliday", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1);

		//Creates random characters
		Character ryan = new Character("Ryan", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character toby = new Character("Toby", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character gian = new Character("Giancarlo", "Salvador", Character.MALE, 1, 1, 1, 1, 1, 1);
		Character steve = new Character("Steve", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1);


		
	}

	private static void createAndShowGUI() {
		SwingUtilities.invokeLater(() -> {
			MainWindow window = new MainWindow();
			window.show();
		});
	}
}
