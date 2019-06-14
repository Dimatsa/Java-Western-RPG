/*
 * Interactable.java
 * Allows user to interact with objects
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.scene;

public interface Interactable extends Impedance {
	public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;
	
	boolean[] getSides();
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	void performAction(Scene scene);
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	void performContact(Scene scene);
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	void performHit(Scene scene);
}
