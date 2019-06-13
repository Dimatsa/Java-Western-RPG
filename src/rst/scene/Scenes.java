package rst.scene;

import java.util.HashMap;
import java.util.Map;

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
	
	private Map<String, Scene> sceneMap;
	
	protected Scenes() {
		sceneMap = new HashMap<>();
		
		makeScene(new Town());
		makeScene(new Saloon());
	}
	
	private void makeScene(Scene s) {
		sceneMap.put(s.getName(), s);
	}

	public Scene getScene(String name) {
		return sceneMap.get(name);
	}
}
