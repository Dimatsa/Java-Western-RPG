package rst.scene;

import rst.render.HittableBlock;

public class DoubleCactus extends HittableBlock {

	public DoubleCactus(int sceneWidth, int sceneHeight, int x, int y) {
		super(sceneWidth, sceneHeight, "cactus1", x, y, 1, 2);
	}
	
	@Override
	public int getRenderPriority() {
		return 9;
	}

}
