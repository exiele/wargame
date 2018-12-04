package model;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {

	/** The id. */
	private int id;

	/** The colour. */
	private String colour;

	/** The cards. */
	private LinkedList<Card> cards = new LinkedList<Card>();

	/** The idle army. */
	private int idleArmy = 0;
	
	/** The owned territories. */
	private int ownedTerritories =0;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Gets the colour.
	 *
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public LinkedList<Card> getCards() {
		return cards;
	}

	/**
	 * Addcard.
	 *
	 * @param c the card
	 */
	public void addcard(Card c) {
		cards.add(c);
	}

	/**
	 * Sets the colour.
	 *
	 * @param colour the new colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * Instantiates a new player.
	 *
	 * @param id the id
	 */
	public Player(int id) {
		this.id = id;
	}

	/**
	 * Gets the idle army.
	 *
	 * @return the idle army
	 */
	public int getIdleArmy() {
		return idleArmy;
	}

	/**
	 * Adds the idle army.
	 *
	 * @param idleArmy the idle army
	 */
	public void addIdleArmy(int idleArmy) {
		this.idleArmy = this.idleArmy + idleArmy;
	}
	
	/**
	 * Gets the owned territories.
	 *
	 * @return the owned territories
	 */
	public int getOwnedTerritories() {
		return ownedTerritories;
	}
	
	/**
	 * Update owned territories.
	 *
	 * @param update the update
	 */
	public void updateOwnedTerritories(int update) {
		ownedTerritories = ownedTerritories + update;
	}
	
	/**
	 * Cards to string.
	 *
	 * @return the string
	 */
	public String cardsToString() {
		String temp="";
		Card c;
		for(int i=0;i<=cards.size();i++) {
			c = cards.get(i);
			temp = temp + "["+(i+1)+"-"+c.name()+"_"+c.shape+"]";
		}
		return temp;
	}
}
