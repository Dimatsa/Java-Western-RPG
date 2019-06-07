package rst.scene;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.render.CameraFollowable;

public class TestScene extends Scene {

	public TestScene() {
		super(AssetRegistry.getTextures().get("sand"), 500, 500, AssetRegistry.getSounds().get("test"),
				(CameraFollowable) Characters.getCharacters().getCharacter("Connor Adams"), 
				"Test Scene", Characters.getCharacters().getCharacter("Connor Adams"));
	}

}
