package Game;
import java.util.*;
import Cards.*;
import Cards.Tricks.Trick;
public class Pile {
private LinkedList<Tricks> tricks;
private LinkedList<Tricks> tricksOpen;


public Pile() {
	this.tricks = new LinkedList<Tricks>();
	for(Trick t : Trick.values()) {
		Tricks tr = new Tricks(t.getName(), t.getPoints(),t.getGauche1(),t.getGauche2(), t.getDroite1(), t.getDroite2());
		this.tricks.add(tr);
		
	}
	Collections.shuffle(this.tricks);
	Tricks OHT = new Tricks("The Other Hat Trick", 6, "The Other Rabbit","The invisible Rabbit", "The Hat","The invisible Rabbit");
	this.tricks.add(OHT);
	this.tricksOpen = new LinkedList<Tricks>();
	this.tricksOpen.add(this.tricks.pop());
}
private static Pile p = null;

public static synchronized Pile getInstance() {
	 if (p == null)
     {   p = new Pile(); 
     }
     return p;
 }


public void melanger() {
	Collections.shuffle(this.tricks);
}
public LinkedList<Tricks> getTricks() {
	return this.tricks;
}
public void openNext() {
	this.tricksOpen.add(this.tricks.getFirst());
	this.tricks.pop();
}
public Tricks getCurrentTrick() {
	return this.tricksOpen.getLast();
}
public static void main(String[] args) {
	Pile p = new Pile();
	
}
public LinkedList<Tricks> getTricksOpen() {
	return this.tricksOpen;
}
}
