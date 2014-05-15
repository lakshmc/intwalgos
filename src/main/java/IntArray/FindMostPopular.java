package IntArray;

import java.util.HashMap;
import java.util.Map;

public class FindMostPopular {

    private static int findMostPopular(int a[]){
        int countArr[] = new int[a.length];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int value:a){
            Integer count = map.get(value);
            count = count==null? 1:count+1;
            map.put(value,count);
            countArr[count]=value;
        }
        for(int c=countArr.length-1;c>0;c--){
            if(countArr[c]>0){
                System.out.println(countArr[c]+" found "+c+" times");
                return countArr[c];
            }
        }
        return -1;
    }

    // has bug!
    private static int find(int a[]) {
        int buff[] = new int[a.length];
        int popular = 0;
        int popularCount=0;
        for(int value : a) {
            buff[value]++;
            if(popularCount <=buff[value]) {
                popular = value;
                //System.out.println(popular+" "+buff[value]);
            }
        }
        return popular;
    }

    public static void main(String[] args) {
        int[] a1 = {1,1,1,2,0,0,0,7,7,7,7,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        //System.out.println("popular -->"+find(a1));

        int[] a2 = {1,2,2,3,3,10,10,3,0,10,7,7,3,7,3,7};
        //System.out.println("popular -->"+find(a2));
        System.out.println("popular -->"+findMostPopular(a1));

    }
}
