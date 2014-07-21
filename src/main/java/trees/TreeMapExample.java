package trees;

import java.util.TreeMap;

/**
 * Just a testing class for TreeMap usage
 * This is essentially a Map that allows sorting (natural/comparator) as well as parsing in a structured fashion. In
 * essence it is a BST
 */
public class TreeMapExample {
    public static void main(String[] args) {
        int[] arr={1,3,2,4,5,4,2};

        printTreeMap(arr);
    }

    private static void printTreeMap(int[] arr) {
        TreeMap<Integer,Integer> tree = new TreeMap<Integer, Integer>();
        for(int i=0;i<=arr.length-1;i++){
            int count=1;
            if(tree.containsKey(arr[i])){
                count = tree.get(arr[i]);
                count++;
            }
            tree.put(arr[i],count);
        }
        System.out.println(tree); // prints everything in sorted order
        System.out.println(tree.headMap(3)); // all items smaller than three
        System.out.println(tree.headMap(3,true)); // all items smaller than three including three
        System.out.println(tree.tailMap(3)); // items grater than three
    }
}
