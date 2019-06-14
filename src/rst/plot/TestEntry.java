/*
 * TestEntry.java
 * Allows for a test entry
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.plot;

public class TestEntry extends PlotEntry {
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public TestEntry(String requirement) {
		super(requirement);
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void onStart() {
		System.out.println("Test");
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public void onEnd() {
		System.out.println("Test end");
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	@Override
	public boolean periodic() {
		System.out.println("Execute");
		return true;
	}

}
