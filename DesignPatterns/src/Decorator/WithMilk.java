package Decorator;

/**
 * Created by Martin on 13-07-2017.
 */
public class WithMilk extends CoffeeDecorator{

    public WithMilk(Coffee coffee){
        // Coffee bliver nu til WithMilk klassen (Overskrider den gamle)
        super(coffee);
    }

    public double getCost(){
        return super.getCost() + 0.5;
    }

    public String getIngredients()
    {
        return super.getIngredients() + ", Milk";
    }
}
