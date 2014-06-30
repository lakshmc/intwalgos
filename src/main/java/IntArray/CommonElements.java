package IntArray;

import timeStuff.TimeWatcher;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * Given two unsorted arrays of int, find the items that are common for the arrays
 *
 * BitSet class is a vector (array) of bits. set() method takes an int and sets that bit. set(5) will set 5th item of
 * the vector to 1. Using this we set all the items in the arrays to two BitSet instances and then do an AND operation.
 * Resulting BitSet will have 1s only on the index of common items. We count up the set bits and that is the number of
 * common items and the indices give the actual number
 */

public class CommonElements {
    public static void main(String[] args){

        int size1=12;

        int a[] = new int[size1];//{1,2,3,4,5,6,7,8,9};
        
        int b[] = new int[size1];//{7,6,5,8,9,12,40,34,45,12,34423,34,3};

        Random r = new Random();
        for(int i=0;i<size1;i++){
            a[i]=i;
            //b[i]=i*r.nextInt(100);
            b[i]=a[i];
        }
        System.out.println(CommonElements.findCommonInUnSortedArrayUsingBitSet(a,b));

    }

    private static List<Integer> findCommonInUnSortedArrayUsingBitSet(int arr1[], int arr2[]) {
        TimeWatcher.startTime();
        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();
        for(int aa : arr1){
            bitSet1.set(aa);
        }
        for(int bb : arr2){
            bitSet2.set(bb);
        }
        bitSet2.and(bitSet1);

        System.out.println("a items:"+arr1.length);
        System.out.println("b items:"+arr2.length);

        System.out.println("BitSet2 length:"+bitSet2.length());

        List<Integer> commonItems = new ArrayList<Integer>();
        for ( int i = bitSet2.nextSetBit( 0 ); i >= 0; i = bitSet2.nextSetBit( i + 1 ) ) {
            commonItems.add(i);
        }
        System.out.println("No. common items: "+commonItems.size());

        TimeWatcher.printElapsedTime();
        return commonItems;
    }
}
