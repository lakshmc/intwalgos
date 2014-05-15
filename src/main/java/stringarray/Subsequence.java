package stringarray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/11/13
 * Time: 10:10 AM
 */
public class Subsequence {
    
    public static void main(String args[]){
        System.out.println(Subsequence.isSubSequence("bangalore","blr"));
        System.out.println(Subsequence.isSubSequence("bangalore","brl"));

        System.out.println(Subsequence.isSubSequenceUsingIndexOf("bangalore", "blr"));
        System.out.println(Subsequence.isSubSequenceUsingIndexOf("bangalore", "brl"));

        System.out.println(Subsequence.hasSubstringSequence("Lakshmikanthchandramohan", "nkhmto"));
        System.out.println(Subsequence.hasSubstringSequence("Lakshmikanthchandramohan", "khmto"));

        
    }
    // Solution 1
    public static boolean isSubSequence(String mainStr, String subStr) {
        int i = 0;
        int j = 0;
        while (i < mainStr.length() && j < subStr.length()) {
            if (mainStr.charAt(i) == subStr.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == subStr.length();
    }

    // Solution 2 using String indexOf method
    public static boolean isSubSequenceUsingIndexOf(String mainStr, String subStr) {
        int i = 0;
        int index = 0;
        while(i<subStr.length()) {
            char c = subStr.charAt(i);
            if((index = mainStr.indexOf(c, index)) == -1) {
                return false;
            }
            i++;
        }

        return true;
    }
    
    public static boolean hasSubstringSequence(String mainStr, String subStr){
        int i=0;
        int index=0;
        while(i<subStr.length()){
            char subStrChar = subStr.charAt(i);
            index=mainStr.indexOf(subStrChar,index);
            if(index!=-1){
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
