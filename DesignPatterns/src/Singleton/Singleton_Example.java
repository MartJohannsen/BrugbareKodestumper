package Singleton;

/**
 * Created by Martin on 08-06-2017.
 */
public class Singleton_Example
{
    private static Singleton_Example instance = null;

    private Singleton_Example(){

    }

    public static Singleton_Example getInstance(){
        if(instance == null){
            return instance = new Singleton_Example();
        }
        else{
            return instance;
        }
    }

    public static void demoMethod(){
        System.out.println("I am a singleton, hear me roar, for i am alone in this universe!");
    }
}
