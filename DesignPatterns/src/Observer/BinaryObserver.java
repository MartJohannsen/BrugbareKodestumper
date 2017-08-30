package Observer;

/**
 * Created by Martin on 15-07-2017.
 */
public class BinaryObserver extends Observation {
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState() ) );
    }
}
