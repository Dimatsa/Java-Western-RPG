/*
 * DoubleCactus.java
 * Creates a double cactus
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.scene;

import rst.render.InteractableBlock;

public class DoubleCactus extends InteractableBlock {
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public DoubleCactus(int sceneWidth, int sceneHeight, int x, int y) {
		super(false, sceneWidth, sceneHeight, "cactus1", x, y, 1, 2);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public int getRenderPriority() {
		return 9;
	}

}
