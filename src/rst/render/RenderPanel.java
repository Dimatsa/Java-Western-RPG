/*
 * RenderPanel.java
 * Renders objects onto panel
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
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
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
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
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void startPainting() {
		refreshTimer.start();
		
		currentScene = Scenes.getScenes().getScene("Town");
		currentScene.enterScene();
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void stopPainting() {
		refreshTimer.stop();
		
		currentScene.leaveScene();
		currentScene = null;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics.create();
		g.scale((double)getWidth() / Renderable.STANDARD_WIDTH, (double)getHeight() / Renderable.STANDARD_HEIGHT);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Renderable.STANDARD_WIDTH, Renderable.STANDARD_HEIGHT);
		
		if(currentScene != null) {
			currentScene.render(g, input);
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void setScene(Scene scene) {
		currentScene.leaveScene();
		this.currentScene = scene;
		currentScene.enterScene();
	}
}
