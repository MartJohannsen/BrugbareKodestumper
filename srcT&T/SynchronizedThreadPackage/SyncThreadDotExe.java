package SynchronizedThreadPackage;

/**
 * Created by Martin on 31-07-2017.
 */
public class SyncThreadDotExe
{
    public static void main(String[] args)
    {
        SyncronizationCounter syncCount = new SyncronizationCounter();

        SyncExtendedThreadableClass threadOne = new SyncExtendedThreadableClass(syncCount);
        SyncExtendedThreadableClass threadTwo = new SyncExtendedThreadableClass(syncCount);
        SyncExtendedThreadableClass threadThree = new SyncExtendedThreadableClass(syncCount);

        // Hver tråd inkrementerer 75 gange...

        threadOne.start();
        threadTwo.start();
        threadThree.start();


    }
}
