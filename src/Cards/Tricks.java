package Cards;
import java.util.*;
import Game.*;
public class Tricks extends Cards {
    public final String trickCombinations[][] = {{"The Rabbit", "Carrots"}, {"The Other Rabbit", "Carrots"},
            {"The Rabbit", "The Lettuce"}, {"The Other Rabbit", "The Lettuce"}, {"Carrots", "Carrots"},
            {"The Hat", "Carrots"}, {"The Hat", "The Lettuce"}, {"Carrots", "The Lettuce"}, {"The Hat", "Carrots"},
            {"The Hat", "The Rabbit"}, {"The Hat", "The Other Rabbit"}, {"The Rabbit"}, {"The Other Rabbit"}};
    private String[] combination;
    private String name;
   
    public enum Trick {
    	one("The Hungry Rabbit", 1, "The Rabbit","The Other Rabbit","Carrots", "The Lettuce"),
    	two("The Bunch of Carrots", 2,"Carrots","The invisible Rabbit", "Carrots","The invisible Rabbit"),
    	three("The Vegetable Patch", 3, "Carrots","The invisible Rabbit","The Lettuce","The invisible Rabbit"),
    	four("The Rabbit That Didn't Like Carrots", 4, "The Rabbit","The Other Rabbit","The Lettuce","The invisible Rabbit" ),
    	five("The Pair of Rabbit", 5, "The Rabbit","The invisible Rabbit","The Other Rabbit","The invisible Rabbit"),
    	six("The Vegetable Hat Trick", 2, "Carrots", "The Lettuce","The Hat","The invisible Rabbit" ),
    	seven("The Carrot Hat Trick", 3, "Carrots","The invisible Rabbit", "The Hat","The invisible Rabbit"),
    	eight("The Slightly Easier Hat Trick", 4, "The Rabbit","The Other Rabbit","The Hat","The invisible Rabbit"),
    	nine("The Hat Trick", 5, "The Rabbit","The invisible Rabbit","The Hat","The invisible Rabbit");
    	
    	private final int points;
    	private final String name;
    	private final String gauche1;
    	private final String gauche2;
    	private final String droite1;
    	private final String droite2;
    	public String getName() {
    		return this.name;
    				
    	}
    	public int getPoints() {
    		return this.points;
    	}
    	public String getGauche1() {
    		return this.gauche1;
    				
    	}
    	public String getGauche2() {
    		return this.gauche2;
    				
    	}
    	public String getDroite1() {
    		return this.droite1;
    				
    	}
    	public String getDroite2() {
    		return this.droite2;
    				
    	}
    	
    	private Trick(String name,int points, String gauche1,String gauche2, String droite1, String droite2) {
    		this.points = points;
    		this.name = name;
    		this.gauche1=gauche1;
    		this.gauche2=gauche2;
    		this.droite1=droite1;
    		this.droite2 = droite2;
    	}
    	
    
    }
 
    private final int points;
	private final String gauche1;
	private final String gauche2;
	private final String droite1;
	private final String droite2;

    	public Tricks(String name,int points, String gauche1,String gauche2, String droite1, String droite2) {
		this.points = points;
		this.name = name;
		this.gauche1=gauche1;
		this.gauche2=gauche2;
		this.droite1=droite1;
		this.droite2 = droite2; }
    public boolean equals(Tricks t) {
    	return this.getName() == t.getName();
    }
   
    public String toString() {
    	String s = ("" + this.name +", Points : " + this.points +" Combinaison gauche : " + this.getGauche1() +" ou " + this.getGauche2() +" , Combinaison droite :" + this.getDroite1() +" ou " + this.getDroite2());
    	if(this.getGauche2() == "The invisible Rabbit" && this.getDroite2() == "The invisible Rabbit") {
    		s = ("" + this.name +", Points : " + this.points +" Combinaison gauche : " + this.getGauche1() +" , Combinaison droite :" + this.getDroite1());
    	}
    	if(this.getGauche2() == "The invisible Rabbit" && this.getDroite2() != "The invisible Rabbit"){
    		s = ("" + this.name +", Points : " + this.points +" Combinaison gauche : " + this.getGauche1() +" , Combinaison droite :" + this.getDroite1() +" ou " + this.getDroite2());
    	}
    	if(this.getDroite2() == "The invisible Rabbit" && this.getGauche2() != "The invisible Rabbit"){
    		s = ("" + this.name +", Points : " + this.points +" Combinaison gauche : " + this.getGauche1() +" ou " + this.getGauche2() + ", Combinaison droite :" + this.getDroite1());	
    	}
    	return s;
    }
    public String getName() {
    	return this.name;
    }
    public String getGauche1() {
		return this.gauche1;
				
	}
	public String getGauche2() {
		return this.gauche2;
				
	}
	public String getDroite1() {
		return this.droite1;
				
	}
	public String getDroite2() {
		return this.droite2;
				
	}
	public int getPoints() {
		return this.points;
	}
	public static void main(String[] args) {
		
	}
    }

