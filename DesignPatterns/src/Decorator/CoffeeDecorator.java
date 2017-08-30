package Decorator;

/**
 * Created by Martin on 13-07-2017.
 */
public class CoffeeDecorator implements Coffee{
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;
    }

    public double getCost(){
        return decoratedCoffee.getCost();
    }

    public String getIngredients(){
        return decoratedCoffee.getIngredients();
    }
}
