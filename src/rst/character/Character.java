/*
 * Character.java
 * Defines a character
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.character;

import java.awt.Graphics2D;

import rst.assets.Sound;
import rst.assets.Texture;
import rst.render.Bounds;
import rst.render.Coordinates;
import rst.render.Input;
import rst.render.Renderable;
import rst.render.SceneRenderable;
import rst.scene.Interactable;
import rst.scene.Scene;

public abstract class Character implements SceneRenderable, Interactable {
	
	public final static int MALE = 0;
	public final static int FEMALE = 1;
	
	private final String firstName;
	private final String lastName;
	private final int gender;
	private final CharacterSprite sprite;
	private int hp = 100;
	private int strength;
	private double speed;
	private int intelligence;
	private int drunkeness;
	private double gunSpeed;
	private int gunDamage;
	private Sound hurt1;
	private Sound hurt2;
	
	protected Coordinates location;
	protected Bounds bounds;
	protected int direction = CharacterSprite.DOWN;
	protected double currentSpeed;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Character (String firstName, String lastName, int gender, int strength, double speed, int intelligence, int drunkeness, double gunSpeed, int gunDamage, CharacterSprite sprite)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.strength = strength;
		this.speed = speed;
		this.intelligence = intelligence;
		this.gunSpeed = gunSpeed;
		this.gunDamage = gunDamage;
		this.sprite = sprite;
		
		location = new Coordinates();
		bounds = new Bounds();
		bounds.a = new Coordinates();
		bounds.a.x = location.x - 20;
		bounds.a.y = location.y - 40;
		bounds.b = new Coordinates();
		bounds.b.x = location.x + 20;
		bounds.b.y = location.y + 40;
		
		if(gender == MALE)
		{
			//Retrieve male sounds for hurt 1 and hurt 2
		}
		else
		{
			//Retrieve female sounds for hurt1 and hurt 2
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void damaged(int damage)
	{
		if(damage > 0)
		{
			hp -= damage;
			playHurtSound();
			if(hp < 1)
			{
				die();
			}
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void die()
	{
		
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private void playHurtSound()
	{
		//Randomly generates whether to play first or second hurt sound based on gender
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getGunDamage()
	{
		return gunDamage;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Texture getSprite() {
		return sprite;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getStrength() {
		return strength;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public double getSpeed() {
		return speed;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getIntelligence() {
		return intelligence;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getDrunkeness() {
		return drunkeness;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public double getGunSpeed() {
		return gunSpeed;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Sound getHurt1() {
		return hurt1;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Sound getHurt2() {
		return hurt2;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected void updateLocation(Input input, Scene scene) {}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void render(Graphics2D g, Input input, Scene scene) {
		Coordinates camLoc = scene.getCameraLocation();
		double camX = camLoc.x - Renderable.STANDARD_WIDTH / 2.0;
		double camY = camLoc.y - Renderable.STANDARD_HEIGHT / 2.0;
		
		double coordX = location.x;
		double coordY = location.y;

		sprite.setFacing(direction);
		
		Texture t;
		
		if(currentSpeed != 0) {
			sprite.setTime((int) (100000/currentSpeed));
			
			t = sprite;
		}
		else {
			t = sprite.getCurrentAnimation().getTexture(0);
		}
		t.draw(g, (int) ((coordX - 20 - camX) + 0.5), (int) ((coordY - 40 - camY) + 0.5), 40, 80);
		
		updateLocation(input, scene);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public int getRenderPriority() {
		return 0;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public Bounds getBounds() {
		return bounds;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public boolean[] getSides() {
		return new boolean[] { true, true, true, true };
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void performHit(Scene scene) {
		hp -= 5;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void performContact(Scene scene) {}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void performAction(Scene scene) {}
}
