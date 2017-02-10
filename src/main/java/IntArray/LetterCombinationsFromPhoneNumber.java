package IntArray;

import java.util.*;

/**
 * Created by lchan39
 */
public class LetterCombinationsFromPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("123"));
        System.out.println(letterCombinations("6109"));
        System.out.println(letterCombinations("0"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("4018712"));
    }

    public static List<String> letterCombinations(String digits){
        List<String> result = new LinkedList<String>();
        if(digits==null || digits.length()==0){
            return result;
        }
        Map<Character,String> map = new HashMap<Character, String>(){{{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }}};

        StringBuilder sb = new StringBuilder();
        dfs(digits,0,sb,map,result);
        return result;
    }

    public static void dfs(String digits, int step, StringBuilder builder, Map<Character, String> map, List<String> result){

        if(step==digits.length()){ // last digit reached
            result.add(builder.toString());
            return;
        }

        Character currChar = digits.charAt(step);
        String digitChars = map.get(currChar);
        if(digitChars==null){
            dfs(digits,step+1,builder,map,result); // handle 0,1
        } else {
            for (int i = 0; i < digitChars.length(); i++) {     // for each char of the digit, add it to temp builder, calc combinations for rest of digits
                builder.append(digitChars.charAt(i)); // take first char of the three chars of the digit
                dfs(digits, step + 1, builder, map, result); // repeat for next digit
                builder.deleteCharAt(builder.length() - 1); // remove the char
            }
        }
    }
}
