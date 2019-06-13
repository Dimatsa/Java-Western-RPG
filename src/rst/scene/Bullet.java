package rst.scene;

import java.awt.Graphics2D;

import rst.assets.AssetRegistry;
import rst.assets.Texture;
import rst.character.CharacterSprite;
import rst.render.AABB;
import rst.render.AABB.AABBResponse;
import rst.render.Bounds;
import rst.render.Coordinates;
import rst.render.Input;
import rst.render.Renderable;
import rst.render.SceneRenderable;

public class Bullet implements SceneRenderable, Interactable {

	private static final double SPEED = 2500.0;
	
	protected Coordinates location;
	protected Bounds bounds;
	protected final double vX, vY;
	private final Impedance source;
	boolean remove;
	
	private long lastTimeStamp = -1;
	
	private final Texture texture;
	
	public Bullet(double x, double y, double x2, double y2, Impedance source) {
		texture = AssetRegistry.getTextures().get("cactus2");
		this.source = source;
		
		double scalar = SPEED / Math.hypot(x2 - x, y2 - y);
		
		vX = scalar * (x2 - x);
		vY = scalar * (y2 - y);
		
		location = new Coordinates();
		location.x = x;
		location.y = y;
		bounds = new Bounds();
		bounds.a = new Coordinates();
		bounds.a.x = location.x - 5;
		bounds.a.y = location.y - 5;
		bounds.b = new Coordinates();
		bounds.b.x = location.x + 5;
		bounds.b.y = location.y + 5;
	}
	
	@Override
	public void render(Graphics2D g, Input input, Scene scene) {
		Coordinates camLoc = scene.getCameraLocation();
		double camX = camLoc.x - Renderable.STANDARD_WIDTH / 2.0;
		double camY = camLoc.y - Renderable.STANDARD_HEIGHT / 2.0;
		
		int coordX = (int) ((location.x - 5 - camX) + 0.5);
		int coordY = (int) ((location.y - 5 - camY) + 0.5);
		
		if(coordX + 10 >= 0 && coordX <= Renderable.STANDARD_WIDTH &&
				coordY + 10 >= 0 && coordY <= Renderable.STANDARD_HEIGHT) {
			texture.draw(g, coordX, coordY, 10, 10);
		}
		
		updateLocation(input, scene);
	}
	
	private void updateLocation(Input input, Scene scene) {
		if(remove) {
			scene.removeItem(this);
		}
		
		if (lastTimeStamp == -1) {
			lastTimeStamp = System.nanoTime();
		}
		
		long current = System.nanoTime();
		double delta = (current - lastTimeStamp) / 1000000000.0;
		lastTimeStamp = current;
		
		double vX = this.vX;
		double vY = this.vY;

		AABB.AABBResponse soonest;
		do {
			soonest = null;
			
			for (Impedance hitbox : scene.getHitboxes()) {
				if (hitbox != this) {
					AABBResponse resp = AABB.sweptAABB(this.getBounds(), hitbox.getBounds(), vX, vY, delta);

					if (resp.toi < delta && (soonest == null || resp.toi < soonest.toi)) {
						soonest = resp;
					}
				}
			}

			if (soonest != null) {
				if (soonest.xNormal != 0) {
					vX *= soonest.toi / delta;
				} else if (soonest.yNormal != 0) {
					vY *= soonest.toi / delta;
				}
			}
		} while (soonest != null);
		
		location.x = Math.min(
				Math.max(location.x + vX * delta, 5 + Renderable.STANDARD_WIDTH / 2 - scene.getWidth() / 2),
				Renderable.STANDARD_WIDTH / 2 + scene.getWidth() / 2 - 5);
		location.y = Math.min(
				Math.max(location.y + vY * delta, 5 + Renderable.STANDARD_HEIGHT / 2 - scene.getHeight() / 2),
				Renderable.STANDARD_HEIGHT / 2 + scene.getHeight() / 2 - 5);
		
		bounds.a.x = location.x - 5;
		bounds.a.y = location.y - 5;
		bounds.b.x = location.x + 5;
		bounds.b.y = location.y + 5;
		
		boolean collision = false;
		
		for(Impedance hit : scene.getHitboxes()) {
			if(this != hit && source != hit) {
				Impedance selected = null;
				if(bounds.a.y == hit.getBounds().b.y && hit.getBounds().a.x <= location.x && location.x <= hit.getBounds().b.x) {
					selected = hit;
				}
				else if(bounds.b.x == hit.getBounds().a.x && hit.getBounds().a.y <= location.y && location.y <= hit.getBounds().b.y) {
					selected = hit;
				}
				else if(bounds.b.y == hit.getBounds().a.y && hit.getBounds().a.x <= location.x && location.x <= hit.getBounds().b.x) {
					selected = hit;
				}
				else if(bounds.a.x == hit.getBounds().b.x && hit.getBounds().a.y <= location.y && location.y <= hit.getBounds().b.y) {
					selected = hit;
				}
				
				if(selected != null) {
					collision = true;
					if(selected instanceof Interactable) {
						((Interactable)selected).performHit(scene);
					}
				}
			}
		}
		
		if(collision || location.x == 5 + Renderable.STANDARD_WIDTH / 2 - scene.getWidth() / 2 || location.x == Renderable.STANDARD_WIDTH / 2 + scene.getWidth() / 2 - 5
				|| location.y == 5 + Renderable.STANDARD_HEIGHT / 2 - scene.getHeight() / 2 || location.y == Renderable.STANDARD_HEIGHT / 2 + scene.getHeight() / 2 - 5) {
			remove = true;
		}
	}

	public int getBulletDirection() {
		double theta = Math.atan2(vY, vX) / Math.PI;
		int direction;
		
		
		if(theta < 0) {
			theta += 2;
		}
		
		if(0.125 < theta && theta <= 0.375) {
			direction = CharacterSprite.RIGHT_DOWN;
		}
		else if(0.375 < theta && theta <= 0.625) {
			direction = CharacterSprite.DOWN; 
		}
		else if(0.625 < theta && theta <= 0.875) {
			direction = CharacterSprite.LEFT_DOWN;
		}
		else if(0.875 < theta && theta <= 1.125) {
			direction = CharacterSprite.LEFT;
		}
		else if(1.125 < theta && theta <= 1.375) {
			direction = CharacterSprite.LEFT_UP;
		}
		else if(1.375 < theta && theta <= 1.625) {
			direction = CharacterSprite.UP;
		}
		else if(1.625 < theta && theta <= 1.875) {
			direction = CharacterSprite.RIGHT_UP;
		}
		else {
			direction = CharacterSprite.RIGHT;
		}
		
		return direction;
	}
	
	@Override
	public int getRenderPriority() {
		return 1;
	}

	@Override
	public Bounds getBounds() {
		return bounds;
	}

	@Override
	public boolean[] getSides() {
		return new boolean[] {true, true, true, true};
	}

	@Override
	public void performAction(Scene scene) {}

	@Override
	public void performContact(Scene scene) {}

	@Override
	public void performHit(Scene scene) {}
}
