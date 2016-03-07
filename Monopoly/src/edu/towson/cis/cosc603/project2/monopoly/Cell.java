package edu.towson.cis.cosc603.project2.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class Cell.
 */
public abstract class Cell {
	
	/** The available. */
	private boolean available = true;
	
	/** The name. */
	private String name;
	
	/** The owner. */
	protected Player owner;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return 0;
	}

	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Play action.
	 */
	public abstract void playAction();

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return name;
    }
}
