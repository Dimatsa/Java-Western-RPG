package rst.plot;

public abstract class PlotEntry {
	
	private final String requirement;
	private boolean completed;
	
	public PlotEntry(String requirement) {
		this.requirement = requirement;
	}
	
	public boolean activate() {
		if((requirement == null || PlotLine.getPlotLine().getPlot(requirement).isCompleted()) && !completed) {
			onStart();
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
	
	public abstract boolean periodic();
	
	
	public abstract void onStart();
	public abstract void onEnd();
}
