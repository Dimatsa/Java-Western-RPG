package rst.render;

import java.awt.Graphics2D;

import rst.scene.Scene;

public interface SceneRenderable extends Comparable<SceneRenderable> {

	void render(Graphics2D graphics, Input input, double xScaler, double yScaler, int width, int height, Scene scene);
	int getRenderPriority();
	
	@Override
	default int compareTo(SceneRenderable other) {
		return Integer.compare(other.getRenderPriority(), getRenderPriority());
	}
}
