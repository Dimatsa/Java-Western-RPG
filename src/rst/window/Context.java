package rst.window;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Context extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final boolean resizable;
	private final int x, y;
	private final Dimension size;
	private final int extendedState;
	
	private JFrame current;
	
	public Context(boolean resizable, int x, int y, Dimension size, int extendedState) {
		this.resizable = resizable;
		this.x = x;
		this.y = y;
		this.size = size;
		this.extendedState = extendedState;
	}
	
	public void makeContextForFrame(JFrame frame) {
		this.current = frame;
		
		frame.setResizable(resizable);
		frame.setSize(size);
		frame.setLocation(x, y);
		frame.setExtendedState(extendedState);
		frame.setContentPane(this);
		frame.revalidate();
	}
	
	public void transferContext(Context other) {
		if(current == null) {
			System.err.println("Can't transfer without ownership!");
		}
		
		other.makeContextForFrame(current);
		
		current = null;
	}
	
	protected JFrame getCurrent() {
		return current;
	}
}
