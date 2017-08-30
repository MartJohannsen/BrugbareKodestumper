package Singleton;

/**
 * Created by Martin on 08-06-2017.
 */
public class Main_Runner
{
    public static void main(String[] args)
    {
        Singleton_Example singleton_example = Singleton_Example.getInstance();
        singleton_example.demoMethod();

        Singleton_Example.getInstance().demoMethod();



    }
}
