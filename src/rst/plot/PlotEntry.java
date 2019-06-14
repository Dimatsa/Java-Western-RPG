/*
 * PlotEntry.java
 * Defines entry of plot
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.plot;

public abstract class PlotEntry {
	
	private final String requirement;
	private boolean completed;
	
	public PlotEntry(String requirement) {
		this.requirement = requirement;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public boolean activate() {
		if((requirement == null || PlotLine.getPlotLine().getPlot(requirement).isCompleted()) && !completed && !PlotLine.getPlotLine().hasCurrent()) {
			onStart();
			PlotLine.getPlotLine().makeCurrent(this);
			return true;
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
	public void deactivate() {
		onEnd();
		completed = true;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public boolean isCompleted() {
		return completed;
	}
	
	public abstract boolean periodic();
	
	
	public abstract void onStart();
	public abstract void onEnd();
}
