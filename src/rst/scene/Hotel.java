package rst.scene;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.dialogue.DialogueStarter;
import rst.render.Block;
import rst.render.CameraFollowable;
import rst.render.InteractableBlock;

public class Hotel extends Scene {

	public Hotel() {
		super("cactus1", 10, 10, AssetRegistry.getSounds().get("test"),
				(CameraFollowable) Characters.getCharacters().getCharacter("Connor Adams"), 
				"Saloon", Characters.getCharacters().getCharacter("Connor Adams"),
				new InteractableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 0, 0).onInteract(new DialogueStarter("testDialogue")),
				
				//Floor
				new Block("plank" , 0, 0),
				new Block("plank" , 0, 1),
				new Block("plank" , 0, 2),
				new Block("plank" , 0, 3),
				new Block("plank" , 0, 4),
				new Block("plank" , 0, 5),
				new Block("plank" , 0, 6),
				new Block("plank" , 0, 7),
				new Block("plank" , 0, 8),
				new Block("plank" , 0, 9),
				new Block("plank" , 1, 0),
				new Block("plank" , 1, 1),
				new Block("plank" , 1, 2),
				new Block("plank" , 1, 3),
				new Block("plank" , 1, 4),
				new Block("plank" , 1, 5),
				new Block("plank" , 1, 6),
				new Block("plank" , 1, 7),
				new Block("plank" , 1, 8),
				new Block("plank" , 1, 9),
				new Block("plank" , 2, 0),
				new Block("plank" , 2, 1),
				new Block("plank" , 2, 2),
				new Block("plank" , 2, 3),
				new Block("plank" , 2, 4),
				new Block("plank" , 2, 5),
				new Block("plank" , 2, 6),
				new Block("plank" , 2, 7),
				new Block("plank" , 2, 8),
				new Block("plank" , 2, 9),
				new Block("plank" , 3, 0),
				new Block("plank" , 3, 1),
				new Block("plank" , 3, 2),
				new Block("plank" , 3, 3),
				new Block("plank" , 3, 4),
				new Block("plank" , 3, 5),
				new Block("plank" , 3, 6),
				new Block("plank" , 3, 7),
				new Block("plank" , 3, 8),
				new Block("plank" , 3, 9),
				new Block("plank" , 4, 0),
				new Block("plank" , 4, 1),
				new Block("plank" , 4, 2),
				new Block("plank" , 4, 3),
				new Block("plank" , 4, 4),
				new Block("plank" , 4, 5),
				new Block("plank" , 4, 6),
				new Block("plank" , 4, 7),
				new Block("plank" , 4, 8),
				new Block("plank" , 4, 9),
				new Block("plank" , 5, 0),
				new Block("plank" , 5, 1),
				new Block("plank" , 5, 2),
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
				new Block("plank" , 7, 5),
				new Block("plank" , 7, 6),
				new Block("plank" , 7, 7),
				new Block("plank" , 7, 8),
				new Block("plank" , 7, 9),
				new Block("plank" , 8, 0),
				new Block("plank" , 8, 1),
				new Block("plank" , 8, 2),
				new Block("plank" , 8, 3),
				new Block("plank" , 8, 4),
				new Block("plank" , 8, 5),
				new Block("plank" , 8, 6),
				new Block("plank" , 8, 7),
				new Block("plank" , 8, 8),
				new Block("plank" , 8, 9),
				new Block("plank" , 9, 0),
				new Block("plank" , 9, 1),
				new Block("plank" , 9, 2),
				new Block("plank" , 9, 3),
				new Block("plank" , 9, 4),
				new Block("plank" , 9, 5),
				new Block("plank" , 9, 6),
				new Block("plank" , 9, 7),
				new Block("plank" , 9, 8),
				new Block("plank" , 9, 9),
				
				new ScenePortal(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "cactus1", -1, 4, "town", 0, 0));

	}
}