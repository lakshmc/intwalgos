package stringarray;

import util.Printer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given an array of string, remove duplicates
 * 1. Iterate and load each item into a set and then load it into an new array with set's size
 * - uses extra space for set and order of items get changed since data is loaded from set.
 * - O(n)
 * 1a. Same logic as above, but use LinkedHashSet instead of HashSet to maintain insertion order.
 *
 * 2. removeDuplicatesSetWithOrder(): Use set to identify unique strings, and mark the duplicates
 * with "". then iterate the array and move the empty ones to the end using double index
 * - O(n)
 *
 * 3. Sort it and load the first occurrence of each string into a new array. Doesnt keep order, uses
 * additional memory
 * - O(nlog(n))
 */
public class RemoveDuplicateString {

    public static void main(String[] args) {

        removeDuplicatesSetNoOrder(new String[]{"ab", "ab", "abs", "abcd", "adas", "abcd", "ab", "abs", "adasf"});
        removeDuplicatesLinkedHashSetWithOrder(new String[]{"ab", "ab", "abs", "abcd", "adas", "abcd", "ab", "abs", "adasf"});
        removeDuplicatesSetWithOrder(new String[]{"ab","ab","abs","abcd","adas","abcd","ab","abs","adasf"});
        removeDuplicatesSortWithOrder(new String[]{"ab", "ab", "abs", "abcd", "adas", "abcd", "ab", "abs", "adasf"});
    }

    private static void removeDuplicatesSetNoOrder(String[] strings) {
        /*System.out.println("Before");
        Printer.printStrArray(strings);*/
        Set<String> set = new HashSet<String>();
        for (int i=0;i<strings.length;i++) {
            if(!set.add(strings[i]))
                strings[i] = "";
        }
        String[] uStr = new String[set.size()];
        int i=0;
        for(String str: set){
            uStr[i++]=str;
        }
        System.out.println("After: Using HashSet(changes insertion order)");
        Printer.printStrArray(uStr);
    }

    private static void removeDuplicatesLinkedHashSetWithOrder(String[] strings) {
        Set<String> set = new LinkedHashSet<String>();
        for (int i=0;i<strings.length;i++) {
            if(!set.add(strings[i]))
                strings[i] = "";
        }
        String[] uStr = new String[set.size()];
        int i=0;
        for(String str: set){
            uStr[i++]=str;
        }
        System.out.println("After: Using LnkedHashSet to keep insertion order");
        Printer.printStrArray(uStr);
    }

    private static void removeDuplicatesSetWithOrder(String[] strings) {
        Set<String> set = new HashSet<String>();
        for (int i=0;i<strings.length;i++) {
            if(!set.add(strings[i]))
                strings[i] = "";
        }
        int uniqueIndex=0;
        if(set.size()<strings.length){
            for(int i=0;i<strings.length;i++){
                if(!strings[i].equals("") ){
                    if(uniqueIndex!=i){
                        strings[uniqueIndex++]=strings[i];
                        strings[i]="";
                    } else {
                        uniqueIndex++;
                    }
                }
            }
        }
        System.out.println("After: Using HashSet, Keeps order by marking the duplicates in array");
        Printer.printStrArray(strings);
    }

    private static void removeDuplicatesSortWithOrder(String[] strings) {
        Arrays.sort(strings);
        String[] newDuplicates = new String[strings.length];
        int k=0;
        for (int i=0;i<strings.length-1;i++) {
            if(strings[i].equals(strings[i+1])){
                continue;
            }
            newDuplicates[k++]=strings[i];
        }
        System.out.println("After: Using Sort, no extra memory, but loses insertion order");
        Printer.printStrArray(newDuplicates);
    }
}
