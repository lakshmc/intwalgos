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
 */
public class RebuildSentence {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>(Arrays.asList("mobile","samsung","sam","sung","man","mango",
                                                            "icecream","and","go","i","like","ice","cream"));

        System.out.println(wordBreak("ilikemangoicecream", dict));
        System.out.println(wordBreak("ilikesamsungis", dict));

        wordBreak("ilikemangoicecream", dict,"");

        List<String> resultList = new ArrayList<String>();
        wordBreak("ilikemangoicecream", dict,resultList,"");
        System.out.println(resultList);

    }

    /**
     * prints true/false based on whether a sentence can be built from the input
     * @return
     */
    private static boolean wordBreak(String str, Set<String> dict){
        int len = str.length();
        if (len==0)
            return true;

        for(int i=1;i<=len;i++){
            String prefix = str.substring(0,i);
            String suffix = str.substring(i,len);
            if(dict.contains(prefix) && wordBreak(suffix, dict)){
                System.out.println(prefix);
                return true;
            }
        }
        return false;
    }

    /**
     * prints all the valid combination of sentences that can be built from the input.
     */
    private static void wordBreak(String str, Set<String> dict, String result){
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
                wordBreak(suffix, dict, result+prefix+" ");
            }
        }
    }

    /**
     * Returns true if a valid sentence can be formed from the given input. The combinations are added into
     * resultList
     */
    private static boolean wordBreak(String str, Set<String> dict, List<String> resultList, String addWord){
        String prefix="";
        boolean isTrue= false;
        if(str.length()==0) {
            resultList.add(addWord);
            return true;
        }

        for(int i=1; i<=str.length();i++) {
            prefix=str.substring(0, i);
            if(dict.contains(prefix)) {
                // using substring(beginIndex)
                wordBreak(str.substring(i), dict, resultList, addWord + " " + prefix);
                isTrue = true;
            }
        }
        return isTrue;

    }
}
