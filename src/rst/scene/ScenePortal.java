package rst.scene;

import rst.character.Characters;
import rst.character.Player;
import rst.render.Coordinates;
import rst.render.InteractableBlock;

public class ScenePortal extends InteractableBlock {

	private final String otherScene;
	private final Coordinates newCoords;
	
	public ScenePortal(int width, int height, String textureName, int x, int y, String otherScene, int newX, int newY) {
		super(width, height, textureName, x, y, 1, 2);
		super.onCollide(this::updateLocation);
		
		this.otherScene = otherScene;
		this.newCoords = new Coordinates();
		this.newCoords.x = newX;
		this.newCoords.y = newY;
	}
	
	private void updateLocation() {
		((Player)Characters.getCharacters().getCharacter("Connor Adams")).setScene(Scenes.getScenes().getScene(otherScene), newCoords);
		
	}
}
