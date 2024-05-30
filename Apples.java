public class Apples extends Produce{
    private int treeLevel;

    private static int totalAmount;
    public Apples(int xp, int price) {
        super(xp, "apples", price);
        treeLevel = 1;
    }

    public int getTreeLevel(){
        return this.treeLevel;
    }

    public int getTotalAmount(){
        return totalAmount;
    }

    public void subtractTotalAmount(int num){
        totalAmount -= num;
    }

    public void upgrade(){
        if(treeLevel < 5) {
            this.treeLevel++;
        }
    }

    public void updateTotalAmount(){
        totalAmount += super.getAmount();
        resetAmount();
    }


    public String toString(){
        return "You have " + totalAmount + " apples";
    }
}
