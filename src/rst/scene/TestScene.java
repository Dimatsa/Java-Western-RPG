package rst.scene;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.render.Block;
import rst.render.CameraFollowable;
import rst.render.HittableBlock;

public class TestScene extends Scene {

	public TestScene() {
		super(AssetRegistry.getTextures().get("sand"), Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, AssetRegistry.getSounds().get("test"),
				(CameraFollowable) Characters.getCharacters().getCharacter("Connor Adams"), 
				"Test Scene", Characters.getCharacters().getCharacter("Connor Adams"),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 0, 0),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 9, 0),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 0, 9),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 9, 9),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 1, 0),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 0, 1),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 2, 3),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 2, 5),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 5, 3),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 1, 0),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 2, 0),
				new HittableBlock(Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, "path", 3, 0));
	}

}
