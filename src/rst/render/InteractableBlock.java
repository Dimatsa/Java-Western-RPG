/*
 * InteractableBlock.java
 * Deals with interactable blocks
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.render;

import rst.scene.Interactable;
import rst.scene.Scene;

public class InteractableBlock extends HittableBlock implements Interactable {

	private Runnable action, collide;
	private final boolean tough;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */	
	public InteractableBlock(boolean tough, int sceneWidth, int sceneHeight, String textureName, int x, int y) {
		this(tough, sceneWidth, sceneHeight, textureName, x, y, 1, 1);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public InteractableBlock(boolean tough, int sceneWidth, int sceneHeight, String textureName, int x, int y, int width, int height) {
		super(sceneWidth, sceneHeight, textureName, x, y, width, height);
		
		this.tough = tough;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public InteractableBlock onInteract(Runnable action) {
		this.action = action;
		return this;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public InteractableBlock onCollide(Runnable collide) {
		this.collide = collide;
		return this;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public boolean[] getSides() {
		return new boolean[] { true, true, true, true };
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void performAction(Scene scene) {
		if(action != null) {
			action.run();
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void performContact(Scene scene) {
		if(collide != null) {
			collide.run();
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void performHit(Scene scene) {
		if(!tough) {
			scene.removeItem(this);
		}
	}
}
