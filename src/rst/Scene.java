package rst;

import rst.assets.Sound;
import rst.assets.Texture;

public class Scene {
	
	Texture background;
	int xSize;
	int ySize;
	int xPlayerPosition;
	int yPlayerPosition;
	int xCameraPosition;
	int yCameraPosition;
	Sound ambientSound;
	
	public Scene(Texture background, int xSize, int ySize)
	{
		this.background = background;
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	public void enterScene(int xPlayerPosition, int yPlayerPosition)
	{
		this.xPlayerPosition = xPlayerPosition;
		this.yPlayerPosition = yPlayerPosition;
		this.xCameraPosition = xPlayerPosition;
		this.yCameraPosition = xPlayerPosition;
	}
}
