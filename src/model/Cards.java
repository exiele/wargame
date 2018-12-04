package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Cards.
 */
public class Cards {
	
	/** The cards. */
	List<Card> cards = Arrays.asList(Card.values());

	/**
	 * Instantiates a new cards.
	 */
	public Cards() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Pop.
	 *
	 * @param i the i
	 * @return the card
	 */
	public Card pop(int i) {
		return cards.get(i);
		
	}
	
	/**
	 * New set.
	 */
	public void newSet() {
		cards = Arrays.asList(Card.values());
		Collections.shuffle(cards);
	}
	
	/**
	 * Shuffle.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return cards.size();
	}
}
