package stringarray;

/**
 * Given a string 'text' of length n and another string 'pattern' of length m, print all occurrences of pattern
 * in text. If not found, return -1
 * brute force: two loops
 * best case O(n): when the pattern is not in the text
 * worst case O(m*(n-m)+1): When all characters of the text and pattern are same or when only the last character is
 * different
 *
 * Correct solution: KMP Algorithm (pattern match at O(m+n) worst case)
 * This algo removes wasteful comparisons by preprocessing the pattern to find the prefix/suffix info and uses that
 * to search the text efficiently.
 * 1. preprocess and create an array about the pattern's prefixes
 * 2. search the text based on the info gathered in step 1
 * (It is safe to say that I don't understand this algo yet)
 *
 */
public class PatternMatchKMP {

    public static void main(String[] args) {
        String text = "CAABAACAADAABAAABAA";
        String pattern = "AABA";

        bruteForceSearch(text, pattern);

        kmpSearch(text, pattern);

        text = "abcdefghijklmnopqrstuvwxyz";
        pattern = "defghij";

        bruteForceSearch(text, pattern);

        kmpSearch(text, pattern);

        text = "AAAAAAAAAAAA";
        pattern = "AAA";

        bruteForceSearch(text, pattern); // returns 9

        kmpSearch(text, pattern); // returns 4

    }


    public static int[] preprocess(String pattern) {
        int[] next = new int[pattern.length()];
        int i=0, j=-1; // note j=-1
        next[0]=-1;
        while (i<pattern.length()-1) { // note the limit is two less than pattern length ('<' and length-1)
            while (j>=0 && pattern.charAt(i)!=pattern.charAt(j)){
                j = next[j];
            }
            i++; j++;
            next[i] = j;
        }
        return next;
    }

    public static void kmpSearch(String text, String pattern) {
        System.out.println("KMP:");
        int[] next = preprocess(pattern);
        int i=0, j=0, count=0; // note, unlike preprocessing j =0
        while (i<text.length()) { // note, limit is length -1
            while (j>=0 && text.charAt(i)!=pattern.charAt(j)){
                j = next[j];
            }
            i++; j++;
            if (j==pattern.length()){
                System.out.println("pattern found at:"+(i-pattern.length()));
                j=0;// to stop after first match, remove this line
                count++;
            }
        }
        if(count==0)
            System.out.println("pattern found at:-1");
    }

    private static void bruteForceSearch(String text, String pattern) {
        System.out.println("Brute Force:");
        char[] txtArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();
        int n = txtArr.length;
        int m = patternArr.length;
        int count=0;
        // note i<=n-m since after n-m text length is less than pattern, so no need to search
        for(int i=0;i<=n-m;i++){
            int j=0;
            for(j=0;j<m;j++){
                if(txtArr[i+j]!=patternArr[j]){
                    break;
                }
            }
            if(j==m){
                System.out.println("pattern found at index "+i);
                count++;
            }
        }
        if(count==0){
            System.out.println("pattern not found: -1");

        }
    }

}
