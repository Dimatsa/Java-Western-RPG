/*
 * DialogueStarter.java
 * Allows you to start a dialogue
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.dialogue;

import rst.character.Characters;
import rst.character.Player;

public class DialogueStarter implements Runnable {
	private final String dialogueID;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public DialogueStarter(String dialogueID) {
		this.dialogueID = dialogueID;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void run() {
		((Player)Characters.getCharacters().getCharacter("Connor Adams")).startDialogue(dialogueID);
	}
}
