/*
 * Asset.java
 * Deals with assets
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */

package rst.assets;

public abstract class Asset {

	private final String name;
	
	/**
	 * Constructor
	 * pre: none
	 * post: object has been created
	 */
	protected Asset(String name) {
		this.name = name;
	}
	
	/**
	 * Retrieves name
	 * pre: none
	 * post: name
	 */
	public String getName() {
		return name;
	}
}
