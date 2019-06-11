package rst.character;

import java.awt.Graphics2D;

import rst.assets.Sound;
import rst.assets.Texture;
import rst.render.Bounds;
import rst.render.Coordinates;
import rst.render.Input;
import rst.render.Renderable;
import rst.render.SceneRenderable;
import rst.scene.Impedance;
import rst.scene.Scene;

public class Character implements SceneRenderable, Impedance {
	
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
		bounds.a.x = location.x - 10;
		bounds.a.y = location.y - 20;
		bounds.b = new Coordinates();
		bounds.b.x = location.x + 10;
		bounds.b.y = location.y + 20;
		
		if(gender == MALE)
		{
			//Retrieve male sounds for hurt 1 and hurt 2
		}
		else
		{
			//Retrieve female sounds for hurt1 and hurt 2
		}
	}
	
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
	
	public void die()
	{
		
	}
	
	private void playHurtSound()
	{
		//Randomly generates whether to play first or second hurt sound based on gender
	}
	
	public int getGunDamage()
	{
		return gunDamage;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getGender() {
		return gender;
	}

	public Texture getSprite() {
		return sprite;
	}

	public int getHp() {
		return hp;
	}

	public int getStrength() {
		return strength;
	}

	public double getSpeed() {
		return speed;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getDrunkeness() {
		return drunkeness;
	}

	public double getGunSpeed() {
		return gunSpeed;
	}

	public Sound getHurt1() {
		return hurt1;
	}

	public Sound getHurt2() {
		return hurt2;
	}
	
	protected void updateLocation(Input input, Scene scene) {}
	
	@Override
	public void render(Graphics2D g, Input input, double xScaler, double yScaler, int width, int height, Scene scene) {
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
		t.draw(g, (int) (xScaler * (coordX - 10 - camX)), (int) (yScaler * (coordY - 20 - camY)), (int) (xScaler * 20),(int) (yScaler * 40));
		
		updateLocation(input, scene);
	}
	
	@Override
	public int getRenderPriority() {
		return 10;
	}
	
	@Override
	public Bounds getBounds() {
		return bounds;
	}
}
