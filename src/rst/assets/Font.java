package rst.assets;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Font extends Asset {
	
	private final java.awt.Font font;
	
	Font(String name, InputStream in) {
		super(name);
		
		java.awt.Font font = null;
		
		try {
			font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, in);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		this.font = font;
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public java.awt.Font getFont() {
		return font;
	}
}
