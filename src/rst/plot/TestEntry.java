package rst.plot;

import rst.character.CharacterSprite;
import rst.character.Characters;
import rst.character.CompoundNpcPath;
import rst.character.LinearNpcPath;
import rst.character.NpcCharacter;

public class TestEntry extends PlotEntry {

	public TestEntry(String requirement) {
		super(requirement);
	}

	@Override
	public void onStart() {
		((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setTarget(Characters.getCharacters().getCharacter("Connor Adams"));
		((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setMovement(new CompoundNpcPath(new LinearNpcPath(600, 0, 10, 100), new LinearNpcPath(0, 600, 10, 100)));
	}

	@Override
	public void onEnd() {
		((NpcCharacter)Characters.getCharacters().getCharacter("Toby Larkin")).setTarget(null);
		Characters.getCharacters().getCharacter("Toby Larkin").setDirection(CharacterSprite.DOWN);
	}

	@Override
	public boolean periodic() {
		return (Characters.getCharacters().getCharacter("Connor Adams")).getHp() <= 0;
	}

}
