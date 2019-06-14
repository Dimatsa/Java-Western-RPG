package rst.scene;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.dialogue.DialogueStarter;
import rst.render.Block;
import rst.render.CameraFollowable;
import rst.render.InteractableBlock;

public class RailwayStation extends Scene {

	public RailwayStation() {
		super("plank", null, 10, 10, AssetRegistry.getSounds().get("test"),
				(CameraFollowable) Characters.getCharacters().getCharacter("Connor Adams"), 
				"RailwayStation", Characters.getCharacters().getCharacter("Connor Adams"),
				new InteractableBlock(true, Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 0, 0).onInteract(new DialogueStarter("testDialogue")),
				
				new ScenePortal(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "cactus1", -1, 6, "Town", 0, 0));

	}
}