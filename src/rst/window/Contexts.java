package rst.window;

import javax.swing.JFrame;

public enum Contexts {

	START(new StartContext()),
	MAIN(new MainContext());
	
	private final Context context;
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	Contexts(Context context) {
		this.context = context;
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	public void makeCurrent(JFrame frame) {
		context.makeContextForFrame(frame);
	}
	/**
	 * Executes the following action commands
	 * pre: none
	 * post: the commands have been executed
	 */
	public void makeCurrent(Context current) {
		current.transferContext(context);
	}
}
