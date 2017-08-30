package Decorator;

/**
 * Created by Martin on 13-07-2017.
 */
public class SimpleCoffee implements Coffee{
    @Override
    public double getCost(){
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}
