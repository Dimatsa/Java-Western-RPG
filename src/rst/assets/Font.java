/*
 * Font.java
 * Deals with font
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.assets;


import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Font extends Asset {
	
	private final java.awt.Font font;
	/**
	 * Executes the following commands
	 * pre: none
	 * post: the commands have been executed
	 */
	Font(String name, InputStream in) {
		super(name);
		
		java.awt.Font font = null;
		
		try {
			font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, in);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		this.font = font;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public java.awt.Font getFont() {
		return font;
	}
}
