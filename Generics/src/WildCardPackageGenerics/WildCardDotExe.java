package WildCardPackageGenerics;

import Objects.Animal;
import Objects.Dog;
import Objects.Human;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 05-08-2017.
 *
 * Single class example!
 *
 **/
public class WildCardDotExe
{

    public static void main(String[] args)
    {
        // Objects

        Human guyNamedRonny = new Human("Ronny");
        Animal animal = new Animal(600, "Longiness", "Giraffe");
        Dog dog = new Dog(35, "Speedy", "German Shep");

        // Lists

        List<?> genericWildCardList = new ArrayList<>();

        List<? extends Animal>  boundedGenericWildCardList = new ArrayList<Animal>();
        List<? super Animal>    superGenericWildCardList = new ArrayList<Animal>();

        //genericWildCardList.add(guyNamedRonny);
        //boundedGenericWildCardList.add(animal);
        //printBoundedWildcards(boundedGenericWildCardList);

        unboundedPrintGenericWildcards(boundedGenericWildCardList);
        insertAndPrintSuperBoundedWildcards(superGenericWildCardList);
        unboundedPrintGenericWildcards(superGenericWildCardList);
        superGenericWildCardList.add(animal);
        unboundedPrintGenericWildcards(superGenericWildCardList);
    }

    public static  void unboundedPrintGenericWildcards(List<?> list){
        System.out.println("\nunbounded method: \n");
        for(Object o : list){
            System.out.println(o.getClass());
        }
    }

    public static void printBoundedWildcards(List<? extends Animal> list){
        System.out.println("\nA bounded method:   \n");
        for (Animal animal : list){
            System.out.println(animal.getName() + " is a " + animal.getRace());
        }
    }

    public static void insertAndPrintSuperBoundedWildcards(List<? super Animal> list){
        System.out.println("\nInserts 2 dogs, and prints super bounded list:  \n");

        list.add(new Dog(55, "BOYE", "Corgi"));
        list.add(new Dog(30, "Pucha", "Pug"));

        for(Object o : list){
            if(o instanceof Animal){
                System.out.println((o.getClass().getName()));
            }
        }
    }

}
