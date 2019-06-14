/*
 * PlotLine.java
 * Keeps track of the plots
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.plot;

import rst.character.Characters;
import rst.character.Player;
import rst.datastructures.Stack;

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
	
	private final Stack<PlotEntry> plots;
	
	private PlotEntry lastPlot;
	private PlotEntry current;
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public PlotLine() {
		this.plots = new Stack<>();
		
		plots.push(new TestEntry(null, "speak"));
	}
	
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */	
	public PlotEntry getPlot() {
		return plots.top();
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
				
				if(plots.isEmpty()) {
					((Player)Characters.getCharacters().getCharacter("Connor Adams")).win();
				}
			}
		}
	}
	
	public boolean activate(String name) {
		if(plots != null && plots.top().getName().equals(name)) {
			return plots.pop().activate();
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
