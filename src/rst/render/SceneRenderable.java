/*
 * SceneRenderable.java
 * Allows scene to render
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.render;

import java.awt.Graphics2D;

import rst.scene.Scene;

public interface SceneRenderable extends Comparable<SceneRenderable> {
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	void render(Graphics2D graphics, Input input, Scene scene);
	int getRenderPriority();
	
	@Override
	default int compareTo(SceneRenderable other) {
		return Integer.compare(other.getRenderPriority(), getRenderPriority());
	}
}
