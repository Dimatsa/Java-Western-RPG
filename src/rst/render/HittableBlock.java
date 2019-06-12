package rst.render;

import rst.scene.Impedance;

public class HittableBlock extends Block implements Impedance {

	private final Bounds bounds;
	
	public HittableBlock(int sceneWidth, int sceneHeight, String textureName, int x, int y) {
		this(sceneWidth, sceneHeight, textureName, x, y, 1, 1);
	}
	
	public HittableBlock(int sceneWidth, int sceneHeight, String textureName, int x, int y, int width, int height) {
		super(textureName, x, y, width, height);
		
		bounds = new Bounds();
		bounds.a = new Coordinates();
		bounds.b = new Coordinates();
		
		bounds.a.x = x * Block.GRID_SIZE + Renderable.STANDARD_WIDTH / 2 - sceneWidth / 2;
		bounds.a.y = y * Block.GRID_SIZE + Renderable.STANDARD_HEIGHT / 2 - sceneHeight / 2;
		
		bounds.b.x = Block.GRID_SIZE * width + bounds.a.x;
		bounds.b.y = Block.GRID_SIZE * height + bounds.a.y;
	}

	@Override
	public Bounds getBounds() {
		return bounds;
	}

}
