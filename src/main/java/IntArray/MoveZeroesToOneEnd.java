package IntArray;

import util.Printer;

/**
 * Given an array of int, move all the zeroes to the end of array.
 * Have to indices for head and tail of the array.
 * if item in headIndex is zero
 *      - if tailIndex is zero, move the index to the left until a non-zero value is found
 *      - swap the headIndex value with the tailIndex value
 *      - move the tailIndex once to left.
 * if Item in headIndes is non-zero, move to the next item.
 * continue the loop until startIndex and headIndex meet.
 *
 * O(n) since every item in the array needs to be evaluated once.
 */
public class MoveZeroesToOneEnd {

    public static void main(String[] args) {
        int[] arr= new int[]{12,0,3,0,4,3,2,0,4,0,0,0,4,3,4,3,2,0,9};

        int[] arr1= new int[]{0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1};

        moveZeroes(arr);
        moveZeroes(arr1);
    }

    private static void moveZeroes(int[] arr) {
        System.out.print("\nBefore:");
        Printer.printArray(arr);
        int startIndex = 0, endIndex = arr.length-1;

        while(startIndex<endIndex){
            if(arr[startIndex]==0){
                while(startIndex<endIndex && arr[endIndex]==0){
                    endIndex--;
                }
                if(startIndex<endIndex){
                    arr[startIndex] = arr[endIndex];
                    arr[endIndex]=0;
                    endIndex--;
                }
            }
            startIndex++;

        }
        System.out.print("\nAfter:");
        Printer.printArray(arr);
    }
}
