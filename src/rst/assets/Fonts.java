/*
 * Fonts.java
 * Keeps track of fonts
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.assets;

import java.io.IOException;
import java.io.InputStream;

public class Fonts extends AssetRegistry<Font> {
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private static final String[] names = {
			"Montserrat-Regular"
	};
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Fonts() {
		super("font", "ttf", names);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	protected Font[] newArray(int length) {
		return new Font[length];
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	protected Font load(String name, InputStream in) throws IOException {
		return new Font(name, in);
	}

}
