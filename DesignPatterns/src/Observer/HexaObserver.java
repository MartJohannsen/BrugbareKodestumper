package Observer;

/**
 * Created by Martin on 15-07-2017.
 */
public class HexaObserver extends Observation {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState() ) );
    }
}
