package GenericMethodExample;

/**
 * Created by Martin on 03-08-2017.
 */
public class GenericsEasyExample
{

    public static void main(String[] args)
    {
        String[] stringArray = {"Hello", "World"};
        Integer[] intArray = {5,7,9,256};
        Double[] doubleArray = {6.8, 9.4, 5.6};


        printArray(stringArray);
        GenericsEasyExample.<String>printArray(stringArray);
        printArray(intArray);
        printArray(doubleArray);
    }

    // ved metoder placeres den generiske type efter static keyword
    public static <E> void printArray(E[] array){
        for(E e : array){
            System.out.print(e.toString() + ", ");
        }
        System.out.println();
    }
}
