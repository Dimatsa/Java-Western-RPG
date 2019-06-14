/*
 * Dialogues.java
 * Allows for dialogues
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.dialogue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import rst.character.Characters;
import rst.character.Player;
import rst.plot.PlotLine;

public class Dialogues {
	private static Dialogues dialogues;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public static void init() {
		if(dialogues == null) {
			dialogues = new Dialogues();
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public static Dialogues getDialogues() {
		init();
		return dialogues;
	}
	
	private Map<String, DialogueEntry> dialogueMap;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected Dialogues() {
		dialogueMap = new HashMap<>();
		
		makeDialogue(new DialogueEntry("testDialogue", "This is a test!!",
				new String[] { "Option a", "Option b", "Option c", "Option d" }, chain("testDialogue2", "testDialogue2", "testDialogue2", "testDialogue2")));
		makeDialogue(new DialogueEntry("testDialogue2", "Try some more!",
				new String[] { "Option A", "Option B", "Option C" }, null));
		
		makeDialogue(new DialogueEntry("plotTest", "Would you like to try a plot?", new String[] { "Yes", "No" }, chain(item -> PlotLine.getPlotLine().activate("speak"), null)));
		makeDialogue(new DialogueEntry("death", "You died!", new String[] { "Respawn" }, chain(item -> ((Player)Characters.getCharacters().getCharacter("Connor Adams")).respawn())));
		makeDialogue(new DialogueEntry("win", "You won!", new String[] { "Quit" }, chain(item -> System.exit(0))));
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@SafeVarargs
	private final Consumer<DialoguePanel>[] chain(Consumer<DialoguePanel>... panels) {
		return panels;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private Consumer<DialoguePanel>[] chain(String...dialogues) {
		@SuppressWarnings("unchecked")
		Consumer<DialoguePanel>[] dialogueArray = new Consumer[dialogues.length];
		
		for(int i = 0; i < dialogueArray.length; i++) {
			final int index = i;
			dialogueArray[i] = item -> getDialogue(dialogues[index]).accept(item);
		}
		
		return dialogueArray;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private void makeDialogue(DialogueEntry d) {
		dialogueMap.put(d.getId(), d);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public DialogueEntry getDialogue(String name) {
		return dialogueMap.get(name);
	}
}
