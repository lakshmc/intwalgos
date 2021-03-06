package IntArray;

import util.Printer;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Added on 7/19/14.
 * The name of the class may not be the right desc for the problem.
 * Problem:
 * You have an array like ar[]= {1,3,2,4,5,4,2} of length n. You need to create
 * another array ar_low[] such that each item in ar_low = number of elements lower
 * than or equal to ar in ar[i+1:n-1].
 * (number of items less than the item in index i from index i+1 to n-1)
 * So the output of above should be {0,2,1,2,2,1,0}
 * Time complexity : O(nlogn)
 * use of extra space allowed.

 * Solution: The idea is to find the elements smaller or equal to the item in an array. Sorting would help,
 * but we cannot lose the index of the item since we only have to check the number of smaller or equal items after
 * that index. Inserting into the BST makes sure the items are sorted and we can quickly get the smaller items. So we
 * can insert the items into a BST in reverse order.

 * BST:Each node(key,value) is (item,frequency of the item encountered so far in the iteration). tree.headMap(key)
 * returns all the nodes that are less than key. By adding up the frequency for each node returned for a given item
 * in array, we get the number of elements lower than or equal to ar in ar[i+1:n-1].

 * We could start at the first item and load each to the BST and then start again at first item and them find the
 * ar_low values but then we are looping the array twice. Instead, we can load the array in reverse. This will allow
 * us to find ar_low when parsing the arr the first time.

 * BST will give us O(nlogn) complexity (load each item + search).
 */
public class FindSubsequentSmallItemsCount {
    public static void main(String[] args) {
        int ar[]= {1,3,2,4,5,4,2};
        printNewArray(ar);

        int arr[]= {3,2,1};
        printNewArray(arr);

        int arrr[]= {3,1,2};
        printNewArray(arrr);

    }

    private static void printNewArray(int[] ar) {
        TreeMap<Integer,Integer> tree = new TreeMap<Integer, Integer>();
        int[] result = new int[ar.length];
        for(int i=ar.length-1;i>=0;i--){
            int freq = 1;
            if(tree.containsKey(ar[i])){
                freq = tree.get(ar[i]);
                freq++;
            }
            tree.put(ar[i], freq);

            Set<Map.Entry<Integer,Integer>> entrySet = tree.headMap(ar[i],true).entrySet();
            // headMap(Key, true) returns the key node inclusive. We need it because the same number could be present
            // multiple times in the array. Eg: 4 occurs twice at index 3 and 5 produce different results (2 and 1).

            int count=0;
            for(Map.Entry<Integer,Integer> entry :entrySet){
                count=count+entry.getValue();
            }
            result[i]=count-1; // minus one since we don't want the current item itself included in the count
        }
        Printer.printArray(result);
    }


}

