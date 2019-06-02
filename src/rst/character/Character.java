package rst.character;

import rst.assets.Sound;
import rst.assets.Texture;

public abstract class Character {
	
	public final static int MALE = 0;
	public final static int FEMALE = 1;
	
	private final String firstName;
	private final String lastName;
	private final int gender;
	private final Texture sprite;
	private int hp = 100;
	private int strength;
	private double speed;
	private int intelligence;
	private int drunkeness;
	private double gunSpeed;
	private int gunDamage;
	private Sound hurt1;
	private Sound hurt2;
	
	public Character (String firstName, String lastName, int gender, int strength, double speed, int intelligence, int drunkeness, double gunSpeed, int gunDamage)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.strength = strength;
		this.speed = speed;
		this.intelligence = intelligence;
		this.gunSpeed = gunSpeed;
		this.gunDamage = gunDamage;
		this.sprite = null;
		
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
}
