package rst.dialogue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Dialogues {
	private static Dialogues dialogues;
	
	public static void init() {
		if(dialogues == null) {
			dialogues = new Dialogues();
		}
	}
	
	public static Dialogues getDialogues() {
		init();
		return dialogues;
	}
	
	private Map<String, DialogueEntry> dialogueMap;
	
	protected Dialogues() {
		dialogueMap = new HashMap<>();
		
		makeDialogue(new DialogueEntry("testDialogue", "This is a test!!",
				new String[] { "Option a", "Option b", "Option c", "Option d" }, chain("testDialogue2", "testDialogue2", "testDialogue2", "testDialogue2")));
		makeDialogue(new DialogueEntry("testDialogue2", "Try some more!",
				new String[] { "Option A", "Option B", "Option C" }, null));
	}
	
	private Consumer<DialoguePanel>[] chain(String...dialogues) {
		@SuppressWarnings("unchecked")
		Consumer<DialoguePanel>[] dialogueArray = new Consumer[dialogues.length];
		
		for(int i = 0; i < dialogueArray.length; i++) {
			final int index = i;
			dialogueArray[i] = item -> getDialogue(dialogues[index]).accept(item);
		}
		
		return dialogueArray;
	}
	
	private void makeDialogue(DialogueEntry d) {
		dialogueMap.put(d.getId(), d);
	}

	public DialogueEntry getDialogue(String name) {
		return dialogueMap.get(name);
	}
}