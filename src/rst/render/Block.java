package rst.render;

import java.awt.Graphics2D;

import rst.assets.AssetRegistry;
import rst.assets.Texture;
import rst.scene.Scene;

public class Block implements SceneRenderable {

	public static final int GRID_SIZE = 50;
	
	private final Texture texture;
	private final int x, y;
	
	public Block(String textureName, int x, int y) {
		this.texture = AssetRegistry.getTextures().get(textureName);
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void render(Graphics2D g, Input input, double xScaler, double yScaler, int width, int height,
			Scene scene) {
		Coordinates camLoc = scene.getCameraLocation();
		double camX = camLoc.x - Renderable.STANDARD_WIDTH / 2.0;
		double camY = camLoc.y - Renderable.STANDARD_HEIGHT / 2.0;
		
		double coordX = x * GRID_SIZE;
		double coordY = y * GRID_SIZE;
		
		texture.draw(g, (int) (xScaler * (Renderable.STANDARD_WIDTH / 2 - scene.getWidth() / 2 + coordX - camX)), (int) (yScaler * (Renderable.STANDARD_HEIGHT / 2 - scene.getHeight() / 2 + coordY - camY)), (int) (xScaler * GRID_SIZE),(int) (yScaler * GRID_SIZE));
	}
	
	@Override
	public int getRenderPriority() {
		return 9;
	}

}
