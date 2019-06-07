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
	
	public static Characters getCharacters() {
		init();
		return characters;
	}
	
	private Map<String, Character> characterMap;
	
	protected Characters() {
		characterMap = new HashMap<>();
		
		makeCharacter(new Player());
	}
	
	private void makeCharacter(Character c) {
		characterMap.put(c.getFirstName() + " " + c.getLastName(), c);
	}

	public Character getCharacter(String name) {
		return characterMap.get(name);
	}
}
