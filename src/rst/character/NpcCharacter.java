/*
 * NPCCharacter.java
 * Defines an NPC
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.character;

public class NpcCharacter extends Character {
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public NpcCharacter(String firstName, String lastName, int gender, int strength, double speed, int intelligence,
			int drunkeness, double gunSpeed, int gunDamage, CharacterSprite sprite) {
		super(firstName, lastName, gender, strength, speed, intelligence, drunkeness, gunSpeed, gunDamage, sprite);
	}
}
