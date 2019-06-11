package rst.scene;

import rst.render.Block;

public class DoubleCactus extends Block {

	public DoubleCactus(int x, int y) {
		super("cactus1", x, y, 1, 2);
	}
	
	@Override
	public int getRenderPriority() {
		return 9;
	}

}
