package rst.assets;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JProgressBar;

public class Fonts extends AssetRegistry<Font> {

	private static final String[] names = {
			"Montserrat-Regular"
	};
	
	public Fonts(JProgressBar progress) {
		super(progress, "font", "ttf", names);
	}

	@Override
	protected Font[] newArray(int length) {
		return new Font[length];
	}

	@Override
	protected Font load(String name, InputStream in) throws IOException {
		return new Font(name, in);
	}

}
