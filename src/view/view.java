package view;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class view.
 */
public class view {

	/**  The controller. */
	private static Controller control = new Controller();

	/**  The scanner. */
	private static Scanner scan = new Scanner(System.in);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		boolean flag;

		do {
			System.out.println("Digite o número de jogadores: ");
			int p = scan.nextInt();
			flag = control.newMatch(p);
			if (!flag)
				System.out.println("É necessário ter no mínimo 2 jogadores e no máximo 6\n");
		} while (!flag);

		// clear console
//        System.out.printf("\033[H\033[2J");  
//        System.out.flush();

		int maxPlayers = control.getMaxPlayers();
		for (int i = 1; i <= maxPlayers; i++) {
			System.out.printf("Digite a cor do jogador %d: ", i);
			String playerColour = scan.next();
			control.setPlayerColour(i, playerColour);
		}
		System.out.println("Distribuindo cartas... \n");
		control.handOutCard();
		control.initTerritories();
		System.out.println(control.getMapToStringById());
		while (control.getMaxPlayers() > 2) {
			turn();
		}

		scan.close();
	}

//	Inicia o jogo o jogador seguinte ao que recebeu a última carta-território. Cada jogador passa na sua vez, 
//	tanto na primeira como em todas as outras rodadas, pelas seguintes etapas, nesta ordem:
//		a) receber novos exércitos e os colocar de acordo com a sua estratégia;
//		b) se desejar, atacar os seus adversários;
//		c) desloca seus exércitos se houver conveniência e
//	    d) receber uma carta se fizer jus a isto.
	/**
	 * logic for the turns.
	 */

	public static void turn() {
		String temp;
		System.out.println("Vez do jogador " + control.getCurrentPlayer() + ".");
		control.createNewArmy(control.getCurrentPlayer());
		//trocar cartas?
		if(control.howManyCards(control.getCurrentPlayer())>4)
			exchangeCards();
		System.out.println("Jogador " + control.getCurrentPlayer() + ", gostaria de trocar suas cartas? (1-sim / 2-não):");
		temp = scan.next();
		if (Integer.parseInt(temp) == 1)
			exchangeCards();
		// distribui
		distribute();
		// ataca?
		System.out.println("Jogador " + control.getCurrentPlayer() + ", você gostaria de atacar? (1-sim / 2-não):");
		temp = scan.next();
		if (Integer.parseInt(temp) == 1)
			attack();
		// desloca?
		System.out.println(
				"Jogador " + control.getCurrentPlayer() + ", você gostaria de deslocar exercitos? (1-sim / 2-não):");
		temp = scan.next();
		if (Integer.parseInt(temp) == 1) {
			move();
			
		}
		control.nextPlayer();

	}

	/**
	 * Exchange cards.
	 */
	private static void exchangeCards() {
		String temp;
		int i=1;
		do {
			control.cardsToString(control.getCurrentPlayer());
			System.out.println(
					"Jogador " + control.getCurrentPlayer() + ", Quais cartas deseja trocar? (exemplo:1,2,3):");
			temp = scan.next();
			control.exchangeCards(temp);
			System.out.println(
					"Jogador " + control.getCurrentPlayer() + ", continuar trocando? (1-sim / 2-não):");
			i = scan.nextInt();
		}while(i==1);
		
		
	}

	/**
	 * logic for the attack.
	 */
	public static void attack() {
		LinkedList<Integer> attackResult;
		int mov;
		int attack = 1;
		String temp;
		do {
			System.out.println(control.getMapToStringById());
			System.out.println("Jogador " + control.getCurrentPlayer()
					+ ", Indique o estado origem e destino do ataque(exemplo:BA-SE):");
			temp = scan.next();
			attackResult = control.attack(temp);
			if(attackResult.get(0)==1) {
				System.out.println("Jogador " + control.getCurrentPlayer() + " conquistou o território! quantos exércitos mover?(Máximo "+attackResult.get(1)+")");
				do {
					mov = scan.nextInt();
					System.out.println("Quantos exércitos mover?(Máximo "+attackResult.get(1)+")");
				}while (mov>attackResult.get(1));
				temp = temp + "-"+mov;
				control.moveArmy(temp);
				control.finishedMovement();
				
				
			}
			System.out.println("Jogador " + control.getCurrentPlayer() + ", Continuar atacando?(1-sim,2-não):");
			attack = scan.nextInt();
		} while (attack == 1);

	}

	/**
	 * Distribute.
	 */
	public static void distribute() {
		String temp;
		while (control.getIdleArmy(control.getCurrentPlayer()) > 0) {
			System.out.println("Jogador " + control.getCurrentPlayer() + ", você tem "
					+ control.getIdleArmy(control.getCurrentPlayer()) + " exércitos para distribuir(exemplo:BA-2):");
			temp = scan.next();
			control.distribute(temp);

		}
	}

	/**
	 * logic for the army movement.
	 */
	public static void move() {
		
		String temp;
		do {
			System.out.println("Jogador " + control.getCurrentPlayer() + ", faça seu movimento(exemplo:BA-SE-3):");
			temp = scan.next();
			control.moveArmy(temp);
			
			System.out.println(
					"Jogador " + control.getCurrentPlayer() + ", continuar deslocando exercitos? (1-sim / 2-não):");
			temp = scan.next();
		}
		
		while (Integer.parseInt(temp) == 1);
		control.finishedMovement();
	}

}
