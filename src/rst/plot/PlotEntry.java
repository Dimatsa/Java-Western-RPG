package rst.plot;

public abstract class PlotEntry {
	
	private final String requirement;
	private final String name;
	private boolean completed;
	
	public PlotEntry(String requirement, String name) {
		this.requirement = requirement;
		this.name = name;
	}
	
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
	
	public void deactivate() {
		onEnd();
		completed = true;
	}
	
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
