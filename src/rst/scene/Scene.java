/*
 * Scene.java
 * Creates a scene
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.scene;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sound.sampled.Clip;

import rst.assets.Sound;
import rst.plot.PlotLine;
import rst.render.Block;
import rst.render.CameraFollowable;
import rst.render.Coordinates;
import rst.render.Input;
import rst.render.Renderable;
import rst.render.SceneRenderable;

public abstract class Scene implements Renderable {
	
	private final int xSize, ySize;
	private final Sound ambientSound;
	private final String name;
	private final List<SceneRenderable> items;
	private final List<Impedance> impedances;
	private final List<Interactable> interactions;
	
	private final List<SceneRenderable> remove, add;
	
	private Clip currentPlaying;
	
	private CameraFollowable camera;
	@SuppressWarnings("unused")
	private Sound overrideAmbientSound;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Scene(String background1, String background2, int xSize, int ySize, Sound ambientSound, CameraFollowable camera, String name, SceneRenderable... items)
	{
		this.xSize = xSize * Block.GRID_SIZE;
		this.ySize = ySize * Block.GRID_SIZE;
		this.ambientSound = ambientSound;
		this.camera = camera;
		this.name = name;
		this.items = new ArrayList<>(Arrays.asList(items));
		this.impedances = new ArrayList<>();
		this.interactions = new ArrayList<>();
		this.remove = new ArrayList<>();
		this.add = new ArrayList<>();
		
		
		
		for(int i = -20; i < xSize + 20; i++) {
			for(int j = -20; j < ySize + 20; j++) {
				if(0 <= i && i < xSize && 0 <= j && j <= ySize) {
					if(background1 != null) {
						Block b = new Block(background1, i, j) {
							@Override
							public int getRenderPriority() {
								return 11;
							}
						};
						this.items.add(b);
					}
				}
				else if(background2 != null) {
					Block b = new Block(background2, i, j) {
						@Override
						public int getRenderPriority() {
							return 11;
						}
					};
					this.items.add(b);
				}
			}
		}
		
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
		
		editTerrain();
		
		Collections.sort(this.items);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected void addItem(SceneRenderable item) {
		items.add(item);
		
		if(item instanceof Impedance) {
			impedances.add((Impedance) item);
		}
		
		if(item instanceof Interactable) {
			interactions.add((Interactable) item);
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void addItemRender(SceneRenderable item) {
		add.add(item);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected void editTerrain() {}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void enterScene() {
		if(ambientSound != null) {
			currentPlaying = ambientSound.startSound(1.0, Clip.LOOP_CONTINUOUSLY);
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void leaveScene() {
		if(currentPlaying != null) {
			currentPlaying.stop();
			currentPlaying = null;
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void render(Graphics2D g, Input input) {
		PlotLine.getPlotLine().executePlot();
		
		for(SceneRenderable item : items) {
			item.render(g, input, this);
		}
		
		for(SceneRenderable item : remove) {
			items.remove(item);
			
			if(item instanceof Impedance) {
				impedances.remove((Impedance)item);
			}
			
			if(item instanceof Interactable) {
				interactions.remove((Interactable)item);
			}
		}
		
		for(SceneRenderable item : add) {
			this.addItem(item);
		}
		
		remove.removeIf(a -> true);
		add.removeIf(a -> true);
		
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public String getName() {
		return name;
	}
	
	public Coordinates getCameraLocation() {
		return camera.getLocation();
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getWidth() {
		return xSize;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getHeight() {
		return ySize;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public List<Impedance> getHitboxes() {
		return impedances;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public List<Interactable> getInteractions() {
		return interactions;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected List<SceneRenderable> getSceneRenderables() {
		return items;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void removeItem(SceneRenderable item) {
		remove.add(item);
	}
}
