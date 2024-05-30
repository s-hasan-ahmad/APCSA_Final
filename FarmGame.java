import java.util.Scanner;
import java.util.ArrayList;
public class FarmGame {
    static int eggs = 0; static int milk = 0; static int butter = 0; static int brownSugar = 0;
    static int whiteSugar = 0; static int syrup = 0; static int cream = 0; static int cheese = 0;
    static int money = 50;
    static boolean isWheatPlanted; static boolean isCornPlanted; static boolean isCarrotPlanted; static boolean isPumpkinPlanted; static boolean isStrawberryPlanted;
    static int wheatPlanted; static int cornPlanted; static int carrotsPlanted; static int pumpkinsPlanted; static int strawberriesPlanted; static int totalPlots = 10;
    static int xpForNextLevel = 20; static int currentXP = 0; static int farmLevel = 1;
    static ArrayList<Apples> apples = new ArrayList<Apples>();

    public static void viewMarket(Scanner in){
        int[] realArr = new int[4];

        for(int i = 0; i < 4; i++){
            int rand = (int) (Math.random() * 8) + 1;
            for(int j = 0; j < 4; j++){
                if(rand == realArr[j]){
                    i--;
                    break;
                }
                if(j == 3){
                    realArr[i] = rand;
                }
            }
        }

        for(int x : realArr){
            if(x == 1) {
                System.out.println("Eggs: $2 each");
            } else if(x == 2){
                System.out.println("Milk: $3 each");
            } else if(x == 3){
                System.out.println("Butter: $5 each");
            } else if(x == 4){
                System.out.println("Brown Sugar: $1 each");
            } else if(x == 5){
                System.out.println("White Sugar: $2 each");
            } else if(x == 6){
                System.out.println("Syrup: $4 each");
            } else if(x == 7){
                System.out.println("Cream: $3 each");
            } else if(x == 8){
                System.out.println("Cheese: $6 each");
            }
        }

        System.out.println("Would you like to buy anything (y/n): ");
        String buy = in.nextLine();
        if(!buy.equals("y")){return;}
        System.out.println("Which item would you like to buy: ");
        String thing = in.nextLine();
        System.out.println("How many: ");
        int num = in.nextInt();

        if(thing.equalsIgnoreCase("eggs") && money >= num*2){
            money -= num*2;
            eggs += num;
            System.out.println("Success!");
        } else if(thing.equalsIgnoreCase("milk") && money >= num*3){
            money -= num*3;
            milk += num;
            System.out.println("Success!");
        } else if(thing.equalsIgnoreCase("butter") && money >= num*5){
            money -= num*5;
            butter += num;
            System.out.println("Success!");
        } else if(thing.equalsIgnoreCase("brown sugar") && money >= num){
            money -= num;
            brownSugar += num;
            System.out.println("Success!");
        } else if(thing.equalsIgnoreCase("white sugar") && money >= num*2){
            money -= num*2;
            whiteSugar += num;
            System.out.println("Success!");
        } else if(thing.equalsIgnoreCase("syrup") && money >= num*4){
            money -= num*4;
            syrup += num;
            System.out.println("Success!");
        } else if(thing.equalsIgnoreCase("cream") && money >= num*3){
            money -= num*3;
            cream += num;
            System.out.println("Success!");
        } else if(thing.equalsIgnoreCase("cheese") && money >= num*6){
            money -= num*6;
            cheese += num;
            System.out.println("Success!");
        } else {
            System.out.println("Transaction failed!");
        }
        return;
    }
    
    public static void plant(Produce plant, int num) {
        String plantName = plant.getName();
        System.out.println("Remember, you only have " + totalPlots + " total fields!");
        if (plantName.equals("wheat") && isWheatPlanted) {
            System.out.println("Just wait, you've already planted this!");
            return;
        } else if (plantName.equals("corn") && isCornPlanted) {
            System.out.println("Just wait, you've already planted this!");
            return;
        } else if (plantName.equals("carrots") && isCarrotPlanted) {
            System.out.println("Just wait, you've already planted this!");
            return;
        } else if (plantName.equals("pumpkins") && isPumpkinPlanted) {
            System.out.println("Just wait, you've already planted this!");
            return;
        } else if (plantName.equals("strawberries") && isStrawberryPlanted) {
            System.out.println("Just wait, you've already planted this!");
            return;
        }

        if (num > plant.getAmount()) {
            System.out.println("You do not have enough of this plant!");
            return;
        }

        int usedPlots = wheatPlanted + cornPlanted + carrotsPlanted + pumpkinsPlanted + strawberriesPlanted;
        if (plantName.equals("wheat") && usedPlots + num <= totalPlots) {
            wheatPlanted = num;
            plant.subtractAmount(num);
            isWheatPlanted = true;
            System.out.println("Success!");
            System.out.println();
            return;
        } else if (plantName.equals("corn") && usedPlots + num <= totalPlots) {
            cornPlanted = num;
            plant.subtractAmount(num);
            isCornPlanted = true;
            System.out.println("Success!");
            System.out.println();
            return;
        } else if (plantName.equals("carrots") && usedPlots + num <= totalPlots) {
            carrotsPlanted = num;
            plant.subtractAmount(num);
            isCarrotPlanted = true;
            System.out.println("Success!");
            System.out.println();
            return;
        } else if (plantName.equals("pumpkins") && usedPlots + num <= totalPlots) {
            pumpkinsPlanted = num;
            plant.subtractAmount(num);
            isPumpkinPlanted = true;
            System.out.println("Success!");
            System.out.println();
            return;
        } else if (plantName.equals("strawberries") && usedPlots + num <= totalPlots) {
            strawberriesPlanted = num;
            plant.subtractAmount(num);
            isStrawberryPlanted = true;
            System.out.println("Success!");
            System.out.println();
            return;
        }
    }

    public static void harvest(Produce p){
        String plantName = p.getName();
        if (plantName.equals("wheat") && isWheatPlanted) {
            p.addAmount(wheatPlanted*6);
            currentXP += wheatPlanted*p.getXP();
            isWheatPlanted = false;
            wheatPlanted = 0;
        } else if (plantName.equals("corn") && isCornPlanted) {
            p.addAmount(cornPlanted*5);
            currentXP += cornPlanted*p.getXP();
            isCornPlanted = false;
            cornPlanted = 0;;
        } else if (plantName.equals("carrots") && isCarrotPlanted) {
            p.addAmount(carrotsPlanted*4);
            currentXP += carrotsPlanted*p.getXP();
            isCarrotPlanted = false;
            carrotsPlanted = 0;;
        } else if (plantName.equals("pumpkins") && isPumpkinPlanted) {
            p.addAmount(pumpkinsPlanted*3);
            currentXP += pumpkinsPlanted*p.getXP();
            isPumpkinPlanted = false;
            pumpkinsPlanted = 0;;
        } else if (plantName.equals("strawberries") && isStrawberryPlanted) {
            p.addAmount(strawberriesPlanted*2);
            currentXP += strawberriesPlanted*p.getXP();
            isStrawberryPlanted = false;
            strawberriesPlanted = 0;
        }
    }

    public static int checkForUpgrade(){
        if(xpForNextLevel - currentXP <= 0 && farmLevel < 8){
            farmLevel++;
            currentXP = 0;
            xpForNextLevel = farmLevel * 20;
            if(farmLevel == 2){
                System.out.println("Congratulations! You are a level 2 farmer and you can now plant corn! You also get 2 more plots!");
                totalPlots += 2;
                return 2;
            }
            if(farmLevel == 3){
                System.out.println("Congratulations! You are a level 3 farmer! You also get 2 more plots!");
                totalPlots += 2;
                return 3;
            }
            if(farmLevel == 4){
                System.out.println("Congratulations! You are a level 4 farmer and you can now plant carrots! You also get 2 more plots!");
                totalPlots += 2;
                return 4;
            }
            if(farmLevel == 5){
                System.out.println("Congratulations! You are a level 5 farmer and you can now plant pumpkins! You also get 2 more plots!");
                totalPlots += 2;
                return 5;
            }
            if(farmLevel == 6){
                System.out.println("Congratulations! You are a level 6 farmer and you can now plant strawberries! You also get 2 more plots!");
                totalPlots += 2;
                return 6;
            }
            if(farmLevel == 7){
                System.out.println("Congratulations! You are a level 7 farmer! You also get 2 more plots!");
                totalPlots += 2;
                return 7;
            }
            if(farmLevel == 8){
                System.out.println("Congratulations! You are a level 8 farmer and you can now plant apple trees! Why are you still playing this stupid game? You also get 2 more plots!");
                totalPlots += 2;
                return 8;
            }
        }
        return -1;
    }

    public static void addAppleTree(Scanner in){
        System.out.println("Apple trees cost $50!");
        if(money < 50){
            System.out.println("You do not have enough money!");
            return;
        }
        System.out.println("How many apple trees do you want to buy?");
        int num = in.nextInt();
        if(money < num*50){
            System.out.println("You do not have enough money!");
            return;
        }
        for(int i = 0; i < num; i++){
            apples.add(new Apples(10, 12));
            money -= 50;
        }
        System.out.println("Success!");
    }

    public static void harvestApples(){
        for (Apples a : apples) {
            a.addAmount(2 * a.getTreeLevel());
            currentXP += 2 * a.getTreeLevel() * a.getXP();
            a.upgrade();
            a.updateTotalAmount();
        }
    }

    public static void sellCrops(Produce p, int num){
        String plantName = p.getName();
        if (plantName.equals("wheat") && p.getAmount() >= num) {
            money += num*p.getPrice();
            p.subtractAmount(num);
            System.out.println("Success!");
            return;
        } else if (plantName.equals("corn") && p.getAmount() >= num) {
            money += num*p.getPrice();
            p.subtractAmount(num);
            System.out.println("Success!");
            return;
        } else if (plantName.equals("carrots") && p.getAmount() >= num) {
            money += num*p.getPrice();
            p.subtractAmount(num);
            System.out.println("Success!");
            return;
        } else if (plantName.equals("pumpkins") && p.getAmount() >= num) {
            money += num*p.getPrice();
            p.subtractAmount(num);
            System.out.println("Success!");
            return;
        } else if (plantName.equals("strawberries") && p.getAmount() >= num) {
            money += num*p.getPrice();
            p.subtractAmount(num);
            System.out.println("Success!");
            return;
        }

        if(p instanceof Apples){
            Apples a = (Apples) p;
            if(a.getTotalAmount() >= num){
                money += num*a.getPrice();
                a.subtractTotalAmount(num);
                System.out.println("Success!");
                return;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Produce wheat = new Produce(1, "wheat", 1);
        Produce corn = new Produce(2, "corn", 2);
        Produce carrots = new Produce(3, "carrots", 4);
        Produce pumpkins = new Produce(4, "pumpkins", 5);
        Produce strawberries = new Produce(5, "strawberries", 8);
        Produce[] list = {corn, carrots, pumpkins, strawberries};
        for(Produce x : list){
            x.subtractAmount(3);
        }

        while(true){
            int up = checkForUpgrade();
            if(up == 2){corn.addAmount(3);}
            if(up == 4){carrots.addAmount(3);}
            if(up == 5){pumpkins.addAmount(3);}
            if(up == 6){strawberries.addAmount(3);}

            harvest(wheat);
            if(farmLevel >= 2){harvest(corn);}
            if(farmLevel >= 4){harvest(carrots);}
            if(farmLevel >= 5){harvest(pumpkins);}
            if(farmLevel >= 6){harvest(strawberries);}
            if(farmLevel >= 8){harvestApples();}

            System.out.println("Good morning!");
            System.out.println("(Quit) if you want to end your game, type anything else if you want to keep playing: ");
            String quit = in.nextLine();
            if(quit.equalsIgnoreCase("quit")){
                System.out.println("See you another time!");
                break;
            }
            while(true){

                System.out.println("(Sleep) if you want to end this day");
                String sleep = in.nextLine();
                if(quit.equalsIgnoreCase("sleep")){
                    System.out.println("Good night!");
                    break;
                }

                System.out.println("You have " + totalPlots + " fields that you can use to (plant)");
                System.out.println("You have $" + money);
                System.out.println("You have " + currentXP + " XP, and you are " + (xpForNextLevel - currentXP) + " points away from your next level!");
                System.out.println("Your farm level is " + farmLevel + "!");
                System.out.println(wheat);
                if(farmLevel >= 2){System.out.println(corn);}
                if(farmLevel >= 4){System.out.println(carrots);}
                if(farmLevel >= 5){System.out.println(pumpkins);}
                if(farmLevel >= 6){System.out.println(strawberries);}
                if(farmLevel >= 8){System.out.println(new Apples(0, 0));}
                System.out.println("You can browse the (shop) and purchase some amazing goods!");
                System.out.println("You can (sell) your crops, but make sure not to sell everything or you lose!");
                if(farmLevel >= 8){System.out.println("You can also purchase (apple trees)!");}


                String decision = in.nextLine();
                if(decision.equalsIgnoreCase("sleep")){break;}
                else if(decision.equalsIgnoreCase("shop")){viewMarket(in);}
                else if(decision.equalsIgnoreCase("plant")){
                    System.out.println("Which plant? ");
                    String p = in.nextLine();
                    System.out.println("And how many crops do you want to plant? ");
                    int n = in.nextInt();
                    if (p.equals("wheat")){
                        plant(wheat, n);
                    } else if (p.equals("corn")){
                        plant(corn, n);
                    } else if (p.equals("carrots")){
                        plant(carrots, n);
                    } else if (p.equals("pumpkins")){
                        plant(pumpkins, n);
                    } else if (p.equals("strawberries")){
                        plant(strawberries, n);
                    }
                }
                else if(decision.equalsIgnoreCase("apple tree")){addAppleTree(in);}
                else if(decision.equalsIgnoreCase("sell")){
                    System.out.println("Which crop? ");
                    String p = in.nextLine();
                    System.out.println("And how many crops do you want to sell? ");
                    int n = in.nextInt();
                    if (p.equals("wheat")){
                        sellCrops(wheat, n);
                    } else if (p.equals("corn")){
                        sellCrops(corn, n);
                    } else if (p.equals("carrots")){
                        sellCrops(carrots, n);
                    } else if (p.equals("pumpkins")){
                        sellCrops(pumpkins, n);
                    } else if (p.equals("strawberries")){
                        sellCrops(strawberries, n);
                    } else if (p.equals("apples")){
                        sellCrops(apples.get(0), n);
                    }
                }
            }

        }
        

    }
}
