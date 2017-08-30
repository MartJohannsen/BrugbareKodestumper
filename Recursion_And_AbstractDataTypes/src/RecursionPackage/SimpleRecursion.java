package RecursionPackage;
/**
 * Created by Martin on 26-07-2017.
 *
 */

public class SimpleRecursion
{
    public static void main(String[] args)
    {

        int number = countDown(10);
        System.out.println("Det returnerede nummer: " + number);

        pause(4);

        System.out.println();

        tailRecursion(1);
    }

    public static int countDown(int num){
        System.out.println("Nummeret er:    " + num);
        if(num > 1){
            return countDown(num - 1);
        }
        else{
            return num;
        }
    }

    public static void tailRecursion(int num){
        if(num <= 5){
            System.out.println("Nummer for denne omgang:    " + num);
            tailRecursion(num + 1);
            System.out.println("Dette er tailrecursion: " + num);
        }
    }

    public static void pause(int amountOfSecs){
        int milliSecs = amountOfSecs * 1000;
        try{
            Thread.sleep(milliSecs);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
