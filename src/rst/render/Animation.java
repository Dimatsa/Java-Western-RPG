package rst.render;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import rst.assets.AssetRegistry;
import rst.assets.Texture;

public class Animation extends Texture implements ActionListener {
	
	private final Texture[] textures;
	private final Timer timer;
	
	private int index = 0;
	
	public Animation(int transitionTime, String name, int numberImages) {
		this(transitionTime, fromName(name, numberImages));
	}
	
	public Animation(int transitionTime, Texture...textures) {
		super(textures[0].getName(), textures[0].getImage());
		this.textures = textures;
		timer = new Timer(transitionTime, this);
		timer.start();
	}
	
	private static Texture[] fromName(String name, int number) {
		Texture[] textures = new Texture[number];
		
		for(int i = 0; i < number; i++) {
			textures[i] = AssetRegistry.getTextures().get(name + "$" + i);
		}
		
		return textures;
	}
	
	public Texture getTexture(int textureIndex) {
		return textures[textureIndex];
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(index + 1 == textures.length) {
			index = 0;
		}
		else {
			++index;
		}
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int width, int height) {
		draw(g, x, y, width, height, index);
	}

	@Override
	public BufferedImage getImage() {
		return getImage(index);
	}
	
	public void draw(Graphics g, int x, int y, int width, int height, int index) {
		textures[index].draw(g, x, y, width, height);
	}

	public BufferedImage getImage(int index) {
		return textures[index].getImage();
	}
	
	public void setTime(int delay) {
		timer.setDelay(delay);
	}
}
