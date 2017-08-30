import GenericListPackage.GenericList;
import GenericListPackage.GenericListBounded;
import Objects.Animal;
import Objects.Dog;
import Objects.Human;
import StackExample.GenericStack;

import java.util.Collection;

/**
 * Created by Martin on 01-08-2017.
 */
public class GenericsDotExe
{
    public static void main(String[] args)
    {
        Human guyNamedJohnny = new Human("Johhny");

        GenericList<Human> humanGenericList = new GenericList<>();

        humanGenericList.getArrayList().add(guyNamedJohnny);

        Animal sheep = new Animal(55, "Sheldon", "Scottish Sheep");
        Dog goodBoy = new Dog(60, "Rex", "German Shepherd");

        GenericList<Animal> animalGenericList = new GenericList<>();

        animalGenericList.getArrayList().add(sheep);
        animalGenericList.getArrayList().add(goodBoy);

        GenericListBounded<Dog> dogGenericListBounded = new GenericListBounded<>();

        dogGenericListBounded.getArrayList().add(goodBoy);
        dogGenericListBounded.getArrayList().get(0).bark(); // Her fanger vi goodboy, og anvender "bark()" funktionen

        //dogGenericListBounded.getArrayList().add(guyNamedJohnny);

        GenericStack<Human> humanGenericStack = new GenericStack<>();
        humanGenericStack.push(new Human("Al Bundy"));
        humanGenericStack.push(new Human("Frasier"));
        humanGenericStack.push(new Human("Alf"));

        System.out.println(humanGenericStack.peek().getName());
        Human notSoHuman = humanGenericStack.pop();
        System.out.println(humanGenericStack.peek().getName());
    }
}
