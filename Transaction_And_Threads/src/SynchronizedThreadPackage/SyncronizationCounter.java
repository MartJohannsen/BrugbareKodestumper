package SynchronizedThreadPackage;

/**
 * Created by Martin on 31-07-2017.
 */
public class SyncronizationCounter
{
    private int counter;

    public SyncronizationCounter() {this.counter = 0;}

    // BEMÆRK SYNCHRONIZED: Dette medfører at threads'nes udgave af "counter" er ens.

    public synchronized void increment(){ counter++;}

    public synchronized int value() { return counter;}

}
