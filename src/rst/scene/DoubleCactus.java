package rst.scene;

import rst.render.InteractableBlock;

public class DoubleCactus extends InteractableBlock {

	public DoubleCactus(int sceneWidth, int sceneHeight, int x, int y) {
		super(false, sceneWidth, sceneHeight, "cactus1", x, y, 1, 2);
	}
	
	@Override
	public int getRenderPriority() {
		return 9;
	}

}
