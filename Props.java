public class Props extends Cards{
    private int count;
    private String name;
    private boolean theMiddleCard;

    public Props(String type, boolean isFaceup,int count, String name, boolean theMiddleCard){
        super(type,isFaceup);
        this.count = count;
        this.name = name;
        this.theMiddleCard = false;
    }

    public void setPropsAtMiddle(){
        this.theMiddleCard = true;
    }

    public String getName() {
        return name;
    }
}
