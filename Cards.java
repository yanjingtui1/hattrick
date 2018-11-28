public class Cards {
    private String type;
    //private int value;
    private int x = 0;
    private int y = 0;
    private int cardWidth = 80;
    private int cardHeight = 100;
    private boolean isFaceUp;
    private String cardImage;

    public Cards() {
        this.isFaceUp = false;
    }


    public Cards(String type, boolean isFaceUp) {
        this.type = type;
        this.isFaceUp = isFaceUp;

    }

    public String getType() {
        return type;
    }


}
