/*
 * Animation.java
 * Deals with animations
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
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
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Animation(int transitionTime, String name, int numberImages) {
		this(transitionTime, fromName(name, numberImages));
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Animation(int transitionTime, Texture...textures) {
		super(textures[0].getName(), textures[0].getImage());
		this.textures = textures;
		timer = new Timer(transitionTime, this);
		timer.start();
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private static Texture[] fromName(String name, int number) {
		Texture[] textures = new Texture[number];
		
		for(int i = 0; i < number; i++) {
			textures[i] = AssetRegistry.getTextures().get(name + "$" + i);
		}
		
		return textures;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Texture getTexture(int textureIndex) {
		return textures[textureIndex];
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(index + 1 == textures.length) {
			index = 0;
		}
		else {
			++index;
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void draw(Graphics g, int x, int y, int width, int height) {
		draw(g, x, y, width, height, index);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public BufferedImage getImage() {
		return getImage(index);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void draw(Graphics g, int x, int y, int width, int height, int index) {
		textures[index].draw(g, x, y, width, height);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public BufferedImage getImage(int index) {
		return textures[index].getImage();
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void setTime(int delay) {
		timer.setDelay(delay);
	}
}
