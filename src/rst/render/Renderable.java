package rst.render;

import java.awt.Graphics2D;

public interface Renderable {
	
	public static final int STANDARD_WIDTH = 1920;
	public static final int STANDARD_HEIGHT = 905;
	
	void render(Graphics2D graphics, Input input);
}
