package StackandQueuePackage;

import StackandQueuePackage.Abstraction;

import java.util.ArrayList;

/**
 * Created by Martin on 26-07-2017.
 */
public class MyStack implements Abstraction
{
    private ArrayList<Integer> list = new ArrayList<>();


    // DET ORIGINALE TERM ER POP
    @Override
    public int pull()
    {
        int size = list.size() - 1;

        int num = list.get(size);

        list.set(size, 0);

        return num;
    }


    //DET ORIGINALE TERM ER PUSH
    @Override
    public void insert(int num)
    {
        list.add(num);
        System.out.println(num + ": Has been added to this stack");
    }

    @Override
    public int peek()
    {
        return list.get(list.size()-1);
    }
}
