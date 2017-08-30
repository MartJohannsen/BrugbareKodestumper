package Observer;

/**
 * Created by Martin on 15-07-2017.
 */
public class ObserverDemoDotExe {
    public static void main(String[] args)
    {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state: 15");
        subject.setState(15);
        System.out.println("State el Seconde: 10");
        subject.setState(10);
    }
}
