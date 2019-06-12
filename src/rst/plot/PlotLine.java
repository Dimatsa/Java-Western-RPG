package rst.plot;

import java.util.HashMap;
import java.util.Map;

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
	
	private final Map<String, PlotEntry> plots;
	
	public PlotLine() {
		this.plots = new HashMap<String, PlotEntry>();
		
		plots.put("speak", new TestEntry(null));
	}
	
	public PlotEntry getPlot(String name) {
		return plots.get(name);
	}
}
