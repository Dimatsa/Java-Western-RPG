package rst.assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Texture extends Asset {
	
	private final BufferedImage image;
	
	public Texture(String name, InputStream in) throws IOException {
		super(name);
		image = ImageIO.read(in);
	}
	
	public void draw(Graphics g, int x, int y, int width, int height) {
		g.drawImage(image, x, y, width, height, null);
	}

}
