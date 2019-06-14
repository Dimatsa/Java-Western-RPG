/*
 * Texture.java
 * Deals with textures
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Texture extends Asset {
	
	private final BufferedImage image;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Texture(String name, InputStream in) throws IOException {
		this(name, ImageIO.read(in));
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected Texture(String name, BufferedImage image) {
		super(name);
		this.image = image;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void draw(Graphics g, int x, int y, int width, int height) {
		g.drawImage(image, x, y, width, height, null);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public BufferedImage getImage() {
		return image;
	}
}
