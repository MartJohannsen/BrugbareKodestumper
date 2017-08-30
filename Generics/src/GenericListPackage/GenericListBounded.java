package GenericListPackage;

import Objects.Animal;

import java.util.ArrayList;

/**
 * Created by Martin on 01-08-2017.
 */
public class GenericListBounded<E extends Animal>
{
    ArrayList<E> arrayList = new ArrayList<E>();

    public GenericListBounded(){

    }

    public ArrayList<E> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }
}
