package model;

import java.util.Collections;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class Battle.
 */
public class Battle {
	
	/** The current player. */
	private int currentPlayer;
	
	/** The attacker. */
	private State attacker;
	
	/** The defender. */
	private State defender;

	/**
	 * Instantiates a new battle.
	 *
	 * @param currentPlayer the current player
	 * @param attacker the attacker
	 * @param defender the defender
	 * @param map the map
	 */
	public Battle(int currentPlayer, String attacker, String defender, Map map) {
		this.attacker = map.getStateById(attacker);
		this.defender = map.getStateById(defender);
	}

	/** The die. */
	private Die die = new Die();

	/**
	 * Attack.
	 *
	 * @param attackType the attack type
	 * @return the linked list
	 */
	public LinkedList<Integer> attack(int attackType) {
		if (attacker.getOwnerId() != currentPlayer) {
			return null;
		} else {
			switch (attackType) {
			case 1:
				return attackType1();

			default:
				return attackType1();

			}

		}

	}

	/**
	 * Attack type 1.
	 *
	 * @return the linked list
	 */
	private LinkedList<Integer> attackType1() {
		LinkedList<Integer> result = new LinkedList<Integer>();
		Integer resultArmyA = 0;
		Integer resultArmyB = 0;
		if (attacker.isNeighbour(defender)) {
			int armyA = attacker.getArmySize();
			int armyB = defender.getArmySize();
			LinkedList<Integer> resultA = new LinkedList<Integer>();
			LinkedList<Integer> resultB = new LinkedList<Integer>();
			if (armyA == 1) {
				return null;
			} else if (armyA <= 4) {
				resultA = die.roll(armyA - 1);
				armyA--;
			} else if (armyA > 4) {
				resultA = die.roll(3);
				armyA = 3;
			}
			if (armyB < 4) {
				resultB = die.roll(armyB);
			} else {
				resultB = die.roll(3);
			}
			Collections.sort(resultA, Collections.reverseOrder());
			Collections.sort(resultB, Collections.reverseOrder());

			for (int i = 0; i < resultA.size(); i++) {
				if (i < resultB.size()) {
					if (resultA.get(i) > resultB.get(i)) {
						resultArmyB--;
					} else
						resultArmyA--;
				} else
					break;
			}
			attacker.incrementArmy(1, resultArmyA);
			if (defender.getArmySize() - resultArmyB <= 0) {
				result.add(1);
				armyA = armyA - resultArmyA;
				result.add(armyA);
				result.add(defender.getOwnerId());
				defender.setOwnerId(currentPlayer);
				defender.resetArmy();
				
				
			} else {
				defender.incrementArmy(1, resultArmyB);
				result.add(0);
			}

			return result;

		} else
			return null;
	}

}
