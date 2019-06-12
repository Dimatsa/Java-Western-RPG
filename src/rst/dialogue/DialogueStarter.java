package rst.dialogue;

import rst.character.Characters;
import rst.character.Player;

public class DialogueStarter implements Runnable {
	private final String dialogueID;
	
	public DialogueStarter(String dialogueID) {
		this.dialogueID = dialogueID;
	}

	@Override
	public void run() {
		((Player)Characters.getCharacters().getCharacter("Connor Adams")).startDialogue(dialogueID);
	}
}
