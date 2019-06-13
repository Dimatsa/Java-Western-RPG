package rst.render;

import java.awt.Graphics2D;

import rst.assets.AssetRegistry;
import rst.assets.Texture;
import rst.scene.Scene;

public class Block implements SceneRenderable {

	public static final int GRID_SIZE = 50;
	
	private final Texture texture;
	private final int x, y, width, height;
	
	public Block(String textureName, int x, int y) {
		this(textureName, x, y, 1, 1);
	}
	
	public Block(String textureName, int x, int y, int width, int height) {
		this.texture = AssetRegistry.getTextures().get(textureName);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void render(Graphics2D g, Input input, Scene scene) {
		Coordinates camLoc = scene.getCameraLocation();
		
		texture.draw(g, (int) ((Renderable.STANDARD_WIDTH - scene.getWidth() / 2 + x * GRID_SIZE - camLoc.x) + 0.5), (int) ((Renderable.STANDARD_HEIGHT - scene.getHeight() / 2 + y * GRID_SIZE - camLoc.y) + 0.5), GRID_SIZE * width, GRID_SIZE * height);
	}
	
	@Override
	public int getRenderPriority() {
		return 10;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Texture getTexture() {
		return texture;
	}
}
