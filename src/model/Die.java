package model;

import java.util.LinkedList;


// TODO: Auto-generated Javadoc
/**
 * The Class Dice.
 */
public class Die {

	/**
	 * Roll single dice.
	 *
	 * @return the rolled number
	 */
	public int roll() {
		return (int) (Math.random() * 6) + 1;
	}
	
	/**
	 * Roll multiple die.
	 *
	 * @param die the die
	 * @return the linked list
	 */
	public LinkedList<Integer> roll(int die) {
		LinkedList<Integer> rolled = new LinkedList<Integer>();
		for (int i=0;i<die;i++) {
			rolled.add((roll()));
		}
		
		return rolled;
	}
}
