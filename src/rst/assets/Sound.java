package rst.assets;

import java.io.InputStream;

public class Sound extends Asset {
	
	Sound(String name, InputStream in) {
		super(name);
		
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
