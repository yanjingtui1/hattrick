package Player;
import Game.*;
import java.util.*;

import Cards.Props;
import Cards.Tricks;
import Game.Pile;
import java.util.*;
public abstract class Player {
protected int age;
protected String name;
protected LinkedList<Props> props;
protected int score;
protected int id;
protected Game g;
protected ArrayList<Tricks> tricksOK;

public Player(String name, Game g) {
	this.g=g;
	this.name = name;
	this.score = 0;
	props = new LinkedList<Props>();
}
public enum Playertype {
	REAL,
	BOT;
}
public void setCards(Props p) {
	this.props.add(p);
}
public LinkedList<Props> getCards() {
	return this.props;
}

public boolean equals(Player p) {
	return this.getName() == p.getName();
}
public int getAge() {
	return this.age;
}

public int getScore() {
	return this.score;
}
public void addPoints(int p) {
	this.score += p;
}
public void Jouer(Pile p) {

	this.chooseTrick(p);
	this.prepareProps(p);
	this.performTrick(p);
	
}
public String getName() {
	return this.name;
}
public Props getCards(Player p, int cartemontre) {
	return p.props.get(cartemontre);
}
public void swap(Player p, int carteorigine, int cartevoulue ) {
	Props inter = this.props.get(carteorigine);  
	this.props.set(carteorigine, p.props.get(cartevoulue));
	p.props.set(cartevoulue, inter);
}
public void openNext(Pile p) {
	p.openNext();
}
public Game getGame() {
	return this.g;
}

abstract void chooseTrick(Pile p);
abstract void prepareProps(Pile p);
abstract void onWin(Pile p);
abstract void performTrick(Pile p);
public void showCard(Player p1, Player p2, int cartemontre) {
	p1.getCards(this, cartemontre);
	p2.getCards(this, cartemontre);
}
}

