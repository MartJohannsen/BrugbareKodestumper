package ThreadPackage;

/**
 * Created by Martin on 31-07-2017.
 */
public class ExtendedThreadableClass extends Thread
{
    NonSynchronizedCounter nonSynchronizedCounter;

    public ExtendedThreadableClass(NonSynchronizedCounter nonSynchronizedCounter){
        this.nonSynchronizedCounter = nonSynchronizedCounter;
    }

    @Override
    public void run()
    {
        int i = 1;

        while (i<=75){
            i++;
            nonSynchronizedCounter.increment();
            System.out.println("HashCode:   " + this.hashCode() + " :" + nonSynchronizedCounter.value() + ": Extended Thread Class");
            try{
                Thread.sleep(100);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            if(i == 75){
                System.out.println("Hashcode    :" +this.hashCode() + "  : DONE" );
            }

        }
    }
}
