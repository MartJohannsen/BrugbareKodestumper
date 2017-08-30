package Flyweight.CoffeeFlyweightPackage;

import java.util.HashMap;

/**
 * Created by Martin on 11-08-2017.
 */
public class CoffeeFactory
{
    private HashMap<String, Coffee> hashmapOfFlavors = new HashMap<String, Coffee>();

    // Ignorer start
    private static CoffeeFactory instance = null;

    private CoffeeFactory() {
    }

    public static CoffeeFactory getInstance(){
        if(instance == null){
            return instance = new CoffeeFactory();
        }
        else{
            return instance;
        }
    }
    // Ignorer slut

    // Fungerer i samme stil som singleton, eksisterer den i forvejen
    // så hentes smagen ud af hashmappet
    public Coffee getCoffeeFlavor(String flavorName){
        Coffee flavor = hashmapOfFlavors.get(flavorName);
        if(flavor == null){
            //Hvis smagen ikke eksisterer instantieres et ny kaffeobjekt.
            flavor = new Coffee(flavorName);
            // Navnet og kaffeobjektet lægges ind i hashmappet. (Her er ingen gentagelser!
            hashmapOfFlavors.put(flavorName, flavor);
        }
        return flavor;
    }

    public int getTotalCoffeeFlavorsMade(){
        return hashmapOfFlavors.size();
    }
}
