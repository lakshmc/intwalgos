package IntArray;

import java.util.*;

/**
 * Created by lchan39 on 6/23/14.
 */
public class TwoSumProblem {

    public static void main(String[] args) {
        int[] a={1,3,6,2,0,8,3,1,4,2};
        int sum=6;

        printTwoSum(a,sum);

        printUniqueTwoSum(a, sum);

    }

    private static void printTwoSum(int[] array, int sum) {
        System.out.println("\n All pairs");
        Set<Integer> mySet = new HashSet<Integer>();
        for(int num:array){
            mySet.add(num);
        }

        for(int num:mySet){
            int diff = sum-num;
            if(mySet.contains(diff)){ // lookup for set is O(1): worst cae O(n)
                System.out.println("2 sum pair:"+num+","+diff);
            }
        }
    }

    private static void printUniqueTwoSum(int[] array, int sum) {
        System.out.println("\n Unique pairs");
        Set<Integer> mySet = new HashSet<Integer>();
        for(int num:array){
            mySet.add(num);
        }
        Iterator<Integer> it = mySet.iterator();
        while(it.hasNext()){
            int num = it.next();
            int diff = sum-num;
            if(mySet.contains(diff)){
                System.out.println("2 sum pair:"+num+","+diff);
                it.remove(); // to enforce uniqueness
            }
        }
    }
}
