package IteratorDemo;

/**
 * Created by Martin on 14-07-2017.
 */
public class NameRepository implements Container{
    public String names[] = {"Robert", "John", "Julie", "Larry"};


    // returnerer en instans af den innerclass der findes nedenunder
    @Override
    public Iteration getIterator()
    {
        return new NameIteration();
    }

    private class NameIteration implements Iteration
    {
        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){ // this.hasNext() refererer til innerclassen, metoden ovenover!
                return names[index++];
            }
            return null;
        }
    }
}
