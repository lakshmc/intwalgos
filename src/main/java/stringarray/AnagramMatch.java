package stringarray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/6/13
 * Time: 10:38 AM
 */

public class AnagramMatch {

    public static void main (String[] args){
        // two strings
       /* System.out.println(isAnagram("abcd","cbda"));// true
        System.out.println(isAnagram("abcd","abce"));// false

        // find if Z is anagram of X and Y.. Like X='abc' and Y='klm' and if Z='almbkc' then Z is anagram of X and Y
        System.out.println(isAnagram("abc"+"klm","almbkc"));// true
        System.out.println(isAnagram("abc"+"klm","almbkf"));// false*/

        System.out.println(isAnagramIterative("mom"));
        System.out.println(isAnagramIterative("abcdefedcba"));
        System.out.println(isAnagramIterative("abcdexfedcba"));
        System.out.println(isAnagramIterative(""));
    }

    private static boolean isAnagram(String s1, String s2) {
        return getXOR(s1)==getXOR(s2); 
    }

    private static int getXOR(String str) {
        int value=0;
        for(char c: str.toCharArray()){
            value=value^c;
        }
        return value;
    }

    private static boolean isAnagramIterative(String s1){
        int head=0;
        int tail =s1.length()-1;

        while(head<tail){
            if(s1.charAt(head++)!=s1.charAt(tail--)){
                return false;
            }
        }
        return true;
    }
}
