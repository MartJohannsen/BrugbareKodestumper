package Flyweight;


import Flyweight.CoffeeFlyweightPackage.Coffee;
import Flyweight.CoffeeFlyweightPackage.CoffeeContext;
import Flyweight.CoffeeFlyweightPackage.CoffeeFactory;

import java.util.Random;

/**
 * Created by Martin on 11-08-2017.
 */

// Denne klasse fungerer som den fysiske verdens tjener!!! :-)
public class TestFlyweight
{
    // Denne liste består af kaffe objekter
    private static Coffee[] coffees = new Coffee[10001];
    //
    private static CoffeeContext[] tablesOfContext = new CoffeeContext[10001];
    private static int ordersCount = 0;
    public static  Random random = new Random();


    public static void main(String[] args)
    {
        for(int i = 0; i < 10000; i++){
            takeOrder(getRandomCoffeeFlavourString(), getRandomTableNumber());
        }

        for(int i = 0; i < ordersCount; i++){
            coffees[i].serveCoffee(tablesOfContext[i]);
        }

        System.out.println("\n Totale antal kaffeobjekter skabt:    " + CoffeeFactory.getInstance().getTotalCoffeeFlavorsMade());
    }

    public static void takeOrder(String flavorIn, int table){
        coffees[ordersCount] = CoffeeFactory.getInstance().getCoffeeFlavor(flavorIn); // Instantierer en ny kop kaffe, og tager derved enten en gammelsmag, eller opretter en ny.
        tablesOfContext[ordersCount] = new CoffeeContext(table);
        System.out.println("Order placed for table :    " + tablesOfContext[ordersCount].getTable());
        ordersCount++;
    }

    public static String getRandomCoffeeFlavourString(){
        String flavorString = "";
        int max = 5;
        int min = 1;
        int randomNum = random.nextInt((max - min) + 1) + min;

        switch (randomNum){
            case 1: flavorString = "Cafe Latte"; break;
            case 2: flavorString = "Espresso"; break;
            case 3: flavorString = "Americano"; break;
            case 4: flavorString = "Mocca Vanilla Ice Latte"; break;
            case 5: flavorString = "Cafe au lait"; break;
        }

        return flavorString;
    }

    public static int getRandomTableNumber(){
        int max = 10;
        int min = 1;
        int randomNum = random.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}
