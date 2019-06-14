/*
 * Input.java
 * Deals with user input
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
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
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
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
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public boolean isKeyDown(int key) {
		if(key < 256) {
			return keyPresses[key];
		}
		else {
			return false;
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public boolean isLeftMouseDown() {
		return leftMouse;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public boolean isMiddleMouseDown() {
		return middleMouse;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public boolean isRightMouseDown() {
		return rightMouse;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getMouseX() {
		return mouseX;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public int getMouseY() {
		return mouseY;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public double getMouseScroll() {
		return mouseScroll;
	}
}
