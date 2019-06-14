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
