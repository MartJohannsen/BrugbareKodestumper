package ThreadPackage;
/**
 * Created by Martin on 31-07-2017.
 */
public class ImplementedRunnableClass implements Runnable
{

    NonSynchronizedCounter nonSynchronizedCounter;

    public ImplementedRunnableClass(NonSynchronizedCounter nonSynchronizedCounter){
        this.nonSynchronizedCounter = nonSynchronizedCounter;
    }


    public void run()
    {

        int i = 1;

        while (i<=75){
            i++;
            nonSynchronizedCounter.increment();
            System.out.println("HashCode:   " + this.hashCode() + " :" + nonSynchronizedCounter.value() + ": Implemented Thread Class");
            try{
                Thread.sleep(100);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            if(i == 75){
                System.out.println("Hashcode    :" +this.hashCode() + "  : DONE (Implemented)" );
            }

        }
    }
}
