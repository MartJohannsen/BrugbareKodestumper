package SortingPackage;

/**
 * Created by Martin on 08-08-2017.
 */
public class QuickSortClass
{
    // IGNORER START
    private static QuickSortClass instance = null;

    private QuickSortClass()
    {
    }

    public static QuickSortClass getInstance(){
        if(instance == null){
            return instance = new QuickSortClass();
        }
        else{
            return instance;
        }
    }

    // IGNORER SLUT

    public static void quickSort(int[] list){
        quickSort(list, 0,list.length -1);
    }

    public static void quickSort(int[] list, int firstValue, int lastValue){
        if(lastValue > firstValue){
            int pivotIndex = partition(list, firstValue, lastValue);
            quickSort(list, firstValue, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, lastValue);
        }
    }

    public static int partition(int[] list, int first, int last){
        int pivot = list[first]; // Brug første element som pivot
        int low = first + 1; // Index til fremadgående søgning
        int high = last; // Index til tilbagegående søgning

        while(high > low) {
            // Søg fra venstre mod højre
            while (low <= high && list[low] <= pivot){
                low++;
            }

            // Søg fra højre mod venstre
            while(low <= high && list[high] > pivot){
                high--;
            }

            // Bytte to elementer i listen
            if(high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        // Formindsker high værdien, når high er lavere end low (Se while løkke længere oppe)
        while(high > first && list[high] >= pivot){
            high--;
        }

        // Her ændres pivotten, til rekursionskald (Se længere oppe)
        if(pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high; // Bliver til pivot index
        }
        else{
            return first;
        }

    }
}
