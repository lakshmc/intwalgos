package util;
/**
 * Created by lchan39 on 6/21/14.
 */
public class Printer {

    public static void printArray(int[] arr){
        System.out.print("\n[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i<arr.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]\n");
    }
}
