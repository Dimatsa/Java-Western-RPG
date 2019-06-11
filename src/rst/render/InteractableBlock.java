package rst.render;

import rst.scene.Interactable;

public class InteractableBlock extends HittableBlock implements Interactable {

	private Runnable action, collide;
	
	public InteractableBlock(int sceneWidth, int sceneHeight, String textureName, int x, int y) {
		super(sceneWidth, sceneHeight, textureName, x, y);
	}

	public InteractableBlock(int sceneWidth, int sceneHeight, String textureName, int x, int y, int width, int height) {
		super(sceneWidth, sceneHeight, textureName, x, y, width, height);
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
	public void performAction() {
		if(action != null) {
			action.run();
		}
	}

	@Override
	public void performContact() {
		if(collide != null) {
			collide.run();
		}
	}
}
