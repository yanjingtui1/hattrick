package Game;

import Player.*;
import Cards.*;
import Cards.Props.Prop;

import java.util.*;

import Player.*;

public class Game {
	private ArrayList<Player> players;
	private Pile pile;
	private boolean partieEnCours;
	private int nbplayers;
	private Props midcard;
	private LinkedList<Props> tasdeProps;

	public Game() {
		players = new ArrayList<Player>();
		partieEnCours = false;
		midcard = new Props(0, "midcard", false);

	}

	public boolean checkTrick(Pile p, Player pl) {
		boolean b = false;

		if (pl.getCards().get(0).getName() == p.getCurrentTrick().getDroite1()
				|| pl.getCards().get(0).getName() == p.getCurrentTrick().getDroite2()
				|| pl.getCards().get(0).getName() == p.getCurrentTrick().getGauche2()
				|| pl.getCards().get(0).getName() == p.getCurrentTrick().getGauche1()) {
			if (pl.getCards().get(0).getName() == p.getCurrentTrick().getDroite1()) {
				if (pl.getCards().get(1).getName() == p.getCurrentTrick().getGauche1()
						|| pl.getCards().get(1).getName() == p.getCurrentTrick().getGauche2()) {
					b = true;
				}
			}
			if (pl.getCards().get(0).getName() == p.getCurrentTrick().getDroite2()) {
				if (pl.getCards().get(1).getName() == p.getCurrentTrick().getGauche1()
						|| pl.getCards().get(1).getName() == p.getCurrentTrick().getGauche2()) {
					b = true;
				}
			}
			if (pl.getCards().get(0).getName() == p.getCurrentTrick().getGauche1()) {
				if (pl.getCards().get(1).getName() == p.getCurrentTrick().getDroite1()
						|| pl.getCards().get(1).getName() == p.getCurrentTrick().getDroite2()) {
					b = true;
				}
			}
			if (pl.getCards().get(0).getName() == p.getCurrentTrick().getGauche2()) {
				if (pl.getCards().get(1).getName() == p.getCurrentTrick().getDroite1()
						|| pl.getCards().get(1).getName() == p.getCurrentTrick().getDroite2()) {
					b = true;
				}
			}

		}

		return b;
	}

	public Props getMidCard() {
		return this.midcard;
	}

	public void setMidCard(Props p) {
		this.midcard = p;
	}

	public void addBot(String n) {
		Bot b = new Bot(n, this);
		this.players.add(b);

	}

	public void addPoints(int points, Player p) {
		p.addPoints(points);
	}

	public Player getPlayer(int id) {
		return this.players.get(id);
	}

	public void addRealPlayer(String n, int a) {
		Real r = new Real(a, n, this);
		this.players.add(r);
		this.nbplayers += 1;
	}

	public Player youngestPlayer() {
		Player p;
		if (this.players.get(0).getAge() <= this.players.get(1).getAge()
				&& this.players.get(0).getAge() <= this.players.get(2).getAge()) {
			p = this.players.get(0);
		} else if (this.players.get(1).getAge() <= this.players.get(0).getAge()
				&& this.players.get(1).getAge() <= this.players.get(2).getAge()) {
			p = this.players.get(1);
		} else {
			p = this.players.get(2);
		}
		return p;
	}

	public void distribuer() {
		this.partieEnCours = true;
		this.midcard = tasdeProps.get(6);
		this.players.get(0).setCards(tasdeProps.get(0));
		this.players.get(0).setCards(tasdeProps.get(1));
		this.players.get(1).setCards(tasdeProps.get(2));
		this.players.get(1).setCards(tasdeProps.get(3));
		this.players.get(2).setCards(tasdeProps.get(4));
		this.players.get(2).setCards(tasdeProps.get(5));
	}

	public void prepareGame() {
		this.tasdeProps = this.midcard.TasdeProps();
		Collections.shuffle(this.tasdeProps);
		Scanner sc = new Scanner(System.in);
		int i = 1;
		for (i = 1; i <= 3; i++) {

			System.out
					.println("Joueur : " + i + ", Quel type de joueur voulez vous ajouter ? Bot (0) ou VraiJoueur(1)");
			String sReponse = sc.nextLine();
			if (sReponse.equals("0")) {
				System.out.println("Quel nom donnez vous au bot ?");
				sReponse = sc.nextLine();
				String name = sReponse;
				this.addBot(name);
			} else {
				System.out.println("Comment vous appelez vous ?");
				sReponse = sc.nextLine();
				String name = sReponse;
				System.out.println("Quel age avez vous  ?");
				sReponse = sc.nextLine();
				Integer age = Integer.parseInt(sReponse);
				this.addRealPlayer(name, age);
			}
		}

		this.distribuer();
		this.pile = new Pile();
		if (this.players.get(0).equals(this.youngestPlayer())) {
			Player inter = this.players.get(2);
			this.players.set(2, this.youngestPlayer());
			this.players.set(0, inter);
		}
		if (this.players.get(1).equals(this.youngestPlayer())) {
			Player inter = this.players.get(2);
			this.players.set(2, this.youngestPlayer());
			this.players.set(1, inter);
		}
	}

	public Player winner() {
		Player p;
		if (this.players.get(0).getScore() > this.players.get(1).getScore()
				&& this.players.get(0).getScore() > this.players.get(2).getScore()) {
			p = this.players.get(0);
		} else if (this.players.get(1).getScore() > this.players.get(0).getScore()
				&& this.players.get(1).getScore() > this.players.get(2).getScore()) {
			p = this.players.get(1);
		} else {
			p = this.players.get(2);
		}
		return p;
	}

	public void end() {
		System.out.print("Voici le dernier tour : The Other Hat trick !  ");
		Props Hat = new Props(1, "The Hat", false);
		Props OR = new Props(1, "The Other Rabbit", false);
		if (!this.checkTrick(pile, this.players.get(2)) && !this.checkTrick(pile, this.players.get(1))
				&& !this.checkTrick(pile, this.players.get(0))) {
			System.out.print("Personne ne peut realiser le tour !  ");
			if (this.players.get(0).getCards().get(0).equals(Hat) || this.players.get(0).getCards().get(1).equals(Hat)
					|| this.players.get(0).getCards().get(0).equals(OR)
					|| this.players.get(0).getCards().get(1).equals(OR)) {
				this.players.get(0).addPoints(-3);
				System.out.print(this.players.get(0).getName() + " perd 3 points ! ");
			}
			if (this.players.get(1).getCards().get(0).equals(Hat) || this.players.get(1).getCards().get(1).equals(Hat)
					|| this.players.get(1).getCards().get(0).equals(OR)
					|| this.players.get(1).getCards().get(1).equals(OR)) {
				this.players.get(1).addPoints(-3);
				System.out.print(this.players.get(1).getName() + " perd 3 points ! ");
			}
			if (this.players.get(2).getCards().get(0).equals(Hat) || this.players.get(2).getCards().get(1).equals(Hat)
					|| this.players.get(2).getCards().get(0).equals(OR)
					|| this.players.get(2).getCards().get(1).equals(OR)) {
				this.players.get(2).addPoints(-3);
				System.out.print(this.players.get(2).getName() + " perd 3 points ! ");
			}
		} else {
			if (this.checkTrick(pile, this.players.get(0))) {
				this.players.get(0).addPoints(6);
				System.out.print(this.players.get(0).getName() + " gagne 6 points avec ce dernier tour ! ");
			}
			if (this.checkTrick(pile, this.players.get(1))) {
				this.players.get(1).addPoints(6);
				System.out.print(this.players.get(0).getName() + " gagne 6 points avec ce dernier tour ! ");
			}
			if (this.checkTrick(pile, this.players.get(2))) {
				this.players.get(0).addPoints(6);
				System.out.print(this.players.get(2).getName() + " gagne 6 points avec ce dernier tour ! ");
			}
		}
	}

	public void Play() {
		System.out.println("Bienvenue dans The Other Hat Trick");
		System.out.println(this.youngestPlayer().getName() + " est le premier � jouer");
		this.youngestPlayer().Jouer(this.pile);
		while (!this.pile.getTricks().isEmpty()) {
			newTurn();
			this.players.get(2).Jouer(this.pile);
		}
		end();
		System.out.println("La partie est termin閑 ! Le grand gagnant est " + this.winner().getName());
		System.out.println("La 7鑝e carte 閠ait " + this.midcard.getName());
		System.out.println(
				"Voici les scores finaux : " + this.players.get(0).getName() + " : " + this.players.get(0).getScore()
						+ "; " + this.players.get(1).getName() + " : " + this.players.get(1).getScore() + "; "
						+ this.players.get(2).getName() + " : " + this.players.get(2).getScore());

	}

	public void newTurn() {
		Player inter;
		inter = this.players.get(2);
		this.players.set(2, this.players.get(1));
		this.players.set(1, this.players.get(0));
		this.players.set(0, inter);
		System.out
				.println("Voici les scores : " + this.players.get(0).getName() + " : " + this.players.get(0).getScore()
						+ "; " + this.players.get(1).getName() + " : " + this.players.get(1).getScore() + "; "
						+ this.players.get(2).getName() + " : " + this.players.get(2).getScore());
		System.out.println("Le prochain joueur est " + this.players.get(2).getName());
	}
public static void main(String[] args ) {
	Game g = new Game();
	g.prepareGame();
	g.Play();
}
}
