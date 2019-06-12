package rst.plot;

public class TestEntry extends PlotEntry {

	public TestEntry(String requirement) {
		super(requirement);
	}

	@Override
	public void onStart() {
		System.out.println("Test");
	}

	@Override
	public void onEnd() {
		System.out.println("Test end");
	}

	@Override
	public boolean periodic() {
		return true;
	}

}
