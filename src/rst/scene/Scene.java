package rst.scene;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sound.sampled.Clip;

import rst.assets.Sound;
import rst.assets.Texture;
import rst.render.CameraFollowable;
import rst.render.Coordinates;
import rst.render.Input;
import rst.render.Renderable;
import rst.render.SceneRenderable;

public abstract class Scene implements Renderable {
	
	private final Texture background;
	private final int xSize, ySize;
	private final Sound ambientSound;
	private final String name;
	private final List<SceneRenderable> items;
	private final List<Impedance> impedances;
	private final List<Interactable> interactions;
	
	private Clip currentPlaying;
	
	private CameraFollowable camera;
	@SuppressWarnings("unused")
	private Sound overrideAmbientSound;
	
	public Scene(Texture background, int xSize, int ySize, Sound ambientSound, CameraFollowable camera, String name, SceneRenderable... items)
	{
		this.background = background;
		this.xSize = xSize;
		this.ySize = ySize;
		this.ambientSound = ambientSound;
		this.camera = camera;
		this.name = name;
		this.items = new ArrayList<>(Arrays.asList(items));
		Collections.sort(this.items);
		this.impedances = new ArrayList<>();
		this.interactions = new ArrayList<>();
		
		
		for(SceneRenderable item : items) {
			if(item instanceof Impedance) {
				impedances.add((Impedance) item);
			}
		}
		
		for(SceneRenderable item : items) {
			if(item instanceof Interactable) {
				interactions.add((Interactable) item);
			}
		}
	}
	
	public void enterScene() {
		if(ambientSound != null) {
			currentPlaying = ambientSound.startSound(1.0, Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public void leaveScene() {
		if(currentPlaying != null) {
			currentPlaying.stop();
			currentPlaying = null;
		}
	}
	
	@Override
	public void render(Graphics2D g, Input input) {
		Coordinates camLoc = getCameraLocation();
		double camX = camLoc.x - Renderable.STANDARD_WIDTH / 2.0;
		double camY = camLoc.y - Renderable.STANDARD_HEIGHT / 2.0;
		
		background.draw(g, (int) ((Renderable.STANDARD_WIDTH / 2.0 - xSize / 2.0 - camX) + 0.5), (int) ((Renderable.STANDARD_HEIGHT / 2.0 - ySize / 2.0 - camY) + 0.5), xSize, ySize);
		
		for(SceneRenderable item : items) {
			item.render(g, input, this);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Coordinates getCameraLocation() {
		return camera.getLocation();
	}

	public int getWidth() {
		return xSize;
	}

	public int getHeight() {
		return ySize;
	}
	
	public List<Impedance> getHitboxes() {
		return impedances;
	}
	
	public List<Interactable> getInteractions() {
		return interactions;
	}
}
