package SearchingPackage;

/**
 * Created by Martin on 09-08-2017.
 */
public class SearchDotExe
{
    public static void main(String[] args)
    {
        LinearSearchClass linearSearchClass = new LinearSearchClass();
        BinarySearchClass binarySearchClass = new BinarySearchClass();

        // Et sorteret array
        int[] ints = {20,21,22,23,24,25,26,27,28,29};
        int[] intsTwo = {30,31,32,33,34,35,36,37,38,39};

        int found = linearSearchClass.linearSearch(39, intsTwo);

        System.out.println("Fundet af linearSearch: " + found);

        int number = binarySearchClass.binarySearch(23, ints);


        System.out.println("Fundet af binarySearch: " + number);
    }
}
