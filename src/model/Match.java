package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class War.
 */
public class Match {

	/** The players. */
	private LinkedList<Player> players;

	/** The max players. */
	private int maxPlayers;

	/** The map. */
	private Map map;

	/** The current player. */
	private int currentPlayer;

	/** The list for territories that recently moved armys. */
	private LinkedList<String> hasMoved = new LinkedList<String>();
	
	/** The cards. */
	private Cards cards = new Cards();

	/**
	 * Instantiates a new war.
	 *
	 * @param maxPlayers the max players
	 */
	public Match(int maxPlayers) {
		this.maxPlayers = maxPlayers;
		players = new LinkedList<Player>();
		for (int i = 1; maxPlayers > 0; i++) {
			players.add(new Player(i));
			maxPlayers -= 1;
		}
		map = new Map();
		currentPlayer = 1;
		
	}

	/**
	 * Gets the max players.
	 *
	 * @return the max players
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
	 * Adds the player.
	 *
	 * @param p the p
	 */
	public void addPlayer(Player p) {
		players.add(p);
	}

	/**
	 * Gets the player.
	 *
	 * @param id the id
	 * @return the player
	 */
	public Player getPlayer(int id) {
		for (Player p : players) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * Gets the current player.
	 *
	 * @return the current player
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Hand out cards.
	 */
	public void HandOutCards() {
		Card c;
		List<Card> l = Arrays.asList(Card.values());
		Collections.shuffle(l);
		Iterator<Card> it = l.iterator();
		while (it.hasNext()) {
			c = it.next();
			for (int i = 1; i <= maxPlayers; i++) {
				for (Player p : players) {
					if (p.getId() == i) {
						if (!c.shape.equals("Coringa")) {
							p.addcard(c);
							System.out.println(c.name() + "(" + c.shape + ") para jogador " + i);
							currentPlayer = i;
						}

					}
				}

			}
			nextPlayer();
		}

	}

	/**
	 * Initiate the territories.
	 */
	public void initTerritories() {
		LinkedList<Card> c;
		for (Player p : players) {
			c = p.getCards();
			for (int i = 0; i < c.size(); i++) {
				map.setArmy(p.getId(), p.getColour(), c.get(i).name(), 1, 1);
			}
		}
		c = new LinkedList<Card>();
	}

	/**
	 * Creates the new army.
	 *
	 * @param p the p
	 */
	public void createNewArmy(Player p) {
		p.addIdleArmy(map.elegibleArmy(p.getId()));
	}

	/**
	 * Checks if a player own a territory.
	 *
	 * @param playerId  the player id
	 * @param territory the territory
	 * @return true, if successful
	 */
	public boolean ownTerritory(int playerId, String territory) {
		return map.ownTerritory(playerId, territory);
	}

	/**
	 * Move army.
	 *
	 * @param playerId the player id
	 * @param source   the source
	 * @param dest     the destination
	 * @param qtt      the quantity
	 */
	public void moveArmy(int playerId, String source, String dest, int qtt) {
		if (ownTerritory(playerId, source) && ownTerritory(playerId, dest)) {
			if (map.getStateById(source).getArmySize() > qtt && !hasMoved(source)) {
				map.moveArmy(source, dest, qtt);
				addMoved(dest);
			}
		}
	}

	/**
	 * Adds territories who recently moved to the list.
	 *
	 * @param state the state
	 */
	public void addMoved(String state) {
		hasMoved.add(state);
	}

	/**
	 * Clear the list of territories who recently moved.
	 */
	public void clearMoved() {
		hasMoved = new LinkedList<String>();
	}

	/**
	 * Checks for territories who recently moved.
	 *
	 * @param state the state
	 * @return true, if successful
	 */
	public boolean hasMoved(String state) {
		return hasMoved.contains(state);
	}

	/**
	 * Attack.
	 *
	 * @param currentplayer the currentplayer
	 * @param attacker the attacker
	 * @param defender the defender
	 * @return the linked list
	 */
	public LinkedList<Integer> attack(int currentplayer, String attacker, String defender) {
		Battle b = new Battle(currentplayer, attacker, defender, map);
		LinkedList<Integer> result = b.attack(1);
		Player p;
		if(result.get(0)==1) {
			players.get(currentplayer).updateOwnedTerritories(1);
			p = players.get(result.get(2));
			p.updateOwnedTerritories(-1);
			if(p.getOwnedTerritories()<=0)
				players.remove(p);
		}
		players.get(currentplayer).addcard(cards.pop(0));
		if(cards.size()==0)
			cards.newSet();
		return result;

	}
	
	/**
	 * Next player.
	 */
	public void nextPlayer() {
		if(currentPlayer==players.getLast().getId()) {
			currentPlayer = players.getFirst().getId();
		}
		else {
			do {
				if(currentPlayer==players.getLast().getId())
					currentPlayer = players.getFirst().getId();
				else currentPlayer++;
			}while(getPlayer(currentPlayer)==null);
			
		}
	}
	
	/**
	 * Cards to string.
	 *
	 * @param playerId the player id
	 * @return the string
	 */
	public String cardsToString(int playerId) {
		return getPlayer(playerId).cardsToString();
	}
	
	/**
	 * How many cards.
	 *
	 * @param playerId the player id
	 * @return the int
	 */
	public int howManyCards(int playerId) {
		return players.get(playerId).getCards().size();
	}
	
	/**
	 * Exchange cards.
	 *
	 * @param card1 the card 1
	 * @param card2 the card 2
	 * @param card3 the card 3
	 */
	public void exchangeCards(int card1,int card2,int card3) {
		Player p = players.get(currentPlayer);
		LinkedList<Card> l = new LinkedList<Card>();
		Card c1 = p.getCards().get(card1);
		Card c2 = p.getCards().get(card2);
		Card c3 = p.getCards().get(card3);
		l.add(c1);
		l.add(c2);
		l.add(c3);
		l = removeJokers(l);
		if(l.size()==0) {
			p.addIdleArmy(3);
			if(p.getCards().contains(c1))
				p.addIdleArmy(2);
			if(p.getCards().contains(c2))
				p.addIdleArmy(2);
			if(p.getCards().contains(c3))
				p.addIdleArmy(2);
			p.getCards().remove(c1);
			p.getCards().remove(c2);
			p.getCards().remove(c3);
		}
		else {
			if(l.size()==2) {
				if(l.get(0).equals(l.get(1))){
					p.addIdleArmy(3);
					if(p.getCards().contains(c1))
						p.addIdleArmy(2);
					if(p.getCards().contains(c2))
						p.addIdleArmy(2);
					if(p.getCards().contains(c3))
						p.addIdleArmy(2);
					p.getCards().remove(c1);
					p.getCards().remove(c2);
					p.getCards().remove(c3);
				}
			}
			else {
				if(l.get(0).equals(l.get(1))&&l.get(0).equals(l.get(2))) {
					p.addIdleArmy(3);
					if(p.getCards().contains(c1))
						p.addIdleArmy(2);
					if(p.getCards().contains(c2))
						p.addIdleArmy(2);
					if(p.getCards().contains(c3))
						p.addIdleArmy(2);
					p.getCards().remove(c1);
					p.getCards().remove(c2);
					p.getCards().remove(c3);
				}
			}
		}
		

	}
	
	/**
	 * Removes the jokers.
	 *
	 * @param l the l
	 * @return the linked list
	 */
	private LinkedList<Card> removeJokers(LinkedList<Card> l){
		for(int i=0;i<3;i++) {
			if(l.get(i).shape.equals("Coringa"))
				l.remove(i);
		}
		return l;
	}

}
