package IntArray;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Given an int array with values 1 to N positive values, with one or more number missing, find the missing numbers.
 * Input will provide the value for N.
 *
 * Sol 1: If it is one number missing, then
 *  - Sum of 1 to n is (n * (n+1))/2. Missing number is (n * (n+1))/2 minu Sum of all the numbers in array
 *
 * Sol 2: Using BitSet
 *  - Works for any number of missing numbers
 *  - iterate over the input numbers, and set the corresponding bit for each number.
 *  - Positions of any bit(s) that were not set gives the missing numbers
 */
public class FindMissingNumber1ToN {
    public static void main(String[] args) {
        findWithBitSet(new int[]{1,2,3,4,6,7,8,9,10},10);
        findWithBitSet(new int[]{1,4,8,7,10,9},10);
        findWithBitSet(new int[]{1,2,3,4,5,6,8,7,10,9},10);
    }

    private static void findWithBitSet(int[] arr, int total){
        BitSet bitSet = new BitSet(total);
        int missingCount = total - arr.length;

        for(int val: arr){
            bitSet.set(val-1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(arr), total);

        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex); // gives index of 0 bit from given index
            System.out.println(++lastMissingIndex);
        }


    }

}
