package StackExample;

import java.util.ArrayList;

/**
 * Created by Martin on 26-07-2017.
 */
public class GenericStack<E>
{
    private ArrayList<E> list = new ArrayList<>();

    public E pop()
    {
        int spot = list.size()-1;

        E e = list.get(spot);

        list.remove(list.size() - 1);

        return e;
    }

    public void push(E e)
    {
        list.add(e);
        System.out.println(e.getClass().getName() + ": Has been added to this stack");
    }

    public E peek()
    {
        return list.get(list.size()-1);
    }
}
