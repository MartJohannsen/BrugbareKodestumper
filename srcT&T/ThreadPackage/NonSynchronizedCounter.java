package ThreadPackage;

/**
 * Created by Martin on 31-07-2017.
 */
public class NonSynchronizedCounter
{
    public int counter;

    public void increment(){
        counter++;
    }

    public int value(){
        return counter;
    }
}
