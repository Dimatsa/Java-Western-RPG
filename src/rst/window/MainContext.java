package rst.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import rst.character.Characters;
import rst.character.Player;
import rst.dialogue.DialoguePanel;
import rst.render.RenderPanel;

public class MainContext extends Context {

	private static final long serialVersionUID = 1L;
	
	private final RenderPanel render;
	private final DialoguePanel dialogue;
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	public MainContext() {
		super(true,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 424,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 239,
				 new Dimension(848, 477), JFrame.MAXIMIZED_BOTH);
		
		setLayout(new BorderLayout());
		
		render = new RenderPanel();
		dialogue = new DialoguePanel();
		
		add(render, BorderLayout.CENTER);
		add(dialogue, BorderLayout.SOUTH);
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void makeContextForFrame(JFrame frame) {
		if(!((Player)Characters.getCharacters().getCharacter("Connor Adams")).hasPanels()) {
			((Player)Characters.getCharacters().getCharacter("Connor Adams")).setPanels(render, dialogue);
		}
		
		super.makeContextForFrame(frame);
		
		render.requestFocus();
		
		render.startPainting();
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void transferContext(Context other) {
		super.transferContext(other);
		
		render.stopPainting();
	}
}
