package Decorator;

/**
 * Created by Martin on 13-07-2017.
 */
public class CreateCoffeeDotExe {
    public static void main(String[] args) {
        // Først instantieres interface som en simplecoffee klasse.
        Coffee coffee = new SimpleCoffee();
        printInfo(coffee);

        pause(750);

        // Antager ny form, i form af WithMilk
        coffee = new WithMilk(coffee);
        printInfo(coffee);

        pause(750);
        // Gentages
        coffee = new WithSprinkles(coffee);
        printInfo(coffee);


    }

    public static void printInfo(Coffee coffee){
        System.out.println("Cost:   " + coffee.getCost() + "; Ingredients:  " + coffee.getIngredients());
    }

    public static void pause(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
