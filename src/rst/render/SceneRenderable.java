package rst.render;

import java.awt.Graphics2D;

import rst.scene.Scene;

public interface SceneRenderable {

	void render(Graphics2D graphics, Input input, double xScaler, double yScaler, int width, int height, Scene scene);
}
