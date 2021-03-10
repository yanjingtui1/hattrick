package Player;
import java.util.*;
import Cards.*;
import Game.*;
public class Real extends Player {
public Real(int age, String name, Game g) {
	super(name, g);
	this.age = age;
}

public void chooseTrick(Pile p) {	
		System.out.println("Voici vos nouveaux Props : " + this.getCards());
		System.out.println("Le tour actuel est :" + p.getCurrentTrick());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel tour voulez vous realiser ? Celui la (0) ou le suivant (1) ? ");
		String sReponse = sc.nextLine();
		Tricks t;
		if(sReponse.equals("0")) {
			t = p.getCurrentTrick();
		}else {
			p.openNext();
			t = p.getCurrentTrick();
		}
		System.out.println("Vous avez choisi le tour  " + t.toString());
		
}
public void prepareProps(Pile pl) {
	System.out.println("Le tour actuel est :" + pl.getCurrentTrick());
	int propswap;
	System.out.println("Voici vos Props : " + this.getCards());
	Scanner sc = new Scanner(System.in);
	System.out.println("Quel props souhaitez vous echanger ?  Le premier (0) ou le deuxieme (1) ? ");
	String sReponse = sc.nextLine();
	Tricks t;
	if(sReponse.equals("0")) {
		propswap = 0;
	}else {
		propswap = 1;
	}
	System.out.println("Vous avez choisi le prop : " + this.getCards().get(propswap));
	System.out.println("Selectionnez le joueur avec qui vous souhaitez echanger : " + this.g.getPlayer(0).getName() + " (0) ou " + this.g.getPlayer(1).getName() +" (1)");
	Player p;
	sReponse = sc.nextLine();
	if(sReponse.equals("0")) {
		p = this.g.getPlayer(0);
	}else {
		p = this.g.getPlayer(1);
	}
	
	System.out.println("Selectionnez le prop de ce joueur que vous souhaitez echanger : Le premier (0) ou le deuxieme (1) ? ");
	sReponse = sc.nextLine();
	int propplayer;
	if(sReponse.equals("0")) {
		propplayer = 0;
	}else {
		propplayer = 1;
	}
	this.swap(p, propswap, propplayer);
}
public void onForfeit() {
	Scanner sc = new Scanner(System.in);

	System.out.println("Vous ne realisez pas le tour. Choisissez un prop � montrer " +this.props.get(0) + "(0) ou " + this.props.get(1) + " (1)" );
	String sReponse = sc.nextLine();
	Props show;
	if(!this.props.get(0).isFacedUp() && !this.props.get(1).isFacedUp() ) {
		
		if(sReponse.equals("0")) {
			this.getCards().get(0).isFacedUp(true);
			System.out.println("Vous montrez la carte : " + this.props.get(0));
		}else {
			
			this.getCards().get(1).isFacedUp(true);
			System.out.println("Vous montrez la carte : " + this.props.get(1));
		}
	} 
		else if(this.props.get(0).isFacedUp() && !this.props.get(1).isFacedUp()) {
		System.out.println("La carte montree par " + this.getName() + " est " + this.props.get(1) + " en position : 1" );	
		this.getCards().get(1).isFacedUp(true);
	}
		else if(!this.props.get(0).isFacedUp() && this.props.get(1).isFacedUp()) {
		System.out.println("La carte montree par " + this.getName() + " est " + this.props.get(0) + " en position : 0" );
		this.getCards().get(0).isFacedUp(true);
	}
		else {
		System.out.println(this.getName() + " a deja montre ses deux cartes ! Rappel :  " + this.props.get(0) + " en position 0 et " + this.props.get(1) +" en position 1" );
	}
	
	}

public void performTrick(Pile p) {
	Scanner sc = new Scanner(System.in);
	
	if(this.g.checkTrick(p, this)) {
		System.out.println("Souhaitez vous realiser le tour ? Oui (0) ou non (1) ? ");
		String sReponse = sc.nextLine();
		if(sReponse.equals("0")) {
			this.onWin(p);
		}else {
			this.onForfeit();
		}
	} else {
		this.onForfeit();
	}
}
public void onWin(Pile p) {
	System.out.println("TADAM ! Vous realisez le tour ! Vous gagnez " + p.getCurrentTrick().getPoints() +" points !");
	Scanner sc = new Scanner(System.in);
	Props midCard = g.getMidCard();
	this.getCards().get(0).isFacedUp(false);
	this.getCards().get(1).isFacedUp(false);
	System.out.println("Voici la carte du milieau : " + midCard);
	this.props.add(midCard);
	System.out.println("Choisissez la carte que vous souhaitez mettre au milieu : " + this.props.get(0) + "(0)" + this.props.get(1) + "(1)" + this.props.get(2) + "(2)");
	String sReponse = sc.nextLine();
	if(sReponse.equals("0")) {
		g.setMidCard(this.props.get(0));
		this.props.set(0, this.props.get(1));
		this.props.set(1, this.props.get(2));
	}else if(sReponse.equals("1")) {
		g.setMidCard(this.props.get(1));
		this.props.set(1, this.props.get(2));
	} else {
		g.setMidCard(this.props.get(2));
	}
	System.out.println("Choisissez la carte que vous souhaitez avoir en premiere position : " + this.props.get(0) + "(0)" + this.props.get(1) + "(1)" );
	String sReponse2 = sc.nextLine();
	if(sReponse2.equals("1")) { 
		
		this.props.set(2, this.props.get(1));
		this.props.set(1, this.props.get(0));
		this.props.set(0, this.props.get(2));
	}
	if(sReponse2.equals("0")) { 
		
		this.props.set(2, this.props.get(2));
		this.props.set(0, this.props.get(0));
		this.props.set(1, this.props.get(1));
	}
	g.addPoints(p.getCurrentTrick().getPoints(), this);
	this.props.remove(2);
	p.getTricksOpen().removeLast();
	p.openNext();
	this.getCards();
	
}

public static void main(String[] args) {

}
}