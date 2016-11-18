package IntArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an int array ar, and an int value n, find all combinations of elements in ar that add up to n
 * Eg:
 * ar=[1,3,5,2,7,21]
 * n = 21
 * result:[5,5,5,5,1],[1,2,3,5,5,5],[21], etc
 *
 */
public class FindCombinationsThatAddToX {

    static void sum_up_recursive(List<Integer> numbers, int target, List<Integer> partial) {
        int currentSum = 0;
        for (int x: partial){
            currentSum += x;
        }
        if (currentSum == target)
            System.out.println("sum("+ Arrays.toString(partial.toArray())+")="+target);
        if (currentSum >= target)
            return;
        for(int i=0;i<numbers.size();i++) {
            List<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) {
                remaining.add(numbers.get(j));
            }
            List<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
        }
    }
    static void sum_up(List<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }

    public static void main(String args[]) {
        Integer[] numbers = {3,9,8,4,5,7,10};
        int target = 15;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);

        numbers = new Integer[]{1,3,5,2,7,21};
        target = 21;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
    }

}
