package stringarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created on 5/10/14.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        String str = "United States of America";
        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicatesBySorting(str));
        System.out.println(removeDuplicatesWithSet(str));

        str="aaaaaaa";
        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicatesBySorting(str));
        System.out.println(removeDuplicatesWithSet(str));

        str="abcdefgh";
        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicatesBySorting(str));
        System.out.println(removeDuplicatesWithSet(str));


    }

    // prints like [a, b, c, d, e, f, g, h]
    private static String removeDuplicatesWithSet(String str){
        char[] srcArry = str.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>(); // keeps order of insert

        for(char c: srcArry){
            charSet.add(c);
        }

        return charSet.toString();
    }

    private static String removeDuplicates(String str){
        char[] srcArry = str.toCharArray();
        char[] destArry = new char[srcArry.length];
        boolean[] boolArr = new boolean[256];
        int index=0;
        for(char c: srcArry){
            if(!boolArr[c]){
                boolArr[c]=true;
                destArry[index++]=c;
            }
        }
        return new String(destArry);
    }

    // rearranges the original text
    private static String removeDuplicatesBySorting(String str) {
        final char array[] = str.toCharArray();
        Arrays.sort(array);
        int length = array.length;
        int j = 0;
        final char noDuplicatesArray[] = new char[array.length];
        for (int i =0; i<length-1; i++) {
            if(array[i] == array[i+1]) {
                continue;
            }
            noDuplicatesArray[j++] = array[i];
        }
        noDuplicatesArray[j++] = array[length-1];
        return new String(noDuplicatesArray);
    }

}
