package rst.scene;

import java.util.ArrayList;
import java.util.List;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.render.Block;
import rst.render.CameraFollowable;
import rst.render.Renderable;

public class TestScene extends Scene {

	public TestScene() {
		super(AssetRegistry.getTextures().get("sand"), Block.GRID_SIZE * 10, Block.GRID_SIZE * 10, AssetRegistry.getSounds().get("test"),
				(CameraFollowable) Characters.getCharacters().getCharacter("Connor Adams"), 
				"Test Scene", makeBlocks(10, 10), Characters.getCharacters().getCharacter("Connor Adams"));
				
		
}
	
		private static Block[] makeBlocks(int length, int width) {
			Block[][] blocks = new Block[length][width];
			
			
			return collapseArray(blocks);
		}
		
		private static Block[] collapseArray(Block[][] blocks) {
			List<Block> collapsed = new ArrayList<Block>();
			
			for(int i = 0; i < blocks.length; i++) {
				for(int j = 0; j < blocks[i].length; j++) {
					if(blocks[i][j] != null) {
						collapsed.add(blocks[i][j]);
					}
				}
			}
			
			return collapsed.toArray(new Block[0]);
		}
		
		private Block[] combine(Renderable[] items, Renderable... others) {
			Renderable[] combined = new Renderable[items.length + others.length];
			
			System.arraycopy(items, 0, combined, 0, items.length);
			System.arraycopy(others, 0, , destPos, length);
		}
}