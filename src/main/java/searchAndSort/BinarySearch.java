package searchAndSort;

/**
 * Created on 5/14/14.
 */
public class BinarySearch {
    public static void main(String[] args) {

        binarySearchIterative(new int[]{1, 2, 5, 8, 10, 13, 16}, 13); // odd size
        binarySearchIterative(new int[]{1,2,8,10,13,16}, 13); // even size
        binarySearchIterative(new int[]{1,2,7,8,10,13,16}, 6); // not present, will be the third value
        binarySearchIterative(new int[]{1,2,8,10,13,16}, 99); // not present, will be the last value

        binarySearchIterative(new int[]{1,2,8,10,13,16}, 15); // not present, will be the last value

        binarySearchIterative(new int[]{1,3,8,10,13,16}, 0); // not present, will be the first value
        binarySearchIterative(new int[]{1,3,8,10,13,16}, 2); // not present, will be the first value
    }

    /**
     * Given 'sorted' int array and a value, find the location where the value is in the array.
     * if the value is not present, then return the location where it should be.
     * O(n log(n))
     */
    private static void binarySearchIterative(int[] array, int key) {
        int startIndex=0;
        int endIndex=array.length-1;
        int mid=0;
        /*
        * this condition is for the edge case where the key is supposed to be at the end of the array. During iteration
        * 'mid' value will only go upto the end index of the array, so the new key should be at mid+1 location.
        */
        if(array[endIndex]>key){
            System.out.println(key+" not found. Should be at "+(endIndex+1));
            return;
        }

        while(startIndex<=endIndex){
            mid = (startIndex+endIndex)/2;
            System.out.println("start: "+startIndex+" end: "+endIndex+" mid: "+mid);
            if(array[mid]==key){
                System.out.println("found "+key +" at "+ (mid));
                return;
            } else if(array[mid]>key){
                endIndex=mid-1;
            } else {
                startIndex=mid+1;
            }
        }

        System.out.println(key+" not found. Should be at "+(mid));
    }
}
