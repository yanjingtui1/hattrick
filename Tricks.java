public class Tricks extends Cards {
    public final String trickCombinations[][] = {{"The Rabbit", "Carrots"}, {"The Other Rabbit", "Carrots"},
            {"The Rabbit", "The Lettuce"}, {"The Other Rabbit", "The Lettuce"}, {"Carrots", "Carrots"},
            {"The Hat", "Carrots"}, {"The Hat", "The Lettuce"}, {"Carrots", "The Lettuce"}, {"The Hat", "Carrots"},
            {"The Hat", "The Rabbit"}, {"The Hat", "The Other Rabbit"}, {"The Rabbit"}, {"The Other Rabbit"}};
    private String[] combination;
    private int point;

    public Tricks(String type, boolean isFaceUp, String[] combination, int point) {
        super(type, isFaceUp);
        this.combination = combination;
        this.point = point;
    }

  /*  public boolean isSuccessful(Props propsLeft, Props propsRight){
        String nameOfPropsLeft = getName(propsLeft);
        String[]  handProps = {propsLeft,propsRight};
        if (propsLeft)
        return true;
    }*/


}
