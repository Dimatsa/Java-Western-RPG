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
	private final String name;
	private boolean completed;
	
	public PlotEntry(String requirement, String name) {
		this.requirement = requirement;
		this.name = name;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public boolean activate() {
		if((requirement == null || PlotLine.getPlotLine().getPlot() == this) && !completed && !PlotLine.getPlotLine().hasCurrent()) {
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
	
	public String getName() {
		return name;
	}
	
	public abstract boolean periodic();
	
	
	public abstract void onStart();
	public abstract void onEnd();
}
