package Objects;

/**
 * Created by Martin on 01-08-2017.
 */
public class Dog extends Animal {


    public Dog(int heightInCM, String name, String race)
    {
        super(heightInCM, name, race);
    }

    public void bark(){
        System.out.println("Woof woof, i'm a dog");
    }
}
