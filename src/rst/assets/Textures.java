package rst.assets;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JProgressBar;

public class Textures extends AssetRegistry<Texture>{

	private static final String[] names = {
			
	};
	
	public Textures(JProgressBar progress) {
		super(progress, "image", "png", names);
	}

	@Override
	protected Texture[] newArray(int length) {
		return new Texture[length];
	}

	@Override
	protected Texture load(String name, InputStream in) throws IOException {
		return new Texture(name, in);
	}

}
