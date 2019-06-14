/*
 * RenderPanel.java
 * Renders objects onto panel
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.render;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import rst.assets.AssetRegistry;
import rst.scene.Scene;
import rst.scene.Scenes;

public class RenderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Input input;
	
	private Scene currentScene;
	private long lastPaint;
	private double fps;
	private long lastOccasional;
	private double occasional;
	
	private boolean debug;
	private boolean wasDebug;
	
	private boolean death, win;
	

	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public RenderPanel() {
		setFocusable(true);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RenderPanel.this.requestFocus();
			}
		});
		
		setDoubleBuffered(true);
		
		input = new Input(this);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void startPainting() {
		currentScene = Scenes.getScenes().getScene("Saloon");
		currentScene.enterScene();
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public void stopPainting() {
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
		
		// Uncomment to show rendering optimization
//		g.translate(getWidth() / 2.0 - 0.5 * Renderable.STANDARD_WIDTH / 2.0, getHeight() / 2.0 - 0.5 * Renderable.STANDARD_HEIGHT / 2.0);
//		g.scale(0.5, 0.5);
		
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Renderable.STANDARD_WIDTH, Renderable.STANDARD_HEIGHT);
		
		if(currentScene != null) {
			currentScene.render(g, input);
		}
		
		if(win) {
			g.setColor(new Color(Color.GREEN.getRed(), Color.GREEN.getGreen(), Color.GREEN.getBlue(), 128));
			g.fillRect(0, 0, Renderable.STANDARD_WIDTH, Renderable.STANDARD_HEIGHT);
		}
		else if(death) {
			g.setColor(new Color(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue(), 128));
			g.fillRect(0, 0, Renderable.STANDARD_WIDTH, Renderable.STANDARD_HEIGHT);
		}
		
		if(input.isKeyDown(KeyEvent.VK_F3) && !wasDebug) {
			wasDebug = true;
		}
		if(!input.isKeyDown(KeyEvent.VK_F3) && wasDebug) {
			wasDebug = false;
			debug = !debug;
		}
		
		if(debug) {
			g.setFont(AssetRegistry.getFonts().get("Montserrat-Regular").getFont().deriveFont(15.0f));
			
			

            String text = "FPS: " + (int)Math.round(occasional);
            FontMetrics fontMetrics = g.getFontMetrics();
            Rectangle2D bounds = fontMetrics.getStringBounds("FPS: ####", g);
            
            
            g.setColor(new Color(Color.DARK_GRAY.getRed(), Color.DARK_GRAY.getGreen(), Color.DARK_GRAY.getBlue(), 128));
            g.fillRect(0, 0, (int)bounds.getWidth(), (int)bounds.getHeight());
				
			g.setColor(Color.WHITE);
			g.drawString(text, 0, fontMetrics.getAscent());
		}
		
		repaint();
		
		fps = fps * 0.95 + (0.05)*1000000000.0/(System.nanoTime() - lastPaint);
		if(System.nanoTime() >= lastOccasional + 1500000000) {
			lastOccasional = System.nanoTime();
			occasional = fps;
		}
		
		lastPaint = System.nanoTime();
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
	
	public void setDead(boolean death) {
		this.death = death;
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}
}
