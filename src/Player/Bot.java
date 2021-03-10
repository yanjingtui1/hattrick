package Player;

import java.util.Observable;

import Cards.Props;
import Cards.Tricks;
import Game.Game;
import Game.Pile;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bot extends Player {
	
    public Bot(String name, Game g) {
        super(name,g);
        this.age = (int) Math.round(Math.random() * 100);
    }

    public void chooseTrick(Pile p) {
        Tricks t;
        if(g.checkTrick(p, this) == true ){
            t = p.getCurrentTrick();
            System.out.println(this.getName() +" a choisi le tour   "+ t.toString());
            
        }else {
            p.openNext();
            t = p.getCurrentTrick();
            System.out.println(this.getName() + " a choisi le tour   "+ t.toString());
        }
    }
    public void performTrick(Pile p) {
    	
    	
    	if(this.g.checkTrick(p, this)) {
    		
    		
    		
    			this.onWin(p);
    		}else {
    			this.onForfeit();
    		}
    	
    	
    }
    public void prepareProps(Pile pi) {
        int propSwap;
        propSwap = lowestCount(this.props.get(0), this.props.get(1));
        Player p;
        Random random = new Random();
        int numPlayer = random.nextInt(1);
        p = this.g.getPlayer(numPlayer);
        int propplayer = random.nextInt(1);
        this.swap(p, propSwap, propplayer);
        System.out.println(this.getName() + " a echange son prop " + propSwap + " contre le prop " + propplayer + " de " + this.g.getPlayer(numPlayer).getName());


    }
    public int lowestCount(Props p1, Props p2) {
    	int low;
    	if(this.props.get(0).getCount() < this.props.get(1).getCount()) {
    		low = 0;
    	} else {
    		low = 1;
    	}
    	return low; }
    
    public void onWin(Pile p) { 
    	System.out.println("TADAM ! "+this.getName() +" realise le tour ! Il gagne " + p.getCurrentTrick().getPoints() +" points !");
    	this.getCards().get(0).isFacedUp(false);
    	this.getCards().get(1).isFacedUp(false);
    	Props midCard = g.getMidCard();
    	this.props.add(midCard);
     	
    		g.setMidCard(this.props.get(0));
    		this.props.set(0, this.props.get(1));
    		this.props.set(1, this.props.get(2));

    	
  
    	
    
    	g.addPoints(p.getCurrentTrick().getPoints(), this);
    	this.props.remove(2); 
    	p.getTricksOpen().removeLast();
    	p.openNext();
    	this.getCards();
    	this.getScore();
    	

    }
    
    	public void onForfeit() {   		
    		System.out.println(this.getName() +" ne realise pas le tour !");
    		if(!this.props.get(0).isFacedUp() && !this.props.get(1).isFacedUp() ) {
    			
    		
    		int low = lowestCount(this.props.get(0), this.props.get(1));
    		this.getCards().get(low).isFacedUp(true);
    		System.out.println("La carte montree par " + this.getName() + " est " + this.props.get(low) + " en position : " + low);
    		

    		}
    		else if(this.props.get(0).isFacedUp() && !this.props.get(1).isFacedUp()) {
    			this.getCards().get(1).isFacedUp(true);
    			System.out.println("La carte montree par " + this.getName() + " est " + this.props.get(1) + " en position : 1" );	

    		}
    		else if(!this.props.get(0).isFacedUp() && this.props.get(1).isFacedUp()) {
    			this.getCards().get(0).isFacedUp(true);
    			System.out.println("La carte montree par " + this.getName() + " est " + this.props.get(0) + " en position : 0" );

    		}
    		else {
    			System.out.println(this.getName() + " a deja montre ses deux cartes ! Rappel :  " + this.props.get(0) + " en position 0 et " + this.props.get(1) +" en position 1" );

    		}
    		}
    }
