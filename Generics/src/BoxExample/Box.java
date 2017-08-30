package BoxExample;

/**
 * Created by Martin on 03-08-2017.
 */
public class Box<T>
{
    private T t;

    public void add(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }
}
