package GenericListPackage;

import java.util.ArrayList;

/**
 * Created by Martin on 01-08-2017.
 */
public class GenericList<E>
{
    ArrayList<E> arrayList = new ArrayList<E>();

    public GenericList(){

    }

    public ArrayList<E> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }


}
