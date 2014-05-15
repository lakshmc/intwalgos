package searchAndSort;

/**
 * Created on 5/14/14.
 */
public class BinarySearch {
    public static void main(String[] args) {

        binarySearchIterative(new int[]{1, 2, 5, 8, 10, 13, 16}, 13); // odd size
        binarySearchIterative(new int[]{1,2,8,10,13,16}, 13); // even size
        binarySearchIterative(new int[]{1,2,8,10,13,16}, 6); // not present, will be the third value
        binarySearchIterative(new int[]{1,2,8,10,13,16}, 99); // not present, will be the last value
    }

    /**
     * Given 'sorted' int array and a value, find the location where the value is in the rray. 
     * if the value is not present, then return the location where it should be.
     */

    private static void binarySearchIterative(int[] a, int i) {
        int start=0;
        int end = a.length-1;
        int mid=-1;
        while(start<=end){
            mid = (start+end)/2;
            if (a[mid]==i){
                System.out.println(a[mid]+" found at "+mid);
                return;
            } else if (a[mid]>i){
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        System.out.println(i+" not found. proposed index is "+( mid+1)); // << add one to mid since mid will finish
    }
}
