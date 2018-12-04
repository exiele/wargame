package model;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 */
public class State {

	/** The territory. */
	private Territory territory;

	/** The owner id. */
	private int ownerId;

	/** The owner colour. */
	private String ownerColour = "";

	/** The army. */
	private Army army = null;

	/**
	 * Gets the owner colour.
	 *
	 * @return the owner colour
	 */
	public String getOwnerColour() {
		return ownerColour;
	}

	/**
	 * Sets the owner colour.
	 *
	 * @param ownerColour the new owner colour
	 */
	public void setOwnerColour(String ownerColour) {
		this.ownerColour = ownerColour;
	}

	/**
	 * Instantiates a new state.
	 *
	 * @param territory the territory
	 */
	public State(Territory territory) {
		this.territory = territory;
	}

	/**
	 * Sets the army.
	 *
	 * @param army the new army
	 */
	public void setArmy(Army army) {
		this.army = army;
	}

	/**
	 * Reset army.
	 */
	public void resetArmy() {
		this.army.reset();
	}

	/**
	 * Increment army.
	 *
	 * @param type the type
	 * @param qtt  the quantity
	 */
	public void incrementArmy(int type, int qtt) {
		if (type == 1) {
			this.army.add(qtt);
		}
	}

	/**
	 * Gets the owner id.
	 *
	 * @return the owner id
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the owner id.
	 *
	 * @param ownerId the new owner id
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return territory.name;
	}

	/**
	 * Gets the army size.
	 *
	 * @return the army size
	 */
	public int getArmySize() {
		return army.getSize();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return territory.id;
	}

	/**
	 * Checks for army.
	 *
	 * @return true, if successful
	 */
	public boolean hasArmy() {
		if (army != null)
			return true;
		else
			return false;
	}

	/**
	 * Checks if is neighbour.
	 *
	 * @param s the state
	 * @return true, if is neighbour
	 */
	public boolean isNeighbour(State s) {
		return territory.neighbours.contains(s.getId());
	}

}
