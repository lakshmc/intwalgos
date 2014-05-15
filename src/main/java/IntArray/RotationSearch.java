package IntArray;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/4/13
 * Time: 2:16 PM
 */
public class RotationSearch {

    public static void main(String[] args){
        int[] arry={6,7,8,9,1,2,3,4,5};
        int result = searchInRotatedArray(arry, 3);
        System.out.println(result+" =>"+arry[result]);

        result = searchInRotatedArray(arry, 8);
        System.out.println(result+" =>"+arry[result]);

        arry= new int[]{23,34,87,99,101,102,3,5,6,8,9};
        result = searchInRotatedArray(arry, 101);
        System.out.println(result+" =>"+arry[result]);
    }


    private static int searchInRotatedArray(int[] arry, int srchNum) {
        int pivotIndex = 0;
        for(int i=1;i<arry.length;i++){
            if(arry[i-1]>arry[i]){
                pivotIndex=i;
                break;
            }
        }

        // another way to search and find pivot is to use left<middle<right strategy. Look at method findSplit() below
        //pivotIndex=findSplit(arry, 0, arry.length - 1);

        int[] seg1 = Arrays.copyOfRange(arry,0,pivotIndex);
        int[] seg2 = Arrays.copyOfRange(arry,pivotIndex,arry.length);
        int index = Arrays.binarySearch(seg1,srchNum);
        if(index==-1){
            index = Arrays.binarySearch(seg2, srchNum);
            if(index!=-1){
                index+=pivotIndex;
            }
        }
        return index;
    }

    private static int findSplit(int[] arr, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > arr[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
        return findSplit(arr, left, right);
    }


}
