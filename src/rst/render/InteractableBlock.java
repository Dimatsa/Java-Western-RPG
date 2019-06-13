package rst.render;

import rst.scene.Interactable;
import rst.scene.Scene;

public class InteractableBlock extends HittableBlock implements Interactable {

	private Runnable action, collide;
	private final boolean tough;
	
	public InteractableBlock(boolean tough, int sceneWidth, int sceneHeight, String textureName, int x, int y) {
		this(tough, sceneWidth, sceneHeight, textureName, x, y, 1, 1);
	}

	public InteractableBlock(boolean tough, int sceneWidth, int sceneHeight, String textureName, int x, int y, int width, int height) {
		super(sceneWidth, sceneHeight, textureName, x, y, width, height);
		
		this.tough = tough;
	}
	
	public InteractableBlock onInteract(Runnable action) {
		this.action = action;
		return this;
	}
	
	public InteractableBlock onCollide(Runnable collide) {
		this.collide = collide;
		return this;
	}
	
	@Override
	public boolean[] getSides() {
		return new boolean[] { true, true, true, true };
	}

	@Override
	public void performAction(Scene scene) {
		if(action != null) {
			action.run();
		}
	}

	@Override
	public void performContact(Scene scene) {
		if(collide != null) {
			collide.run();
		}
	}

	@Override
	public void performHit(Scene scene) {
		if(!tough) {
			scene.removeItem(this);
		}
	}
}
