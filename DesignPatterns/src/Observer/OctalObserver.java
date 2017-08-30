package Observer;

/**
 * Created by Martin on 15-07-2017.
 */
public class OctalObserver extends Observation{
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String : " + Integer.toOctalString(subject.getState() ) );
    }
}
