package rst.character;

import com.sun.prism.Texture;

import rst.assets.Sound;

public abstract class Character {
	
	final static int MALE = 0;
	final static int FEMALE = 1;
	
	String firstName;
	String lastName;
	int gender;
	Texture sprite;
	int hp = 100;
	int strength;
	double speed;
	int intelligence;
	int drunkeness;
	double gunSpeed;
	int gunDamage;
	Sound hurt1;
	Sound hurt2;
	
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
	
	
}
