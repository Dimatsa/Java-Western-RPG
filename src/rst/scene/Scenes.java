/*
 * Scenes.java
 * Keeps track of scenes
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.scene;

import java.util.HashMap;
import java.util.Map;

public class Scenes {

	private static Scenes scenes;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public static void init() {
		if(scenes == null) {
			scenes = new Scenes();
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public static Scenes getScenes() {
		init();
		return scenes;
	}
	
	private Map<String, Scene> sceneMap;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected Scenes() {
		sceneMap = new HashMap<>();
		
		makeScene(new Town());
		makeScene(new Saloon());
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private void makeScene(Scene s) {
		sceneMap.put(s.getName(), s);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Scene getScene(String name) {
		return sceneMap.get(name);
	}
}
