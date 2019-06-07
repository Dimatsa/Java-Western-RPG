package rst.render;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class Input {
	
	public static int NO_LOCATION = -1;
	
	private final boolean[] keyPresses;
	
	private boolean leftMouse, middleMouse, rightMouse;
	private int mouseX, mouseY;
	private double mouseScroll;
	
	public Input(JComponent hook) {
		keyPresses = new boolean[256];
		
		hook.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() < 256) {
					keyPresses[e.getKeyCode()] = true;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() < 256) {
					keyPresses[e.getKeyCode()] = false;
				}
			}
		});
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					leftMouse = true;
				}
				else if(SwingUtilities.isMiddleMouseButton(e)) {
					middleMouse = true;
				}
				else {
					rightMouse = true;
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					leftMouse = false;
				}
				else if(SwingUtilities.isMiddleMouseButton(e)) {
					middleMouse = false;
				}
				else {
					rightMouse = false;
				}
			}
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				mouseScroll -= e.getPreciseWheelRotation();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseX = NO_LOCATION;
				mouseY = NO_LOCATION;
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		};
		
		hook.addMouseListener(mouseAdapter);
		hook.addMouseMotionListener(mouseAdapter);
		hook.addMouseWheelListener(mouseAdapter);
	}

	public boolean isKeyDown(int key) {
		if(key < 256) {
			return keyPresses[key];
		}
		else {
			return false;
		}
	}

	public boolean isLeftMouse() {
		return leftMouse;
	}

	public boolean isMiddleMouse() {
		return middleMouse;
	}

	public boolean isRightMouse() {
		return rightMouse;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public double getMouseScroll() {
		return mouseScroll;
	}
}
