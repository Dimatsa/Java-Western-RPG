/*
 * ScenePortal.java
 * Creates a scene portal
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.scene;

import rst.character.Characters;
import rst.character.Player;
import rst.render.Coordinates;
import rst.render.InteractableBlock;

public class ScenePortal extends InteractableBlock {

	private final String otherScene;
	private final Coordinates newCoords;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public ScenePortal(int width, int height, String textureName, int x, int y, String otherScene, int newX, int newY) {
		super(true, width, height, textureName, x, y, 1, 1);
		super.onCollide(this::updateLocation);
		
		this.otherScene = otherScene;
		this.newCoords = new Coordinates();
		this.newCoords.x = newX;
		this.newCoords.y = newY;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private void updateLocation() {
		((Player)Characters.getCharacters().getCharacter("Connor Adams")).setScene(Scenes.getScenes().getScene(otherScene), newCoords);
		
	}
}
