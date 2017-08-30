package SortingPackage;

import java.util.Arrays;

/**
 * Created by Martin on 08-08-2017.
 */
public class MergeSortClass
{
    private static MergeSortClass instance = null;

    private MergeSortClass()
    {
    }

    public static MergeSortClass getInstance()
    {
        if(instance == null){
            return instance = new MergeSortClass();
        }
        else{
            return instance;
        }
    }

    public static void mergeSort(int[] list){
        if(list.length > 1){
            int[] left = Arrays.copyOfRange(list, 0, list.length/2);
            int[] right = Arrays.copyOfRange(list, list.length/2, list.length);


            // Vi kalder samme metode, men med de splittede arrays.
            mergeSort(left);
            mergeSort(right);


            // Her samles arrays'ne
            merge(list, left, right);

        }

    }

    private static void merge(int[] result, int[] left, int[] right){
        int i1 = 0; // Used for progressing left array
        int i2 = 0; // Used for progressing right array

        for(int i = 0; i < result.length; i++) { // loops the same amount of times, that there are places in the total array
            if(i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])){
                // If right array is exceeded or the left spot is lesser than the right spot,
                // a number from the left array is taken.
                result[i] = left[i1];// This number is now taken, so we won't use it again
                i1++;  // Therefore we increment
            }
            else{
                // Else we will take a number from the right array
                result[i] = right[i2];
                i2++;
            }
        }
    }
}
