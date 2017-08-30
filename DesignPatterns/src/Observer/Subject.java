package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by Martin on 15-07-2017.
 */
public class Subject {
    private List<Observation> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observation observer){
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for(Observation observer : observers){
            observer.update();
        }
    }
}
