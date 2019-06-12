package rst.assets;

import java.io.IOException;
import java.io.InputStream;

public class Sounds extends AssetRegistry<Sound> {

	private static final String[] names = {
			"test",
			"town"
	};
	
	public Sounds() {
		super("sound", "wav", names);
	}

	@Override
	protected Sound[] newArray(int length) {
		return new Sound[length];
	}

	@Override
	protected Sound load(String name, InputStream in) throws IOException {
		return new Sound(name, in);
	}

}
