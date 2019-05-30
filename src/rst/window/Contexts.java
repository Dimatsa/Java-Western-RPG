package rst.window;

import javax.swing.JFrame;

public enum Contexts {

	START(new StartContext()),
	MAIN(new MainContext((StartContext) START.context));
	
	private final Context context;
	
	Contexts(Context context) {
		this.context = context;
	}
	
	public void makeCurrent(JFrame frame) {
		context.makeContextForFrame(frame);
	}
	
	public void makeCurrent(Context current) {
		current.transferContext(context);
	}
}
