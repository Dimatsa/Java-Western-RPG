package rst.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RenderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Timer refreshTimer;
	private final Input input;
	
	public RenderPanel() {
		
		// 16 ms results in about 60 FPS
		refreshTimer = new Timer(16, (event) -> this.repaint());
		
		input = new Input(this);
	}
	
	public void startPainting() {
		refreshTimer.start();
	}
	
	public void stopPainting() {
		refreshTimer.stop();
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.CYAN);
		
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
