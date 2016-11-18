package stringarray.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: bgandhi
 * Date: 10/13/13
 * Time: 4:47 PM
 */
public class StringPermutations {

    public static void main(String[] args) {
        String str = "abcd";
        List<String> perms = getPerms(str); // uses arrays
        //System.out.println("perms"+"("+perms.size()+")"+" = " + perms);
        // using StringBuilder and HashSet to restrict duplicates
        Set<StringBuilder> perms1 = getAllPermutations(new StringBuilder(str));
        System.out.println("perms1"+"("+perms1.size()+")"+" = " + perms1);
        Set<StringBuilder> perms2 = myStringPermutations(new StringBuilder(str));
        System.out.println("perms2"+"("+perms2.size()+")"+" = " + perms2);

        permShort("","abcd"); // prints all the permutations

    }

    private static Set<StringBuilder> getAllPermutations(StringBuilder builder) {
        if (builder.length() == 1) {
            Set<StringBuilder> permutations = new HashSet<StringBuilder>();
            permutations.add(builder);
            return permutations;
        }
        char firstChar = builder.charAt(0);
        StringBuilder remaining = builder.deleteCharAt(0);
        Set<StringBuilder> permutations = new HashSet<StringBuilder>();
        Set<StringBuilder> permutationsOfRemaining = getAllPermutations(remaining);
        for (StringBuilder permutation : permutationsOfRemaining) {
            for (int i = 0; i <= permutation.length(); i++) {
                StringBuilder newPermutation = new StringBuilder(permutation);
                newPermutation.insert(i, firstChar);
                permutations.add(newPermutation);
            }
        }
        return permutations;
    }

    
    private static List<String> getPerms(String str) {
        List<String> perms = new ArrayList<String>();
        if (str.length() == 2) {
            perms.add(str);
            perms.add(reverse(str));
        } else {
            List<String> perms1 = getPerms(str.substring(0, str.length() - 1));
            String lastChar = str.substring(str.length() - 1);
            for (String perm1 : perms1) {
                for (int i = 0; i <= perm1.length(); i++) {
                    //insert lastChar into every index of perm1
                    String newperm = insert(perm1, lastChar, i);
                    //add it to perms list
                    perms.add(newperm);
                }
            }
        }
        return perms;
    }

    private static String insert(String str, String ch, int offset) {
        char[] chArr = new char[str.length() + ch.length()];
        int i = 0;
        int j = 0;
        int k = 0;
        boolean inserted = false;
        while (k < chArr.length) {
            if (i != offset || inserted) {
                chArr[k++] = str.charAt(i++);
            } else {
                while (j < ch.length()) {
                    chArr[k++] = ch.charAt(j++);
                }
                inserted = true;
            }
        }
        return new String(chArr);
    }

    private static String reverse(String str) {
        char[] chArr = str.toCharArray();
        for (int i = 0; i < chArr.length / 2; i++) {
            char temp = chArr[i];
            chArr[i] = chArr[chArr.length - 1 - i];
            chArr[chArr.length - 1 - i] = temp;
        }
        return new String(chArr);
    }

    private static Set<StringBuilder> myStringPermutations(StringBuilder strBuilder){
        // base condition
        if(strBuilder.length()==1){
            Set<StringBuilder> sbSet = new HashSet<StringBuilder>();
            sbSet.add(strBuilder);
            return sbSet;
        } else {
            char firstChar = strBuilder.charAt(0);
            StringBuilder remaining = strBuilder.deleteCharAt(0);
            Set<StringBuilder> remainingPerms = myStringPermutations(remaining);
            Set<StringBuilder> perms = new HashSet<StringBuilder>();
            for(StringBuilder sb: remainingPerms){
                for(int i=0;i<=sb.length();i++){
                    StringBuilder newCombination = new StringBuilder(sb);
                    newCombination.insert(i,firstChar);
                    perms.add(newCombination);
                }
            }
            return perms;
        }

    }

    private static void permShort(String prefix, String s) {
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++)
                permShort(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }

    }
}
