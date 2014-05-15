package IntArray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/6/13
 * Time: 9:38 AM
 */

public class FindUnPairedNumberXOR {
    
    public static void  main(String[] args){
        int[] a = {1,2,3,4,5,6,5,4,3,2,1};
        System.out.println(findNonDupNumber(a));

        a = new int[] {1,2,3,4,5,5,4,3,2,1};
        System.out.println(findNonDupNumber(a));
    }

    /**
     * XOR of a and b will return zero if a and b are same. In this algo, we XOR each element, so all the pairs cancel each other
     * and the only remaining number will be the unpaired number. it is like adding a bunch of positive and negative equal numbers
     * and one number with no negative pair. Add all, and only the unpaired number remains.
     */

    private static int findNonDupNumber(int a[]) {
        int value =0;
        for(int i=0; i<a.length;i++) {
            int arrayVal = a[i];
            value = value ^ arrayVal;
        }
        return value;
    }


}
