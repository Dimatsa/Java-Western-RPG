/*
 * Sounds.java
 * Keeps track of sounds
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.assets;

import java.io.IOException;
import java.io.InputStream;

public class Sounds extends AssetRegistry<Sound> {

	private static final String[] names = {
			"test",
			"town",
			"saloon"
	};
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Sounds() {
		super("sound", "wav", names);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	protected Sound[] newArray(int length) {
		return new Sound[length];
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	protected Sound load(String name, InputStream in) throws IOException {
		return new Sound(name, in);
	}

}
