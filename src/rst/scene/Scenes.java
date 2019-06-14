package rst.scene;

import java.util.Random;

import rst.datastructures.Searches;

public class Scenes {

	private static Scenes scenes;
	
	public static void init() {
		if(scenes == null) {
			scenes = new Scenes();
		}
	}
	
	public static Scenes getScenes() {
		init();
		return scenes;
	}
	
	private String[] sceneNames;
	private Scene[] sceneItems;
	
	protected Scenes() {
		sceneNames = new String[2];
		sceneItems = new Scene[2];
		
		// Names must be sorted alphabetically (:
		makeScene(new Saloon(), 0);
		makeScene(new Town(), 1);
	}
	
	private void makeScene(Scene s, int num) {
		sceneNames[num] = s.getName();
		sceneItems[num] = s;
	}

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
