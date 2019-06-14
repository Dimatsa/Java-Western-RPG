/*
 * PlotLine.java
 * Keeps track of the plots
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.plot;

import java.util.HashMap;
import java.util.Map;
/**
 * Executes the following code
 * pre: none
 * post: the commands have been executed
 */
public class PlotLine {
	private static PlotLine story;
	
	public static void init() {
		if(story == null) {
			story = new PlotLine();
		}
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public static PlotLine getPlotLine() {
		init();
		return story;
	}
	
	private final Map<String, PlotEntry> plots;
	
	private PlotEntry lastPlot;
	private PlotEntry current;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public PlotLine() {
		this.plots = new HashMap<String, PlotEntry>();
		
		plots.put("speak", new TestEntry(null));
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public PlotEntry getPlot(String name) {
		return plots.get(name);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
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
	
	void makeCurrent(PlotEntry p) {
		this.current = p;
	}
	
	public boolean hasCurrent() {
		return current != null;
	}
}
