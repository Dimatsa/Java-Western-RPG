/*
 * Textures.java
 * Keeps track of textures
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.assets;

import java.io.IOException;
import java.io.InputStream;

public class Textures extends AssetRegistry<Texture>{

	private static final String[] names = {
			"icon16",
			"icon32",
			"icon64",
			"icon128",
			"sand",
			"mainCharacterUp",
			"mainCharacterDown",
			"plank",
			"mainCharacterLeft",
			"mainCharacterRight",
			"path",

			"cactus1",
			"cactus2",
			"fenceVertical",
			"railroad",
			"fenceHorizontalRight",
			"fenceHorizontalLeft",
			"bush1",
			"bush2",
			"bush3",
			"greenArrowUp",
			"greenArrowRight",
			"greenArrowLeft",
			"greenArrowDown",
			"fullheart",
			"emptyheart",
			"saloon"

			
	};
	
	public Textures() {
		super("image", "png", names);
	}

	@Override
	protected Texture[] newArray(int length) {
		return new Texture[length];
	}

	@Override
	protected Texture load(String name, InputStream in) throws IOException {
		return new Texture(name, in);
	}

}
