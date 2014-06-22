package IntArray;

import util.Printer;

import java.util.Arrays;
import java.util.Collections;

/**
 * SEE FindKthLargestNumber/FindKthSmallestNumber.java for a cleaner answer.
 *
 */
public class FindNthElementQuickSelection {
    // uses zero index for search
    public static void main(String[] args){
        int[] i = {5,1, 4, 3, 2}; // 1,2,3,4,5
        //System.out.println(selectKth(i,2));

        i=new int[]{23,35,23,55,78,2,98,101,14,9};
        int[] arr = new int[]{23,35,23,55,78,2,98,101,14,9};

        Arrays.sort(arr);
        Printer.printArray(arr);

        int k=3;
        //find the 3 smallest number
        System.out.println("smallest "+k+": ");
        selectKth(i,3);

        // find the 3rd largest number
        System.out.println("largest "+k+": ");
        selectKth(i,3);


        /*for(int j=0;j<i.length;j++){
            selectKth(i,j);
        }*/



    }

    /**
     *
     * @param arr
     * @param k
     * @return
     */
    public static int selectKth(int[] arr, int k) {
        if (arr == null || arr.length <= k)
            throw new Error();

        int from = 0, to = arr.length - 1;

        // if from == to we reached the kth element
        while (from < to) {
            int r = from, w = to;
            int mid = arr[(r + w) / 2];

            // stop if the reader and writer meets
            while (r < w) {

                if (arr[r] >= mid) { // put the large values at the end
                    int tmp = arr[w];
                    arr[w] = arr[r];
                    arr[r] = tmp;
                    w--;
                } else { // the value is smaller than the pivot, skip
                    r++;
                }
            }

            // if we stepped up (r++) we need to step one down
            if (arr[r] > mid)
                r--;

            // the r pointer is on the end of the first k elements
            if (k <= r) {
                to = r;
            } else {
                from = r + 1;
            }
        }
        System.out.println("k is "+k+" and kth element is "+arr[k]);
        return arr[k];
    }

    private static int partition(int[] arr, int first, int last){
        while(first<last){
            int mid = (first+last)/2;
            if(arr[first]>arr[mid]){
                swap(arr, first,last);
                last--;
            } else{
                first++;
            }
        }
        return first;

    }

    private static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
