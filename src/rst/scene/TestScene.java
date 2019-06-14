/*
 * TestScene.java
 * Deals with test scene
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.scene;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.dialogue.DialogueStarter;
import rst.render.Block;
import rst.render.CameraFollowable;
import rst.render.InteractableBlock;

public class TestScene extends Scene {
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public TestScene() {
		super("sand", "sand", 10, 10, AssetRegistry.getSounds().get("test"),
				(CameraFollowable) Characters.getCharacters().getCharacter("Connor Adams"), 
				"Test Scene", Characters.getCharacters().getCharacter("Connor Adams"),
				new InteractableBlock(true, Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 0, 0).onInteract(new DialogueStarter("testDialogue")),
				new Block("sand" , 0, 1),
				new Block("sand" , 0, 2),
				new Block("sand" , 0, 3),
				new Block("sand" , 0, 4),
				new Block("path" , 0, 5),
				new Block("path" , 0, 6),
				new Block("path" , 0, 7),
				new Block("path" , 0, 8),
				new Block("path" , 0, 9),
				new Block("path" , 1, 0),
				new Block("path" , 1, 1),
				new Block("path" , 1, 2),
				new Block("path" , 1, 3),
				new Block("path" , 1, 4),
				new Block("path" , 1, 5),
				new DoubleCactus(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, 1, 5),
				new Block("path" , 1, 6),
				new InteractableBlock(true, Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 1, 7).onInteract(() -> System.out.println("Second")),
				new Block("path" , 1, 8),
				new Block("path" , 1, 9),
				new Block("path" , 2, 0),
				new Block("path" , 2, 1),
				new Block("path" , 2, 2),
				new Block("path" , 2, 3),
				new Block("path" , 2, 4),
				new Block("path" , 2, 5),
				new Block("path" , 2, 6),
				new Block("path" , 2, 7),
				new Block("path" , 2, 8),
				new Block("path" , 2, 9),
				new Block("path" , 3, 0),
				new Block("path" , 3, 1),
				new Block("path" , 3, 2),
				new Block("path" , 3, 3),
				new Block("path" , 3, 4),
				new Block("path" , 3, 5),
				new Block("path" , 3, 6),
				new Block("path" , 3, 7),
				new Block("path" , 3, 8),
				new Block("path" , 3, 9),
				new Block("path" , 4, 0),
				new Block("path" , 4, 1),
				new Block("path" , 4, 2),
				new Block("path" , 4, 3),
				new Block("sand" , 4, 4),
				new Block("sand" , 4, 5),
				new Block("sand" , 4, 6),
				new Block("sand" , 4, 7),
				new Block("sand" , 4, 8),
				new Block("sand" , 4, 9),
				new Block("sand" , 5, 0),
				new Block("sand" , 5, 1),
				new Block("sand" , 5, 2),
				new Block("plank" , 5, 3),
				new Block("plank" , 5, 4),
				new Block("plank" , 5, 5),
				new Block("plank" , 5, 6),
				new Block("plank" , 5, 7),
				new Block("plank" , 5, 8),
				new Block("plank" , 5, 9),
				new Block("plank" , 6, 0),
				new Block("plank" , 6, 1),
				new Block("plank" , 6, 2),
				new Block("plank" , 6, 3),
				new Block("plank" , 6, 4),
				new Block("plank" , 6, 5),
				new Block("plank" , 6, 6),
				new Block("plank" , 6, 7),
				new Block("plank" , 6, 8),
				new Block("plank" , 6, 9),
				new Block("plank" , 7, 0),
				new Block("plank" , 7, 1),
				new Block("plank" , 7, 2),
				new Block("plank" , 7, 3),
				new Block("plank" , 7, 4),
				new Block("sand" , 7, 5),
				new Block("sand" , 7, 6),
				new Block("sand" , 7, 7),
				new Block("sand" , 7, 8),
				new Block("sand" , 7, 9),
				new Block("sand" , 8, 0),
				new Block("sand" , 8, 1),
				new Block("sand" , 8, 2),
				new Block("sand" , 8, 3),
				new Block("sand" , 8, 4),
				new Block("sand" , 8, 5),
				new Block("sand" , 8, 6),
				new Block("sand" , 8, 7),
				new Block("sand" , 8, 8),
				new Block("sand" , 8, 9),
				new Block("sand" , 9, 0),
				new Block("sand" , 9, 1),
				new Block("sand" , 9, 2),
				new Block("sand" , 9, 3),
				new Block("sand" , 9, 4),
				new Block("sand" , 9, 5),
				new Block("sand" , 9, 6),
				new Block("sand" , 9, 7),
				new Block("sand" , 9, 8),
				new Block("sand" , 9, 9),
				new ScenePortal(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "cactus1", -1, 4, "Test Scene", 0, 0));

	}
}