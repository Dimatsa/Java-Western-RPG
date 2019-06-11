package rst.scene;

public interface Interactable extends Impedance {
	public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;
	
	boolean[] getSides();
	
	void performAction();
}
