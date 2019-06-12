package rst.window;

import javax.swing.JFrame;

import rst.assets.AssetRegistry;
import rst.character.Characters;
import rst.dialogue.Dialogues;
import rst.plot.PlotLine;
import rst.scene.Scenes;

public class MainWindow {

	private final JFrame frame;
	
	public MainWindow() {
		frame = new JFrame("Shootout at Sweaty Post");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		AssetRegistry.init();
		
		Runnable initScene = new Runnable() {
			int count;

			@Override
			public void run() {
				if(++count >= 2) {
					Characters.init();
					Scenes.init();
					Dialogues.init();
					PlotLine.init();
				}
			}
		};
		
		AssetRegistry.getSounds().onLoad(initScene);
		AssetRegistry.getTextures().onLoad(initScene);
		
		Contexts.START.makeCurrent(frame);
	}
	
	public void show() {
		frame.setVisible(true);
	}
}
