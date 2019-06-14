package rst.plot;

import rst.datastructures.Stack;

public class PlotLine {
	private static PlotLine story;
	
	public static void init() {
		if(story == null) {
			story = new PlotLine();
		}
	}
	
	public static PlotLine getPlotLine() {
		init();
		return story;
	}
	
	private final Stack<PlotEntry> plots;
	
	private PlotEntry lastPlot;
	private PlotEntry current;
	
	public PlotLine() {
		this.plots = new Stack<>();
		
		plots.push(new TestEntry(null, "speak"));
	}
	
	public PlotEntry getPlot() {
		return plots.top();
	}
	
	public void executePlot() {
		if(lastPlot != current) {
			if(lastPlot != null) {
				lastPlot.deactivate();
			}
			lastPlot = current;
		}
		
		if(current != null) {
			if(current.periodic()) {
				current = null;
			}
		}
	}
	
	public boolean activate(String name) {
		if(plots != null && plots.top().getName().equals(name)) {
			return plots.top().activate();
		}
		else {
			return false;
		}
	}
	
	void makeCurrent(PlotEntry p) {
		this.current = p;
	}
	
	public boolean hasCurrent() {
		return current != null;
	}
}
