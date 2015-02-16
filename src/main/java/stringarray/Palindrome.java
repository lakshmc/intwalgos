package stringarray;

/**
 * Created by lchan39 on 2/16/15.
 */
public class Palindrome {
    public static void main(String[] args) {
        String[] strArray = new String[]{"mom", "dad", "a", "ab", "aba", "aab"};

        for(String str: strArray){
            System.out.println(str+" :"+isPalindrome(str));
        }
    }

    private static boolean isPalindrome(String str) {
        int head =0;
        int tail = str.length()-1;
        char[] strArray = str.toCharArray();
        while(head<tail){
            if(strArray[head]!=strArray[tail]){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
