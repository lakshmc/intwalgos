package stringarray.permutations;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations_Swap {
    
    public static void main(String[] args){
        new StringPermutations_Swap().permutation("abcd");
    }

    private static int index = 0;

    public void permutation(String str){
        Set<String> resultSet = new HashSet<String>();
        permutation(str.toCharArray(), 0, str.length()-1, resultSet);
        for(String string : resultSet){
            System.out.println(++index+"  ::  "+string);
        }
    }

    private void permutation(char[] str, int startIndex, int endIndex, Set<String> set){
        if(startIndex == endIndex){
            set.add(new String(str)); //set to remove duplicates and hashset gives consatnt time complexity
        }
        else{
            for(int i=endIndex; i>=startIndex; i--){
                swapChars(str, startIndex, i);
                permutation(str, startIndex + 1, endIndex, set);
                swapChars(str, startIndex, i);
            }
        }
    }

    private void swapChars(char[] str, int index1, int index2){
        char t = str[index1];
        str[index1] = str[index2];
        str[index2] = t;
    }
    
}
