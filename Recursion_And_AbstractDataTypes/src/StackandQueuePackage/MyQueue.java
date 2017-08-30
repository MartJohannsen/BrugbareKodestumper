package StackandQueuePackage;

import StackandQueuePackage.Abstraction;

import java.util.ArrayList;

/**
 * Created by Martin on 26-07-2017.
 */
public class MyQueue implements Abstraction
{
    ArrayList<Integer> list = new ArrayList<Integer>();


    // DET ORIGINALE TERM ER POLL (i queues)
    @Override
    public int pull()
    {
        int num = list.get(0);
        int listSize = list.size() -1;

        for(int i = 0; i < listSize; i++){
            list.set(i, list.get(i+1));
        }

        //list.set(listSize, null);

        list.remove(listSize);
        return num;
    }


    //DET ORIGINALE TERM ER OFFER
    @Override
    public void insert(int num)
    {
        list.add(num);
        System.out.println(num +":  Has been added");
    }

    @Override
    public int peek(){
        return list.get(0);
    }

    public void printQueue(){
        System.out.println(list.toString());
    }
}
