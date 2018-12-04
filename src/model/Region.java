package model;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class Region.
 */
public class Region {

	/** The states. */
	private LinkedList<State> states;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new region.
	 *
	 * @param name the name
	 * @param s    the states list
	 */
	public Region(String name, LinkedList<State> s) {
		this.name = name;
		this.states = s;
	}

	/**
	 * Gets the territories.
	 *
	 * @return the territories
	 */
	public LinkedList<State> getTerritories() {
		return states;
	}

	/**
	 * Region to string by name.
	 *
	 * @return the linked list
	 */
	public LinkedList<String> regionToStringByName() {
		LinkedList<String> temp = new LinkedList<String>();
		for (State t : states) {
			if (t.hasArmy())
				temp.add(t.getName() + "(" + t.getOwnerColour() + "-" + t.getArmySize() + ")");
			else
				temp.add(t.getName() + "(Vazio)");
		}
		return temp;
	}

	/**
	 * Region to string by id.
	 *
	 * @return the linked list
	 */
	public LinkedList<String> regionToStringById() {
		LinkedList<String> temp = new LinkedList<String>();
		for (State t : states) {
			if (t.hasArmy())
				temp.add(t.getId() + "(" + t.getOwnerColour() + "-" + t.getArmySize() + ")");
			else
				temp.add(t.getId() + "(Vazio)");
		}
		return temp;
	}

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
	public int getOwner() {
		int i = 0;
		for (State s : states) {
			if (i == 0) {
				i = s.getOwnerId();
			} else {
				if (s.getOwnerId() != i) {
					return 0;
				}
			}
		}
		return i;
	}

	/**
	 * Owned territories.
	 *
	 * @param playerId the player id
	 * @return the linked list
	 */
	public LinkedList<State> ownedTerritories(int playerId) {
		LinkedList<State> l = new LinkedList<State>();
		for (State s : states) {
			if (s.getOwnerId() == playerId) {
				l.add(s);
			}
		}
		return l;
	}

	/**
	 * Elegible army for owner.
	 *
	 * @return the elegible army
	 */
	public int elegibleArmyForOwner() {
		return states.size() / 2;
	}

}
