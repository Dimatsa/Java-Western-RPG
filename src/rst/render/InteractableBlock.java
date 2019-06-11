package rst.render;

import rst.scene.Interactable;

public class InteractableBlock extends HittableBlock implements Interactable {

	private Runnable action;
	
	public InteractableBlock(int sceneWidth, int sceneHeight, String textureName, int x, int y) {
		super(sceneWidth, sceneHeight, textureName, x, y);
	}

	public InteractableBlock onInteract(Runnable action) {
		this.action = action;
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
}
