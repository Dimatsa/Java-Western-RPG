package rst.scene;

import rst.render.HittableBlock;

public class Building extends HittableBlock {

	public Building(int sceneWidth, int sceneHeight, String textureName, int x, int y, int width, int height) {
		super(sceneWidth, sceneHeight, textureName, x, y, width, height);
	}

	@Override
	public int getRenderPriority() {
		return 5;
	}
}
