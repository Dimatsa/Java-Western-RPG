package rst.character;

import java.awt.event.KeyEvent;

import rst.assets.AssetRegistry;
import rst.dialogue.DialoguePanel;
import rst.dialogue.Dialogues;
import rst.render.Animation;
import rst.render.Bounds;
import rst.render.CameraFollowable;
import rst.render.Coordinates;
import rst.render.Input;
import rst.render.RenderPanel;
import rst.render.Renderable;
import rst.scene.Impedance;
import rst.scene.Interactable;
import rst.scene.Scene;

public class Player extends Character implements CameraFollowable {

	private long lastTimeStamp = -1;
	
	private boolean wasInteracting;
	
	private Interactable lastCollided;
	
	private DialoguePanel dialogue;
	private RenderPanel render;

	public Player() {
		super("Connor", "Adams", Character.MALE, 0, 0, 99, 100, 75, 10, makeSprite());

		location.x = Renderable.STANDARD_WIDTH / 2;
		location.y = Renderable.STANDARD_HEIGHT / 2;
		bounds.a.x = location.x - 20;
		bounds.a.y = location.y;
		bounds.b.x = location.x + 20;
		bounds.b.y = location.y + 40;
	}
	
	private static CharacterSprite makeSprite() {
		return new CharacterSprite("Connor Adams", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft")));
	}

	@Override
	public Coordinates getLocation() {
		return location;
	}

	@Override
	protected void updateLocation(Input input, Scene scene) {
		if(hasPanels() && dialogue.isInDialogue()) {
			lastTimeStamp = System.nanoTime();
			return;
		}
		
		if (lastTimeStamp == -1) {
			lastTimeStamp = System.nanoTime();
		}

		long current = System.nanoTime();
		double delta = (current - lastTimeStamp) / 1000000000.0;
		lastTimeStamp = current;

		double speed;
		if (input.isKeyDown(KeyEvent.VK_SHIFT)) {
			speed = 400;
		} else {
			speed = 250;
		}

		double vX = 0, vY = 0;

		boolean moved = false;
		int dX = 0, dY = 0;
		
		if (input.isKeyDown(KeyEvent.VK_W)) {
			moved = true;
			
			dY--;
			
			vY -= speed;
		}
		if (input.isKeyDown(KeyEvent.VK_S)) {
			moved = true;
			
			dY++;
			
			vY += speed;
		}
		if (input.isKeyDown(KeyEvent.VK_A)) {
			moved = true;
			
			dX--;
			
			vX -= speed;
		}
		if (input.isKeyDown(KeyEvent.VK_D)) {
			moved = true;
			
			dX++;
			
			vX += speed;
		}

		if(moved) {
			this.currentSpeed = speed;
		}
		else {
			this.currentSpeed = 0;
		}
		
		if(!moved);
		else if(dX == 0) {
			if(dY == 0 || dY == 1) {
				direction = CharacterSprite.DOWN;
			}
			else {
				direction = CharacterSprite.UP;
			}
		}
		else if(dX == -1) {
			if(dY == 0) {
				direction = CharacterSprite.LEFT;
			}
			else if(dY == 1) {
				direction = CharacterSprite.LEFT_DOWN;
			}
			else {
				direction = CharacterSprite.LEFT_UP;
			}
		}
		else {
			if(dY == 0) {
				direction = CharacterSprite.RIGHT;
			}
			else if(dY == 1) {
				direction = CharacterSprite.RIGHT_DOWN;
			}
			else {
				direction = CharacterSprite.RIGHT_UP;
			}
		}

		AABBResponse soonest;
		do {
			soonest = null;
			
			for (Impedance hitbox : scene.getHitboxes()) {
				if (hitbox != this) {
					AABBResponse resp = sweptAABB(this.getBounds(), hitbox.getBounds(), vX, vY, delta);

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
				Math.max(location.x + vX * delta, 20 + Renderable.STANDARD_WIDTH / 2 - scene.getWidth() / 2),
				Renderable.STANDARD_WIDTH / 2 + scene.getWidth() / 2 - 20);
		location.y = Math.min(
				Math.max(location.y + vY * delta, Renderable.STANDARD_HEIGHT / 2 - scene.getHeight() / 2),
				Renderable.STANDARD_HEIGHT / 2 + scene.getHeight() / 2 - 40);
		
		bounds.a.x = location.x - 20;
		bounds.a.y = location.y;
		bounds.b.x = location.x + 20;
		bounds.b.y = location.y + 40;
		
		Interactable selected = null;
		
		for(Interactable interact : scene.getInteractions()) {
			if(interact != this) {
				if(direction == CharacterSprite.LEFT_UP || direction == CharacterSprite.UP || direction == CharacterSprite.RIGHT_UP) {
					if(bounds.a.y == interact.getBounds().b.y && interact.getBounds().a.x <= location.x && location.x <= interact.getBounds().b.x) {
						selected = interact;
						break;
					}
				}
				if(direction == CharacterSprite.RIGHT_UP || direction == CharacterSprite.RIGHT || direction == CharacterSprite.RIGHT_DOWN) {
					if(bounds.b.x == interact.getBounds().a.x && interact.getBounds().a.y <= location.y && location.y <= interact.getBounds().b.y) {
						selected = interact;
						break;
					}
				}
				if(direction == CharacterSprite.RIGHT_DOWN || direction == CharacterSprite.DOWN || direction == CharacterSprite.LEFT_DOWN) {
					if(bounds.b.y == interact.getBounds().a.y && interact.getBounds().a.x <= location.x && location.x <= interact.getBounds().b.x) {
						selected = interact;
						break;
					}
				}
				if(direction == CharacterSprite.LEFT_DOWN || direction == CharacterSprite.LEFT || direction == CharacterSprite.LEFT_UP) {
					if(bounds.a.x == interact.getBounds().b.x && interact.getBounds().a.y <= location.y && location.y <= interact.getBounds().b.y) {
						selected = interact;
						break;
					}
				}
			}
		}
		
		if(selected != null && input.isKeyDown(KeyEvent.VK_E) && !wasInteracting) {
			selected.performAction();
		}
		
		wasInteracting = input.isKeyDown(KeyEvent.VK_E);
		
		if(lastCollided != selected) {
			lastCollided = selected;

			if(selected != null) {
				selected.performContact();
			}
		}
	}

	private static class AABBResponse {
		private double toi;
		private double xNormal, yNormal;
	}

	private static AABBResponse sweptAABB(Bounds a, Bounds b, double vX, double vY, double delta) {
		double xInvEntry, yInvEntry;
		double xInvExit, yInvExit;

		// find the distance between the objects on the near and far sides for both x
		// and y
		if (vX > 0) {
			xInvEntry = b.a.x - a.b.x;
			xInvExit = b.b.x - a.a.x;
		} else {
			xInvEntry = b.b.x - a.a.x;
			xInvExit = b.a.x - a.b.x;
		}

		if (vY > 0) {
			yInvEntry = b.a.y - a.b.y;
			yInvExit = b.b.y - a.a.y;
		} else {
			yInvEntry = b.b.y - a.a.y;
			yInvExit = b.a.y - a.b.y;
		}

		// find time of collision and time of leaving for each axis (if statement is to
		// prevent divide by zero)
		double xEntry, yEntry;
		double xExit, yExit;

		if (vX == 0) {
			xEntry = Double.NEGATIVE_INFINITY;
			xExit = Double.POSITIVE_INFINITY;
		} else {
			xEntry = xInvEntry / vX;
			xExit = xInvExit / vX;
		}

		if (vY == 0) {
			yEntry = Double.NEGATIVE_INFINITY;
			yExit = Double.POSITIVE_INFINITY;
		} else {
			yEntry = yInvEntry / vY;
			yExit = yInvExit / vY;
		}

		if (yEntry > delta) {
			yEntry = Double.NEGATIVE_INFINITY;
		}
		if (xEntry > delta) {
			xEntry = Double.NEGATIVE_INFINITY;
		}

		// find the earliest/latest times of collision
		double entryTime = Math.max(xEntry, yEntry);
		double exitTime = Math.min(xExit, yExit);

		AABBResponse resp = new AABBResponse();
		resp.toi = delta;

		if (entryTime > exitTime) {
			return resp; // This check was correct.
		}
		if (xEntry < 0 && yEntry < 0) {
			return resp;
		}
		if (xEntry < 0) {
			// Check that the bounding box started overlapped or not.
			if (a.b.x <= b.a.x || a.a.x >= b.b.x) {
				return resp;
			}
		}
		if (yEntry < 0) {
			// Check that the bounding box started overlapped or not.
			if (a.b.y <= b.a.y || a.a.y >= b.b.y) {
				return resp;
			}
		}

		resp.toi = entryTime;

		// calculate normal of collided surface
		if (xEntry > yEntry) {
			if (xInvEntry < 0) {
				resp.xNormal = 1.0f;
				resp.yNormal = 0.0f;
			} else {
				resp.xNormal = -1.0f;
				resp.yNormal = 0.0f;
			}
		} else {
			if (yInvEntry < 0.0f) {
				resp.xNormal = 0.0f;
				resp.yNormal = 1.0f;
			} else {
				resp.xNormal = 0.0f;
				resp.yNormal = -1.0f;
			}
		}

		// return the time of collision
		return resp;
	}

	public void startDialogue(String dialogName) {
		if(hasPanels()) {
			dialogue.setDialogue(Dialogues.getDialogues().getDialogue(dialogName));
		}
	}
	
	@Override
	public int getRenderPriority() {
		return Integer.MIN_VALUE;
	}
	
	public void setPanels(RenderPanel renderPanel, DialoguePanel dialoguePanel) {
		this.dialogue = dialoguePanel;
		this.render = renderPanel;
	}
	
	public boolean hasPanels() {
		return dialogue != null && render != null;
	}
	
	public void setScene(Scene newScene, Coordinates loc) {
		if(hasPanels()) {
			this.location.x = loc.x;
			this.location.y = loc.y;
			
			render.setScene(newScene);
		}
		
	}
}
