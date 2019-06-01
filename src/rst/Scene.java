package rst;

import com.sun.prism.Texture;

import rst.assets.Sound;

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
