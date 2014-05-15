package IntArray;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/6/13
 * Time: 10:50 AM
 */

public class TupleSumBalaji {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5, 7, 6, 9, 7, 8};
        int reqSum = 30;
        int numElems = 4;
        bruteForce(arr, numElems, reqSum);
    }

    private static void bruteForce(int[] arr, int numElems, int reqSum) {
        Stack<Integer> indices = new Stack<Integer>();
        printSum(arr, numElems, reqSum, 0, indices);
    }

    private static void printSum(int[] arr, int numElems, int reqSum, int start, Stack<Integer> indices) {
        if (numElems == 0) {
            int sum = 0;
            for (int index : indices) {
                sum += arr[index];
            }
            if (sum == reqSum) {
                System.out.println(indices);
            }
            return;
        }
        for (int i = start; i < arr.length - (numElems - 1); i++) {
            indices.push(i);
            printSum(arr, numElems - 1, reqSum, i + 1, indices);
            indices.pop();
        }
    }

}

