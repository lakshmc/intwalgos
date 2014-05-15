package IntArray;

import timeStuff.TimeWatcher;

import java.util.BitSet;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/16/13
 * Time: 11:13 AM
 */

public class CommonElements {
    public static void main(String[] args){

//int size1=100000000;

        int size1=100000;

        int a[] = new int[size1];//{1,2,3,4,5,6,7,8,9};
        
        int b[] = new int[size1];//{7,6,5,8,9,12,40,34,45,12,34423,34,3};
        int c[] = {12,40,34,45,12,34423,34};

        Random r = new Random();
        for(int i=0;i<size1;i++){
            a[i]=i;
            //b[i]=i*r.nextInt(100);
            b[i]=a[i];
        }
        System.out.println(CommonElements.findCommonInUnSortedArrayUsingBitSet(a,b));
        //System.out.println(CommonElements.findCommonInUnSortedArrayUsingBitSet(a,c));

    }

    private static BitSet findCommonInUnSortedArrayUsingBitSet(int arr1[], int arr2[]) {
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

        System.out.println("Common items:"+bitSet2.size());
        TimeWatcher.printElapsedTime();
        return bitSet2;
    }
}
