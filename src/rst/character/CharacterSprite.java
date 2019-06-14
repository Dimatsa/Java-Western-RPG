/*
 * CharacterSprites.java
 * Deals with character sprites
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.character;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rst.assets.Texture;
import rst.render.Animation;

public class CharacterSprite extends Texture {

	public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3,
			LEFT_UP = 4, LEFT_DOWN = 5, RIGHT_UP = 6, RIGHT_DOWN = 7;
	
	private final Animation[] animation;
	private int direction;
	
	public CharacterSprite(String name, Animation up, Animation down, Animation right, Animation left) {
		this(name, up, down, right, left, left, left, right, right);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public CharacterSprite(String name, Animation up, Animation down, Animation right, Animation left, Animation leftUp, Animation leftDown, Animation rightUp, Animation rightDown)  {
		super(name, down.getImage(0));
		
		animation = new Animation[8];
		
		animation[UP] = up;
		animation[DOWN] = down;
		animation[RIGHT] = right;
		animation[LEFT] = left;
		animation[LEFT_UP] = leftUp;
		animation[LEFT_DOWN] = leftDown;
		animation[RIGHT_UP] = rightUp;
		animation[RIGHT_DOWN] = rightDown;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void setFacing(int direction) {
		this.direction = direction;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Animation getCurrentAnimation() {
		return animation[direction];
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void draw(Graphics g, int x, int y, int width, int height) {
		animation[direction].draw(g, x, y, width, height);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public BufferedImage getImage() {
		return animation[direction].getImage();
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void setTime(int delay) {
		for(Animation m : animation) {
			m.setTime(delay);
		}
	}
	
	public static int pointToDirection(double x, double y) {
		double theta = Math.atan2(y, x) / Math.PI;
		int direction;
		
		
		if(theta < 0) {
			theta += 2;
		}
		
		if(0.125 < theta && theta <= 0.375) {
			direction = CharacterSprite.RIGHT_DOWN;
		}
		else if(0.375 < theta && theta <= 0.625) {
			direction = CharacterSprite.DOWN; 
		}
		else if(0.625 < theta && theta <= 0.875) {
			direction = CharacterSprite.LEFT_DOWN;
		}
		else if(0.875 < theta && theta <= 1.125) {
			direction = CharacterSprite.LEFT;
		}
		else if(1.125 < theta && theta <= 1.375) {
			direction = CharacterSprite.LEFT_UP;
		}
		else if(1.375 < theta && theta <= 1.625) {
			direction = CharacterSprite.UP;
		}
		else if(1.625 < theta && theta <= 1.875) {
			direction = CharacterSprite.RIGHT_UP;
		}
		else {
			direction = CharacterSprite.RIGHT;
		}
		
		return direction;
	}
}
