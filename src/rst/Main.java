package rst;

import javax.swing.SwingUtilities;

import rst.character.Character;
import rst.character.NpcCharacter;
import rst.window.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		createAndShowGUI();

		// Creates Dalton brothers
		Character slimy = new NpcCharacter("Slimy", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character sneaky = new NpcCharacter("Sneaky", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character shifty = new NpcCharacter("Shifty", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character snitchy = new NpcCharacter("Snitchy", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, null);

		// Creates Earps
		Character marshallVirgil = new NpcCharacter("Marshal Virgil", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character wyatt = new NpcCharacter("Wyatt", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character morgan = new NpcCharacter("Morgan", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character docHolliday = new NpcCharacter("Doc Holliday", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, null);

		// Creates random characters
		Character ryan = new NpcCharacter("Ryan", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character toby = new NpcCharacter("Toby", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character gian = new NpcCharacter("Giancarlo", "Salvador", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character steve = new NpcCharacter("Steve", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1, null);
		Character flinston = new NpcCharacter("Flinston", "Stone", Character.MALE, 1, 1, 1, 1, 1, 1, null);
	}

	private static void createAndShowGUI() {
		SwingUtilities.invokeLater(() -> {
			MainWindow window = new MainWindow();
			window.show();
		});
	}
}
