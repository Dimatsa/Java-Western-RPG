package rst.plot;

import rst.character.Characters;
import rst.character.CompoundNpcPath;
import rst.character.LinearNpcPath;
import rst.character.NpcCharacter;

public class TestEntry extends PlotEntry {

	public TestEntry(String requirement, String name) {
		super(requirement, name);
	}

	@Override
	public void onStart() {
		((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setTarget(Characters.getCharacters().getCharacter("Connor Adams"));
		((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setMovement(new CompoundNpcPath(new LinearNpcPath(600, 0, 10, 100), new LinearNpcPath(0, 600, 10, 100)));
	}

	@Override
	public void onEnd() {}

	@Override
	public boolean periodic() {
		if(!((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).isTargetting(Characters.getCharacters().getCharacter("Connor Adams"))) {
			((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setTarget(Characters.getCharacters().getCharacter("Connor Adams"));
		}
		
		return (Characters.getCharacters().getCharacter("Toby Larkin")).getHp() <= 0;
	}

}
