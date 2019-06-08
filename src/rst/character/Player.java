package rst.character;

import java.awt.event.KeyEvent;

import rst.assets.AssetRegistry;
import rst.render.CameraFollowable;
import rst.render.Coordinates;
import rst.render.Input;
import rst.render.Renderable;
import rst.scene.Scene;

public class Player extends Character implements CameraFollowable {

	private long lastTimeStamp = -1;
	
	public Player() {
		super("Connor", "Adams", Character.MALE, 0, 0, 99, 100, 75, 10, AssetRegistry.getTextures().get("mainCharacterForward"));
		
		location.x = Renderable.STANDARD_WIDTH / 2;
		location.y = Renderable.STANDARD_HEIGHT / 2;
	}

	@Override
	public Coordinates getLocation() {
		return location;
	}

	@Override
	protected void updateLocation(Input input, Scene scene) {
		if(lastTimeStamp == -1) {
			lastTimeStamp = System.nanoTime();
		}
		
		long current = System.nanoTime();
		double delta = (current - lastTimeStamp) / 1000000000.0;
		lastTimeStamp = current;
		
		double speed;
		if(input.isKeyDown(KeyEvent.VK_SHIFT)) {
			speed = 500;
		}
		else {
			speed = 100;
		}
		
		if(input.isKeyDown(KeyEvent.VK_W)) {
			location.y -= delta * speed;
		}
		if(input.isKeyDown(KeyEvent.VK_S)) {
			location.y += delta * speed;
		}
		if(input.isKeyDown(KeyEvent.VK_A)) {
			location.x -= delta * speed;
		}
		if(input.isKeyDown(KeyEvent.VK_D)) {
			location.x += delta * speed;
		}
		
		location.x = Math.min(Math.max(location.x, 25 + Renderable.STANDARD_WIDTH / 2 - scene.getWidth() / 2), Renderable.STANDARD_WIDTH / 2 + scene.getWidth() / 2 - 25);
		location.y = Math.min(Math.max(location.y, 25 + Renderable.STANDARD_HEIGHT / 2 - scene.getHeight() / 2), Renderable.STANDARD_HEIGHT / 2 + scene.getHeight() / 2 - 25);
	}
	
	@Override
	public int getRenderPriority() {
		return Integer.MIN_VALUE;
	}
}
