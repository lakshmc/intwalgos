package ctci.laakman.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/6/13
 * Time: 10:38 AM
 */

public class AnagramMatch {

    public static void main (String[] args){
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isAnagramXOR(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
            anagram = isAnagramSort(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
            anagram = isAnagramIterative(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);

            System.out.println();

            //System.out.println(anagram(word1, word2));
        }
    }

    private static boolean isAnagramIterative(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        int[] letters = new int[128];
        for(char c: str1.toCharArray()){
            letters[c]++;
        }
        for(char c: str2.toCharArray()){
            if(letters[c]==0){
                return false;
            } else {
                letters[c]--;
            }
        }
        return true;

    }

    // using Sort
    private static boolean isAnagramSort(String str1, String str2){
        return sort(str1).equals(sort(str2));
    }

    private static String sort(String str){
        char[] cArray = str.toCharArray();
        Arrays.sort(cArray);
        return new String(cArray);
    }

    // using XOR: fails for some test cases eg: "xaabby","xccddy" :(
    private static boolean isAnagramXOR(String s1, String s2) {
        return getXOR(s1)==getXOR(s2); 
    }

    private static int getXOR(String str) {
        int value=0;
        for(char c: str.toCharArray()){
            value=value^c;
        }
        return value;
    }
}
