package ThreadPackage;

/**
 * Created by Martin on 31-07-2017.
 *
 * Trådene skal tilsammen give 225. Duede det?
 *
 **/
public class ThreadDotExe
{
    public static void main(String[] args)
    {
        NonSynchronizedCounter noSyncCounter = new NonSynchronizedCounter();

        ExtendedThreadableClass exThreadOne = new ExtendedThreadableClass(noSyncCounter);
        ExtendedThreadableClass exThreadTwo = new ExtendedThreadableClass(noSyncCounter);
        ImplementedRunnableClass exThreadThreeImplemented = new ImplementedRunnableClass(noSyncCounter);

        exThreadOne.run();

        Thread minorThread = new Thread(exThreadThreeImplemented);
        // Implemented threads kobles op på en Thread, derfor den køres anderledes.

        minorThread.start();

        // Hvorfor starter extendedklasserne
        // ikke med det samme?

        exThreadTwo.start(); // Får sin egen tråd og kører derefter.



    }

}
