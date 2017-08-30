package SearchingPackage;

import java.util.Arrays;

/**
 * Created by Martin on 09-08-2017.
 */
public class BinarySearchClass
{
    public int binarySearch(int desiredNumber, int[] list){

        int arraySize = list.length;

        int lowerBound = 0;
        int upperBound = arraySize;

        while(true){
            if(upperBound < lowerBound){
                // Failsafe, hvis nogle værdierne pludselig skulle krydse hinanden
                return 0;
            }

            // lowerbound plusses med:  (Upperbound minus lowerbound divideret med 2).
            int midpoint = lowerBound + (upperBound - lowerBound) /2 ;

            if(list[midpoint] < desiredNumber){
                // Lowerbound rykkes op, så midpointet vil fastsætte sig imellem det gamle midpoint og upperbound.
                lowerBound = midpoint + 1;
            }

            if (list[midpoint] > desiredNumber){
                // Upperbound rykkes ned, således at en halvering af midpointet vil ske
                upperBound = midpoint - 1;
            }

            if (list[midpoint] == desiredNumber){
                // Hvis værdien på midpointet passer, så returneres værdien!!
                return list[midpoint];
            }
        }
    }
}
