package rst.scene;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.render.Block;
import rst.render.CameraFollowable;

public class TestScene extends Scene {

	public TestScene() {
		super(AssetRegistry.getTextures().get("sand"), Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, AssetRegistry.getSounds().get("test"),
				(CameraFollowable) Characters.getCharacters().getCharacter("Connor Adams"), 
				"Test Scene", Characters.getCharacters().getCharacter("Connor Adams"), new Block("path", 0, 0), new Block("path", 9, 0), new Block("path", 0, 9), new Block("path", 9, 9));
	}

}
