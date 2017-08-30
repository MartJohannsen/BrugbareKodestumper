package SearchingPackage;

/**
 * Created by Martin on 15-08-2017.
 */
public class LinearSearchClass
{
    public int linearSearch(int desiredNumber, int[] list){
        int numberToReturn = 0;
        if(list.length > 0){
            for(int i = 0; i < list.length; i++){
                if(list[i] == desiredNumber){
                    numberToReturn = list[i];
                    return numberToReturn;
                }
            }
        }
        else{
            return numberToReturn;
        }
        return numberToReturn;
    }
}
