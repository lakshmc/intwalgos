package IntArray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/6/13
 * Time: 9:48 AM
 */

public class CompareTwoArraysXOR {

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5}; // true
        System.out.println(isArraysEqual(a,b));

        b = new int[] {1,2,3,4,6}; // false
        System.out.println(isArraysEqual(a,b));

    }

    private static boolean isArraysEqual(int[] a, int[] b) {
        if(a.length!=b.length){
            return false;
        }
        int value = 0;
        for(int i=0;i<a.length;i++){
            value=value^a[i];
            value=value^b[i];
        }
        return value==0;
    }

}
