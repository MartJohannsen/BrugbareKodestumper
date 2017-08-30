package Flyweight.CoffeeFlyweightPackage;

/**
 * Created by Martin on 11-08-2017.
 */
public class CoffeeContext
{
    private final int tableNumber;

    public CoffeeContext(int tableNumber){
        this.tableNumber = tableNumber;
    }

    public int getTable(){
        return this.tableNumber;
    }
}
