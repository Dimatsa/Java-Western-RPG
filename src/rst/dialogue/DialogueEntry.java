package rst.dialogue;

import java.util.function.Consumer;

public class DialogueEntry implements Consumer<DialoguePanel> {
	private final String id;
	private final String dialogue;
	private final String[] responses;
	private final Consumer<DialoguePanel>[] actions;
	
	public DialogueEntry(String id, String dialogue, String[] responses, Consumer<DialoguePanel>[] actions) {
		this.id = id;
		this.dialogue = dialogue;
		this.responses = responses;
		this.actions = actions;
	}

	public String getId() {
		return id;
	}

	public String getDialogue() {
		return dialogue;
	}

	public String[] getResponses() {
		return responses;
	}

	public void execute(DialoguePanel dialoguePanel, int index) {
		if(actions != null && actions[index] != null) {
			actions[index].accept(dialoguePanel);
		}
		else {
			dialoguePanel.setDialogue(null);
		}
	}

	@Override
	public void accept(DialoguePanel dialoguePanel) {
		dialoguePanel.setDialogue(this);
	}
}
