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
        permutation("abcd");
        Set<StringBuilder> perms1 = perms(new StringBuilder("abcd"));
        System.out.println("perms1"+"("+perms1.size()+")"+" = " + perms1);

    }

    public static void permutation(String str) {
        permutation("", str);
    }

    // just String and recursive, prints combinations
    // O(n*n!)-> for every n we need to calculate all of its permutations, so n times n!
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
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
