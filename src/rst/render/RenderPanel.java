package rst.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import rst.scene.Scene;
import rst.scene.Scenes;

public class RenderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Timer refreshTimer;
	private final Input input;
	
	private Scene currentScene;
	
	public RenderPanel() {
		// 16 ms results in about 60 FPS
		refreshTimer = new Timer(16, (event) -> this.repaint());
		
		setFocusable(true);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RenderPanel.this.requestFocus();
			}
		});
		
		input = new Input(this);
	}
	
	public void startPainting() {
		refreshTimer.start();
		
		currentScene = Scenes.getScenes().getScene("Test Scene");
		currentScene.enterScene();
	}
	
	public void stopPainting() {
		refreshTimer.stop();
		
		currentScene.leaveScene();
		currentScene = null;
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(currentScene != null) {
			currentScene.render(g, input, getWidth(), getHeight());
		}
	}
}
