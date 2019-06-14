/*
 * Scenes.java
 * Keeps track of scenes
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.scene;

import java.util.Random;

import rst.datastructures.Searches;

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
	
	private String[] sceneNames;
	private Scene[] sceneItems;
	
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	protected Scenes() {
		sceneNames = new String[7];
		sceneItems = new Scene[7];
		
		// Names must be sorted alphabetically (:
		makeScene(new Bank(), 0);
		makeScene(new Bar(), 1);
		makeScene(new Hotel(), 2);
		makeScene(new Jail(), 3);
		makeScene(new RailwayStation(), 4);
		makeScene(new Saloon(), 5);
		makeScene(new Town(), 6);
	}

	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	private void makeScene(Scene s, int num) {
		sceneNames[num] = s.getName();
		sceneItems[num] = s;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public Scene getScene(String name) {
		int index;
		
		switch(new Random().nextInt(3)) {
		case 0:
			index = Searches.binarySearchNonRecursive(sceneNames, name);
			break;
		case 1:
			index = Searches.binarySearchRecursive(sceneNames, name);
			break;
		default:
			index = Searches.linearSearch(sceneNames, name);
			break;
		}
		
		if(index == Searches.NOT_FOUND) {
			return null;
		}
		else {
			return sceneItems[index];
		}
	}
}
