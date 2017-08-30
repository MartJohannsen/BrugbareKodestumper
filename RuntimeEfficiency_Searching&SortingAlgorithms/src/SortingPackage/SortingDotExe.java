package SortingPackage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Martin on 08-08-2017.
 */
public class SortingDotExe
{
    public static void main(String[] args)
    {
        int[] listOfInts = {30,20,10,0};
        int[] anotherListOfInts = {20,30,10,0};

        System.out.println(Arrays.toString(listOfInts) + ": Before Mergesort");

        MergeSortClass.getInstance().mergeSort(listOfInts);

        System.out.println(Arrays.toString(listOfInts) + ": After Mergesort");

        System.out.println(Arrays.toString(anotherListOfInts) + ": Before Quicksort");

        QuickSortClass.getInstance().quickSort(anotherListOfInts);



        System.out.println(Arrays.toString(anotherListOfInts) + ": After Quicksort");

    }
}
