public class Produce {
    private int xp;
    private String name;
    private int time;
    private int amount;
    private int price;

    public Produce(int xp, String name, int price){
        this.xp = xp;
        this.name = name;
        this.amount = 3;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getAmount(){
        return this.amount;
    }

    public void resetAmount(){
        this.amount = 0;
    }

    public void subtractAmount(int num){
        this.amount -= num;
    }

    public void addAmount(int num){
        this.amount += num;
    }

    public int getXP(){
        return this.xp;
    }

    public int getPrice(){
        return this.price;
    }

    public String toString(){
        return "You currently have " + amount + " " + name;
    }
}
