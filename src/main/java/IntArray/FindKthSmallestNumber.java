package IntArray;

import util.Printer;

import java.util.Arrays;

/**
 * Given an array of unsorted int, find the kth smallest element
 *
 * The solution uses partitioning (used in quick sort) so that for every iteration, a selected pivot gets placed in its
 * right position in the array. For instance, if the pivot chosen is 5, then at the end of that partitioning, the item
 * in arr[5] will be placed at the location in the array where it should have been, if the array was sorted fully. All
 * numbers smaller than the pivot will be to the left of the pivot and bigger numbers will be to the right (unsorted)
 * The process is efficient since only the bare minimum number of items gets sorted, meaning, only until the right item
 * gets placed in the kth location.
 * Solution:
 * 1. Make a partition for the full array and get the pivot index. The returned value is the index where the right number
 * is placed.
 * 2. If the index==k then we have our answer. if not,
 *  if k<pivot, then do partitioning from 0 to pivot and repeat from step 1
 *  if k>pivot, then do partitioning from pivot+1 to array length and repeat from step 1
 * 3. keep recursing until start and end indices meet.
 *
 * NOTE: To find the largest kth element, the same code would work. Just change the '<=' sign in the partition logic
 * to '>'. This will produce a reversed partition-> larger numbers, pivot, smaller numbers. (See FindKthLargestNumber.java)
 */

public class FindKthSmallestNumber {
    public static void main(String[] args) {
        System.out.println("quickselect");
        int k = 4;

        int[] A = new int[]{21, 3, 34, 5, 13, 8, 2, 55, 1, 19};

        //smallestFirstPartition(A, 0, A.length - 1);
        int value = FindKthSmallestNumber.quickselect(A, k); // find smallest Kth element
        System.out.println(k+"th smallest item: "+value);

        // print the sorted array to see where the item actually is
        int[] B = A;
        Arrays.sort(B);
        Printer.printArray(B);

    }

    public static int quickselect(int[] G, int k) {
        if(k<0 || k > G.length-1){
            return Integer.MIN_VALUE;
        }
        return quickselect(G, 0, G.length - 1, k - 1); // note that we are asking k-1 item
    }

    private static int quickselect(int[] G, int first, int last, int k) {
        int pivot = smallestFirstPartition(G, first, last);
        if (pivot == k) {
            return G[k];
        }
        if (pivot > k) {
            return quickselect(G, first, pivot - 1, k);
        }
        return quickselect(G, pivot + 1, last, k);

    }

    /**
     * G[i] <= G[last] results in a typical partition-> numbers smaller than pivot, pivot, numbers larger than pivot
     *  use this to get kth smallest item. For Largest use '>' (FindKthLargestNumber.java)
     */
    private static int smallestFirstPartition(int[] G, int first, int last) {
        // instead of picking mid always, you can also choose a random index
        //int pivot = first + new Random().nextInt(last - first + 1);
        int pivot = (first+last)/2;
        swap(G, last, pivot);
        for (int i = first; i < last; i++) {
            if (G[i] <= G[last]) {
                swap(G, i, first);
                first++;
            }
        }
        swap(G, first, last);
        return first;
    }

    private static void swap(int[] G, int x, int y) {
        int tmp = G[x];
        G[x] = G[y];
        G[y] = tmp;
    }
}
