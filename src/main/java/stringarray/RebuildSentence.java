package stringarray;

import java.util.*;

/**
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a
 * space-separated sequence of dictionary words.
 * Eg: dict= { i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango}
 * Input:  ilike
 * The string can be segmented as "i like".
 *
 *  Input:  ilikesamsung
 *  The string can be segmented as "i like samsung" or "i like sam sung"
 *
 *  Input:  ilikesamsunga
 *  String cannot be segmented (since there is no 'a' in dictionary)
 *  http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 *  Assumption: Input is cannot partially right, i.e., in the third example above,
 *  the input is invalid since the final a does not form a proper word, even though rest of the input resolves to
 *  proper words.
 *
 *  Solution: Iterate recursively through the given string. The solution can be seen as this:
 *  - first word of the sentence + <space> + rest of the words in the sentence
 *  - so take a prefix and check if its a word
 *       - if so check if the rest of the sentence also has proper words
 *          - if true, then the prefix word and suffix words are valid and print the result
 *          - if false, then the current prefix is not proper (See assumption). Attach another letter to the prefix
 *          and repeat to see if this prefix combination results in a valid suffix.
 *
 */
public class RebuildSentence {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>(Arrays.asList("mobile","samsung","sam","sung","man","mango",
                                                            "icecream","and","go","i","like","ice","cream"));

        System.out.println(wordBreakBoolean("ilikemangoicecream", dict));
        System.out.println(wordBreakBoolean("ilikesamsungis", dict));

        wordBreakAddToList("ilikemangoicecream", dict,"");
        wordBreakAllValidCombinations("ice", dict, "");
        System.out.println(wordBreakBoolean("ilikesamsungis", dict));

        wordBreakAllValidCombinations("ilikemangoicecream", dict, "");
        wordBreakAllValidCombinations("ice", dict, "");

    }

    /**
     * prints true/false based on whether a sentence can be built from the input
     * @return
     */
    private static boolean wordBreakBoolean(String str, Set<String> dict){
        int len = str.length();
        if (len==0)
            return true;

        for(int i=1;i<=len;i++){
            String prefix = str.substring(0,i);
            String suffix = str.substring(i,len);
            if(dict.contains(prefix) && wordBreakBoolean(suffix, dict)){
                System.out.println(prefix); // prints as soon as a word is detected
                return true;
            }
        }
        return false;
    }

    /**
     * prints all the valid combination of sentences that can be built from the input.
     */
    private static void wordBreakAllValidCombinations(String str, Set<String> dict, String result){
        int len = str.length();
        for(int i=1;i<=len;i++){
            String prefix = str.substring(0,i);
            String suffix = str.substring(i,len);
            if(dict.contains(prefix)){

                if(i==len){
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                wordBreakAllValidCombinations(suffix, dict, result + prefix + " ");
            }
        }
    }

    /**
     * Same as above, slightly different logic
     */
    private static void wordBreakAddToList(String str, Set<String> dict, String sentence){
        String prefix="", suffix="";
        if(str.length()==0) { // we have parsed all the characters for this recursion
            // we do recursion only if prefix is valid, and if resulting suffix turns out to be invalid then
            // corresponding recursive call will never reach this point. i.e; incoming string will never be empty
            // unless the entire input had already been resolved to a valid prefix.
            System.out.println(sentence); //
        }

        for(int i=1; i<=str.length();i++) { // start from 1 (not 0) since we are using substring
            prefix=str.substring(0, i);
            suffix=str.substring(i);
            if(dict.contains(prefix)) {
                sentence += prefix+ ""; // add the new word to previously resolved sentence and space
                wordBreakAddToList(suffix, dict, sentence);
            }
        }

    }
}
