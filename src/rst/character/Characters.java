/*
 * Characters.java
 * Keeps track of characters
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.character;

import java.util.HashMap;
import java.util.Map;

import rst.assets.AssetRegistry;
import rst.render.Animation;

public class Characters {

	private static Characters characters;
	
	public static void init() {
		if(characters == null) {
			characters = new Characters();
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public static Characters getCharacters() {
		init();
		return characters;
	}
	
	private Map<String, Character> characterMap;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected Characters() {
		characterMap = new HashMap<>();
		
		makeCharacter(new Player());
		
		// Creates Dalton brothers
		makeCharacter(new NpcCharacter("Slimy", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Slimy Dalton", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), -490, 490));
		makeCharacter(new NpcCharacter("Sneaky", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Sneaky Dalton", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), -260, 490));
		makeCharacter(new NpcCharacter("Shifty", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Shifty Dalton", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 0, 490));
		makeCharacter(new NpcCharacter("Snitchy", "Dalton", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Snitchy Dalton", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 210, 510));

		// Creates Earps
		makeCharacter(new NpcCharacter("Marshal Virgil", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Marshal Virgil Earp", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 210, 600));
		makeCharacter(new NpcCharacter("Wyatt", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Wyatt Earp", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 210, 720));
		makeCharacter(new NpcCharacter("Morgan", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Morgan Earp", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 210, 860));
		makeCharacter(new NpcCharacter("Doc Holliday", "Earp", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Doc Holliday Earp", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 210, 950));

		// Creates random characters
		makeCharacter(new NpcCharacter("Ryan", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Ryan Larkin", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 650, 490));
		makeCharacter(new NpcCharacter("Toby", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Toby Larkin", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 1900, 475));
		makeCharacter(new NpcCharacter("Giancarlo", "Salvador", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Giancarlo Salvador", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 800, 460));
		makeCharacter(new NpcCharacter("Steve", "Larkin", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Steve Larkin", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 970, 480));
		makeCharacter(new NpcCharacter("Flinston", "Stone", Character.MALE, 1, 1, 1, 1, 1, 1, new CharacterSprite("Flinston Stone", 
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterUp")),
				new Animation(1000, AssetRegistry.getTextures().get("mainCharacterDown")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterRight")),
				 new Animation(1000, AssetRegistry.getTextures().get("mainCharacterLeft"))), 100, 400));
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private void makeCharacter(Character c) {
		characterMap.put(c.getFirstName() + " " + c.getLastName(), c);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Character getCharacter(String name) {
		return characterMap.get(name);
	}
}
