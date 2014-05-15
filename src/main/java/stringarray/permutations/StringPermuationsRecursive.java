package stringarray.permutations;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/16/13
 * Time: 5:04 PM
 */

public class StringPermuationsRecursive {
    public static void main(String[] args){
        //permutation("abc");
        Set<StringBuilder> perms1 = perms(new StringBuilder("abcd"));
        System.out.println("perms1"+"("+perms1.size()+")"+" = " + perms1);

    }

    public static void permutation(String str) {
        permutation("", str);
    }

    // just String and recursive, prints combinatio
    private static void permutation(String prefix, String str) {
        System.out.println(prefix+" "+((str.length()==0)?"-":str));

        if (str.length() == 0) System.out.println("");
        else {
            for (int i = 0; i < str.length(); i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
        }
    }

    private static Set<StringBuilder> perms(StringBuilder strBuilder){
        if(strBuilder==null) return null;
        else if(strBuilder.length()==1){
            Set<StringBuilder> sb = new HashSet<StringBuilder>();
            sb.add(strBuilder);
            return sb;
        } else {
            char c = strBuilder.charAt(0);
            strBuilder = strBuilder.deleteCharAt(0);
            Set<StringBuilder> remainingPerms = perms(strBuilder);
            Set<StringBuilder> finalPerms = new HashSet<StringBuilder>();
            for(StringBuilder sb: remainingPerms){
                for(int k=0;k<=sb.length();k++){
                    StringBuilder finalComb = new StringBuilder(sb);
                    finalComb.insert(k, c);
                    finalPerms.add(finalComb);
                }
            }
            return finalPerms;
        }
    }
}
