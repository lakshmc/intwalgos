package stringarray;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/7/13
 * Time: 11:39 AM
 */
public class BalancedParenthesis {
    private static final Map<Character, Character> pairs = new HashMap<Character, Character>();

    static {
        /*pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');*/
        pairs.put('(',')');
        pairs.put('{','}');
        pairs.put('[',']');
    }

    public static void main(String[] args) {
        String[] strs = {"{}[]", "({})", "{[}", "{[}]", "}}", "[[","{{{}{}()([][][()])}}"};
        for (String str : strs) {
            System.out.println("str = " + str);
            System.out.println("isBalanced = " + isBalanced(str));
        }
    }
    private static boolean isBalanced(String str){
        Stack<Character> charStack = new Stack<Character>();
        char[] charArray = str.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(pairs.get(charArray[i])==null){
                if(charStack.empty() || charArray[i]!=charStack.pop()){
                    return false;
                }
            } else {
                charStack.push(pairs.get(charArray[i]));
            }
        }
        return charStack.empty();
    }

    /*private static boolean isBalanced_Balaji(String str) {
        Stack<Character> parenthesis = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (pairs.keySet().contains(ch)) {
                if (parenthesis.isEmpty()) {
                    return false;
                } else {
                    char popped = parenthesis.pop();
                    if (popped != pairs.get(ch)) {
                        return false;
                    }
                }
            } else {
                parenthesis.push(ch);
            }
        }
        return parenthesis.isEmpty();
    }*/

}

