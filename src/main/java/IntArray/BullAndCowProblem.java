package IntArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of unsorted integers.
 * If a number exists at the same location in both arrays, then it is a Bull
 * if a number exists in both arrays but in different locations then it is a cow
 */
public class BullAndCowProblem {
    public static void main(String[] args) {
        int []a = {6,4,9,10,2,11};
        int []b = {1,9,3,11,2,6};

        printCowsAndBulls(a,b);
    }

    /**
     * Use hashmap to store the array1.value as key and its index as value
     * iterate through second array, for each value in second array, do a get from the map
     *  - if the map doesn't return a value, then neither bull nor cow
     *  - if the map returns value
     *      - if the returned value(index of first array) is same the index in second array it is a bull
     *      - else its a cow
     * This will be O(max(m,n)) where m =array1.length and n=array2.length
     */
    private static void printCowsAndBulls(int[] array1, int[] array2) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<array1.length;i++){
            map.put(array1[i],i);
        }

        for(int i=0;i<array2.length;i++){
            Integer num = map.get(array2[i]);
            if(num!=null){
                if(num==i){
                    System.out.println("Found bull: "+array2[i]);
                } else {
                    System.out.println("Found cow: "+array2[i]);
                }
            }
        }
    }
}
