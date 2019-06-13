package rst.render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import rst.assets.AssetRegistry;
import rst.assets.Texture;

public class HealthBar extends JComponent {
	private static final long serialVersionUID = 1L;

	private Texture fullTexture, emptyTexture;
	private int health;
	private final int max;
	
	public HealthBar(String full, String empty, int maxHealth, int initialHealth) {
		AssetRegistry.getTextures().onLoad(() -> {
			this.fullTexture = AssetRegistry.getTextures().get(full);
			this.emptyTexture = AssetRegistry.getTextures().get(full);
			
			setHealth(initialHealth);
		});
		
		this.max = maxHealth;
		setHealth(health);
		
		this.setPreferredSize(new Dimension(18*max, 16));
	}
	
	public void setHealth(int health) {
		this.health = health;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		
		g2d.scale(getWidth() / (18.0*max), getWidth() / (18.0*max));
		g2d.translate(0, getHeight() / 2 - (16 * getWidth() / (18.0*max) / 2));
		
		for(int i = 0; i < health; i++) {
			fullTexture.draw(g2d, i * 18, 0, 16, 16);
		}
		for(int i = health; i < max; i++) {
			emptyTexture.draw(g2d, i * 18, 0, 16, 16);
		}
	}
}
