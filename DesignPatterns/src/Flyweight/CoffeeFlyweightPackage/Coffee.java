package Flyweight.CoffeeFlyweightPackage;

import java.util.Random;

/**
 * Created by Martin on 11-08-2017.
 */

// Det konkrete flyweight object
public class Coffee implements ICoffee
{
    private final String flavor; // Intrinsic state, denne deles med andre

    public Coffee(String newFlavor){
        this.flavor = newFlavor;
        System.out.println("Coffee is created with: " + flavor);
    }

    public void serveCoffee(CoffeeContext context){
        System.out.println("Serving:    " + flavor + " to table " + context.getTable());
    }

    public String getFlavor(){
        return flavor;
    }
}
