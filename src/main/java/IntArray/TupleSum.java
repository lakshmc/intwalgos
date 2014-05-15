package IntArray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/1/13
 * Time: 11:00 AM
 */

public class TupleSum {

    public static void main(String[] args){
        int[] arr = {3, 2, 1, 4, 5, 7, 6, 9, 7, 8};
        getTupleSumSequenceNew(arr, 30,4);
    }

    private static void getTupleSumSequenceNew(int[] srcArray, int reqSum, int tupleSize) {
        int revolvingIndexSize = tupleSize-1;
        boolean reqSumMatchFound=false;
        int[] indexArray = new int[tupleSize];
        // initialize array
        for(int i=0;i<tupleSize;i++){
            indexArray[i]=i;
        }
        while(indexArray[0]+revolvingIndexSize <srcArray.length && !reqSumMatchFound){
            reqSumMatchFound =isMatchingSum(srcArray, reqSum, indexArray);
            if(reqSumMatchFound){
                System.out.println("found");
                printArray(indexArray);
                /*reqSumMatchFound=false;
                incrementIndexArray(srcArray.length-1,indexArray);*/
            }else {
                incrementIndexArray(srcArray.length-1,indexArray);
            }
        }
        
    }

    private static void incrementIndexArray(int maxSize, int[] indexArray) {
        int markerIndex = indexArray.length-1;

        int reverseCounter=0;
        boolean maxLimitFound=true;
        int k=indexArray.length-1;

        while(maxLimitFound && k>=0){
            maxLimitFound = (indexArray[k]>=maxSize-reverseCounter);
            if(maxLimitFound){
                k--;
                reverseCounter++;    
            }
        }
        if(k==markerIndex){ // no index == max limit
            indexArray[markerIndex]++;
        } else {
            k = k<0 ? 0:k;
            int startVal = indexArray[k];
            for(int i=k;i<indexArray.length;i++){
                indexArray[i]=++startVal;
            }
        }
    }
    // the numbers are indexes. get sum of srcArry[indexes] and if they match as 30, return.
    private static boolean isMatchingSum(int[] srcArray, int reqSum, int[] indexArray ){
        int calculatedSum=0;
        for (int anIndexArray : indexArray) {
            calculatedSum += srcArray[anIndexArray];
        }
        return calculatedSum==reqSum;
    }

    private static void printArray(int[] indexArray){
        for(int a:indexArray){
            System.out.print(a + " ");
        }
    }
}
