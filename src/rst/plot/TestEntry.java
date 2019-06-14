/*
 * TestEntry.java
 * Allows for a test entry
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.plot;

import rst.character.Characters;
import rst.character.CompoundNpcPath;
import rst.character.LinearNpcPath;
import rst.character.NpcCharacter;

public class TestEntry extends PlotEntry {
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */

	public TestEntry(String requirement, String name) {
		super(requirement, name);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void onStart() {
		((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setTarget(Characters.getCharacters().getCharacter("Connor Adams"));
		((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setMovement(new CompoundNpcPath(new LinearNpcPath(-750, 0, 10, 100), new LinearNpcPath(0, -500, 10, 100)));
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void onEnd() {}
	
	@Override
	public boolean periodic() {
		if(!((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).isTargetting(Characters.getCharacters().getCharacter("Connor Adams"))) {
			((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setTarget(Characters.getCharacters().getCharacter("Connor Adams"));
		}
		
		return (Characters.getCharacters().getCharacter("Toby Larkin")).getHp() <= 0;
	}

}
