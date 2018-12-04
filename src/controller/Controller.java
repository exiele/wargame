package controller;

import model.Player;

import java.util.LinkedList;

import model.Match;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller {

	/** The war. */
	private Match match;

	/**
	 * New match.
	 *
	 * @param maxPlayers the max players
	 * @return true, if successful
	 */
	public boolean newMatch(int maxPlayers) {
		if (maxPlayers < 2 || maxPlayers > 6)
			return false;
		else {
			match = new Match(maxPlayers);
			return true;
		}

	}

	/**
	 * Match is not null.
	 *
	 * @return true, if successful
	 */
	public boolean matchIsNotNull() {
		if (match == null) {
			return false;
		} else
			return true;
	}

	/**
	 * Sets the player colour.
	 *
	 * @param id     the id
	 * @param colour the colour
	 */
	public void setPlayerColour(int id, String colour) {
		Player p = match.getPlayer(id);
		p.setColour(colour);
	}

	/**
	 * Gets the max players.
	 *
	 * @return the max players
	 */
	public int getMaxPlayers() {
		return match.getMaxPlayers();
	}

	/**
	 * Gets the map to string by id.
	 *
	 * @return the map to string by id
	 */
	public String getMapToStringById() {
		return match.getMap().mapToStringById();
	}

	/**
	 * Gets the map to string by name.
	 *
	 * @return the map to string by name
	 */
	public String getMapToStringByName() {
		return match.getMap().mapToStringByName();
	}

	/**
	 * Gets the current player.
	 *
	 * @return the current player
	 */
	public int getCurrentPlayer() {
		return match.getCurrentPlayer();
	}

	/**
	 * Hand out cards.
	 */
	public void handOutCard() {
		match.HandOutCards();
	}

	/**
	 * Inits the territories.
	 */
	public void initTerritories() {
		match.initTerritories();
	}

	/**
	 * Creates the new army.
	 *
	 * @param id the id
	 */
	public void createNewArmy(int id) {
		Player p = match.getPlayer(id);
		match.createNewArmy(p);
	}

	/**
	 * Gets the idle army.
	 *
	 * @param playerId the player id
	 * @return the idle army
	 */
	public int getIdleArmy(int playerId) {
		Player p = match.getPlayer(playerId);
		return p.getIdleArmy();
	}

	/**
	 * Distribute armys.
	 *
	 * @param distribution the distribution
	 */
	public void distribute(String distribution) {
		String[] s = distribution.split("-");
		if (match.ownTerritory(getCurrentPlayer(), s[0]))
			match.getMap().incrementArmy(s[0], 1, Integer.parseInt(s[1]));
	}

	/**
	 * Move army.
	 *
	 * @param movement the movement
	 */
	public void moveArmy(String movement) {
		String[] s = movement.split("-");
		match.moveArmy(getCurrentPlayer(), s[0], s[1], Integer.parseInt(s[2]));
	}

	/**
	 * Finished movement.
	 */
	public void finishedMovement() {
		match.clearMoved();
	}

	/**
	 * Attack.
	 *
	 * @param movement the movement
	 * @return the linked list
	 */
	public LinkedList<Integer> attack(String movement) {
		String[] s = movement.split("-");
		return match.attack(getCurrentPlayer(), s[0], s[1]);
	}
	
	/**
	 * Next player.
	 */
	public void nextPlayer() {
		match.nextPlayer();
	}
	
	/**
	 * Cards to string.
	 *
	 * @param playerId the player id
	 * @return the string
	 */
	public String cardsToString(int playerId) {
		return match.cardsToString(playerId);
	}
	
	/**
	 * How many cards.
	 *
	 * @param playerId the player id
	 * @return the int
	 */
	public int howManyCards(int playerId) {
		return match.howManyCards(playerId);
	}
	
	/**
	 * Exchange cards.
	 *
	 * @param cards the cards
	 */
	public void exchangeCards(String cards) {
		String[] s = cards.split(",");
		match.exchangeCards(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
	}
}
