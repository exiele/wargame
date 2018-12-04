package model;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map {

	/** The regions. */
	private LinkedList<Region> regions;

	/**
	 * Instantiates a new map.
	 */
	public Map() {
		/* Norte */
		LinkedList<State> north = new LinkedList<State>();
		for (Territory t : Territory.values()) {
			if (t.region.equals("Norte"))
				north.add(new State(t));
		}
		Region n = new Region("Norte", north);
		/* Nordeste */
		LinkedList<State> nordeste = new LinkedList<State>();
		for (Territory t : Territory.values()) {
			if (t.region.equals("Nordeste"))
				nordeste.add(new State(t));
		}
		Region ne = new Region("Nordeste", nordeste);
		/* Sudeste */
		LinkedList<State> sudeste = new LinkedList<State>();
		for (Territory t : Territory.values()) {
			if (t.region.equals("Sudeste"))
				sudeste.add(new State(t));
		}
		Region se = new Region("Sudeste", sudeste);
		/* Centro-oeste */
		LinkedList<State> centroOeste = new LinkedList<State>();
		for (Territory t : Territory.values()) {
			if (t.region.equals("Centro-oeste"))
				centroOeste.add(new State(t));
		}
		Region cw = new Region("Centro-oeste", centroOeste);
		/* Sul */
		LinkedList<State> sul = new LinkedList<State>();
		for (Territory t : Territory.values()) {
			if (t.region.equals("Sul"))
				sul.add(new State(t));
		}
		Region s = new Region("Sul", sul);

		regions = new LinkedList<Region>();
		regions.add(n);
		regions.add(ne);
		regions.add(se);
		regions.add(cw);
		regions.add(s);
	}

	/**
	 * Map to string by id.
	 *
	 * @return the string
	 */
	public String mapToStringById() {
		LinkedList<String> temp = new LinkedList<String>();
		String s = "";
		for (Region r : regions) {
			temp = r.regionToStringById();
			s = s + (r.getName() + " - ");
			for (String state : temp) {
				s = s + ("[" + state + "]");
			}
			s = s + ("\n");
		}
		return s;
	}

	/**
	 * Map to string by name.
	 *
	 * @return the string
	 */
	public String mapToStringByName() {
		LinkedList<String> temp = new LinkedList<String>();
		String s = "";
		for (Region r : regions) {
			temp = r.regionToStringByName();
			s = s + (r.getName() + " - ");
			for (String state : temp) {
				s = s + ("[" + state + "]");
			}
			s = s + ("\n");
		}
		return s;
	}

	/**
	 * Sets the army.
	 *
	 * @param owner    the owner
	 * @param colour   the colour
	 * @param state    the state
	 * @param armyType the army type
	 * @param qtt      the quantity
	 */
	public void setArmy(int owner, String colour, String state, int armyType, int qtt) {
		for (Region r : regions) {
			for (State s : r.getTerritories()) {
				if (s.getId().equals(state)) {
					s.setArmy(new Army(armyType, qtt));
					s.setOwnerId(owner);
					s.setOwnerColour(colour);
				}
			}
		}
	}

	/**
	 * Increment army.
	 *
	 * @param state    the state
	 * @param armyType the army type
	 * @param qtt      the quantity
	 */
	public void incrementArmy(String state, int armyType, int qtt) {
		for (Region r : regions) {
			for (State s : r.getTerritories()) {
				if (s.getId().equals(state)) {
					s.incrementArmy(armyType, qtt);
				}
			}
		}
	}

	/**
	 * Elegible army.
	 *
	 * @param playerId the player id
	 * @return the elegible army
	 */
	public int elegibleArmy(int playerId) {
		LinkedList<State> l = new LinkedList<State>();
		int army = 0;
		for (Region r : regions) {
			l.addAll(r.ownedTerritories(playerId));
		}
		army = l.size() / 2;
		for (Region r : regions) {
			if (r.getOwner() == playerId) {
				army = army + r.elegibleArmyForOwner();
			}
		}
		return army;
	}

	/**
	 * Gets the state by id.
	 *
	 * @param state the state
	 * @return the state by id
	 */
	public State getStateById(String state) {
		for (Region r : regions) {
			for (State s : r.getTerritories()) {
				if (s.getId().equals(state)) {
					return s;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the state by name.
	 *
	 * @param state the state
	 * @return the state by name
	 */
	public State getStateByName(String state) {
		for (Region r : regions) {
			for (State s : r.getTerritories()) {
				if (s.getName().equals(state)) {
					return s;
				}
			}
		}
		return null;
	}

	/**
	 * Own territory.
	 *
	 * @param playerId  the player id
	 * @param territory the territory
	 * @return true, if successful
	 */
	public boolean ownTerritory(int playerId, String territory) {
		State s = getStateById(territory);
		if (s.getOwnerId() == playerId) {
			return true;
		} else
			return false;
	}

	/**
	 * Move army.
	 *
	 * @param source the source
	 * @param dest   the destination
	 * @param qtt    the quantity
	 */
	public void moveArmy(String source, String dest, int qtt) {
		State a = getStateById(source);
		State b = getStateById(dest);
		if (a.isNeighbour(b)) {
			a.incrementArmy(1, -qtt);
			b.incrementArmy(1, qtt);

		}

	}

}
