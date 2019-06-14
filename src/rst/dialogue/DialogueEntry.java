/*
 * DialogueEntry.java
 * Deals with entering dialogue
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.dialogue;

import java.util.function.Consumer;

public class DialogueEntry implements Consumer<DialoguePanel> {
	private final String id;
	private final String dialogue;
	private final String[] responses;
	private final Consumer<DialoguePanel>[] actions;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public DialogueEntry(String id, String dialogue, String[] responses, Consumer<DialoguePanel>[] actions) {
		this.id = id;
		this.dialogue = dialogue;
		this.responses = responses;
		this.actions = actions;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public String getId() {
		return id;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public String getDialogue() {
		return dialogue;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public String[] getResponses() {
		return responses;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void execute(DialoguePanel dialoguePanel, int index) {
		if(actions != null && actions[index] != null) {
			actions[index].accept(dialoguePanel);
			if(dialoguePanel.getDialogueName().equals(getDialogue())) {
				dialoguePanel.setDialogue(null);
			}
		}
		else {
			dialoguePanel.setDialogue(null);
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void accept(DialoguePanel dialoguePanel) {
		dialoguePanel.setDialogue(this);
	}
}
