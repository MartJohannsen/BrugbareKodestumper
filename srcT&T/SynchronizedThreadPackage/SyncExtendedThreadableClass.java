package SynchronizedThreadPackage;

/**
 * Created by Martin on 31-07-2017.
 */
public class SyncExtendedThreadableClass extends Thread
{
    private SyncronizationCounter syncronizationCounter;

    public SyncExtendedThreadableClass(SyncronizationCounter syncronizationCounter){
        this.syncronizationCounter = syncronizationCounter;
    }

    @Override
    public void run()
    {
        int i = 1;

        while (i<=75){
            i++;
            syncronizationCounter.increment();
            System.out.println("HashCode:   " + this.hashCode() + " :" + syncronizationCounter.value() + ": Extended Thread Class");
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
