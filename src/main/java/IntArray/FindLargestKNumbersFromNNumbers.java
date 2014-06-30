package IntArray;

import org.apache.commons.lang.math.RandomUtils;

import java.util.*;

/**
 * Q: Given an array of 100 random integers, find the largest 3 numbers.
 * Generic problem: Given an unsorted array of N elements, find the largest K elements, assume K < N.
 *
 * 1. Brute force:
 *      - iterate the array K times, finding the largest number that is smaller than the largest found in previous iteration
 *      - O(N^K)
 *
 * 2. Sorting:
 *      - Sort the array and iterate from the end to get the k elements
 *      - O(N log(N)) : considering k being small compared to N, sorting the entire array may be unnecessary
 *
 * 3. Heap based sort with priority queue
 *     - iterate the array and put it into a priority queue with size restricted to K.
 *     - during iteration, for every i, if array[i] is greater than queue head (smallest number) remove it and insert
 *       array[i] into the queue. Auto sorting will guarantee that head is the smallest.
 *     - O(N log(K))
 *          - compared to N, K is usually small, insertion into priority queue is hash based so it is O(log K)
 *          - N log(K) is much smaller than N log(N) Eg: 1 billion * log(100) vs 1 billion * log (1 billion)
 *
 * Ref: http://stackoverflow.com/a/19227860
 */
public class FindLargestKNumbersFromNNumbers {

    public static void main(String[] args) {
        int n = 5000000;
        int k=3;
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i]= RandomUtils.nextInt(100000000);
        }
        //printArray(array);

        printKLargestNumbersInArrayNLogK(array, k);
        printKLargestNumbersInArrayNLogN(array, k);
    }


    /**
     * Method 2: Sort and iterate Nlog(N)
     */
    private static void printKLargestNumbersInArrayNLogN(int[] data, int k){
        Long started = System.currentTimeMillis();
        System.out.println("Using array sort");
        Arrays.sort(data);
        System.out.print("[");
        for(int j=data.length-k;j<data.length;j++)
            System.out.print(data[j]+" ");

        System.out.print("]\n");

        System.out.println("Time:"+(System.currentTimeMillis()-started));
    }

    /**
     * Method 3: Priority queue Nlog(K)
     */
    private static void printKLargestNumbersInArrayNLogK(int[] data, int k){
        Long started = System.currentTimeMillis();
        System.out.println("Using priority queue");
        Queue<Integer> pQueue = new PriorityQueue<Integer>(k);
        for(int num: data){
            if(pQueue.size()==k){
                if(num > pQueue.peek()){
                    pQueue.remove();
                    pQueue.add(num);
                }
            } else {
                pQueue.add(num);
            }
        }
        System.out.print("[");
        // looping this way doesn't return queue elements in order! Use poll()
        /*for(int n: pQueue){
            System.out.print(n + " ");
        }*/
        while(!pQueue.isEmpty()){
            System.out.print(pQueue.poll() + " ");
        }
        System.out.print("]\n");
        System.out.println("Time:"+(System.currentTimeMillis()-started));
    }


    private static void printArray(int[] array) {
        System.out.print("[");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
            if(i!=array.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]\n");
    }
}
