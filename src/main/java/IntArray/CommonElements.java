package IntArray;

import timeStuff.TimeWatcher;

import java.util.*;

/**
 * Given two unsorted arrays(arr1, arr2) of int, find the items that are common for the arrays
 * 1. Sort and search: O(nlog(n))
 * 2. Hashing: O(n)
 * 3. Brute force: O(m*n) where m is arr1.length and n is arr2.length
 * 4. Using Bitset class: O(?)
 */

public class CommonElements {
    public static void main(String[] args){

        int size1=12;

        int a[] = {1,1,3,2,3,4};//{1,2,3,4,5,6,7,8,9}; //new int[size1];
        
        int b[] = {1,1,1,2,1,1,3,3,6,7,7,2,3};// {7,6,5,8,9,12,40,34,5,8,45,12,34423,34,3};//new int[size1];

       /* Random r = new Random();
        for(int i=0;i<size1;i++){
            a[i]=i;
            b[i]=i*r.nextInt(100);
            //b[i]=a[i];
        }*/
        System.out.println(CommonElements.findCommonInUnSortedArrayUsingBitSet(a,b));

        System.out.println(findCommonWithSet(a,b));

        System.out.println(findCommonWithSorting(a,b));

        System.out.println(findCommonItemsWithNonRepetitiveUniqueness(a,b));

    }

    /**
     * Sort one of the arrays first. O( n*log(n))
     * Iterate the other array and binary search the sorted array for that item. (searcing is O(logn) and iteration is O(n) )
     * total complexity is O(nlogn)
     */
    private static List<Integer> findCommonWithSorting(int[] arr1, int[] arr2){
        Arrays.sort(arr1); // n*log(n)
        Set<Integer> commonSet = new HashSet<Integer>();
        for(int num: arr2){
            /**
             * Binary search returns (negative)location of the item if it was in the array. So if the item is present in 5th place
             * returns 5. if the item is not present, but it should be in 5th location in the sorted array, then will return -5.
             * So any negative value means the item is not present in the array.
             */
            if(Arrays.binarySearch(arr1,num)>=0){ // item found.
                commonSet.add(num); // adding to set so result contains only unique items
            }
        }
        return new ArrayList<Integer>(commonSet);
    }

    /**
     * Load one array to set=> O(1) time complexity and O(k) space complexity where k is number of unique items
     * iterate the second array and see if set already contains the number => O(n) for iteration
     * total time complexity is O(n) with space complexity of O(k) where k is unique items in array 1.
     */
    private static List<Integer> findCommonWithSet(int[] arr1, int[] arr2){
        Set<Integer> numSet = new HashSet<Integer>();
        Set<Integer> commonSet = new HashSet<Integer>();
        for(int num: arr1){
            numSet.add(num);
        }

        for(int num: arr2){
            if(numSet.contains(num)){
                commonSet.add(num); // adding to set so result contains only unique items
                // another way is to remove from the main set when there is a match. This will eliminate duplicates. Then
                // the common items can be added to a list directly
                // numSet.remove(num);
            }
        }
        return new ArrayList<Integer>(commonSet);
    }

    /**
     * Common items with change in unique condition
     * int[] a = [1,1,3,2,3,4]
     * int[] b = [1,1,1,2,1,1,3,3,6,7,7,2,3]
     * output: [1,2,1,3,2,3] // consecutive duplicates are ignored.
     *
     */
    private static List<Integer> findCommonItemsWithNonRepetitiveUniqueness(int[] arr1, int[] arr2){
        Set<Integer> numSet = new HashSet<Integer>();
        List<Integer> commonList = new ArrayList<Integer>();
        for(int num: arr1){
            numSet.add(num);
        }
        int i=0;
        while(i<arr2.length){
            int currentNum = arr2[i];
            if(numSet.contains(currentNum)){
                commonList.add(currentNum);
            }
            i++;
            while(i<arr2.length && currentNum==arr2[i]){
                i++;
            }
        }
        return commonList;
    }


    /**
     * BitSet class is a vector (array) of bits. set() method takes an int and sets that bit. set(5) will set 5th item of
     * the vector to 1. Using this we set all the items in the arrays to two BitSet instances and then do an AND operation.
     * Resulting BitSet will have 1s only on the index of common items. We count up the set bits and that is the number of
     * common items and the indices give the actual number
     */
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
