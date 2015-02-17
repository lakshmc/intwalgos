package ctci.laakman.arrays;

import timeStuff.TimeWatcher;

/**
 * Given a string, replace the duplicate values of a char with a count of character occurrence in sequence. EG:
 * aabcccaaas will result in a2b1c3a3s1. If the resulting string is not smaller than the input string,
 * return the original string.
 * 1. Using StringBuilder- compressWithStringBuilder(): iterate through the string's characters and keep count of
 * sequence, whenever sequence breaks, add to the stringBuilder
 * - O(n)
 * 2. Without StringBuilder - compress(): First calculate the length of the compressed string and check if the length
 * is smaller than original. Then iterate the original string and keep count of sequence. Whenever sequence breaks,
 * write to the array, the character and the count value, which is a little tricky since count is integer and we need
 * to write every digit of it into a char array.
 *
 */
public class Compress {
    
    public static void main(String[] args){
        String[] inputs = new String[]{"aaaaaaa","abbccccccde","aaaaaee","aaafffnnm6645"};
        for(String str: inputs){
            System.out.println(Compress.compressWithStringBuilder(str));
            System.out.println(Compress.compress(str));
        }
    }

    private static int countCompression(String str) {
        if (str == null || str.isEmpty()) return 0;
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public static String compress(String str){
        int compressedLength = countCompression(str);
        if(compressedLength>=str.length()){
            return str;
        }
        char[] result = new char[compressedLength];
        int i=0;
        int count=0;
        int resultIndex=0;
        while(i < str.length()-1){
            count++;
            if(str.charAt(i)!=str.charAt(i+1)){
                result[resultIndex++]=str.charAt(i);
                String countString = String.valueOf(count);
                for(int j=0;j<countString.length();j++){
                    result[resultIndex++]=countString.charAt(j);
                }
                count=0;
            }
            i++;
        }
        // process final character
        result[resultIndex++]=str.charAt(i);
        String countString = String.valueOf(count+1); // increment count for last char
        for(int j=0;j<countString.length();j++){
            result[resultIndex++]=countString.charAt(j);
        }
        return new String(result);
    }

    public static String compressWithStringBuilder(String str) {
        TimeWatcher.startTime();
        StringBuilder result = new StringBuilder();
        int i = 0;
        int count = 0;
        while(i < str.length() - 1) {
            count++;
            if (str.charAt(i) != str.charAt(i + 1)) {
                result.append(str.charAt(i)).append(count);
                count = 0;
            }
            i++;
        }
        result.append(str.charAt(i)).append(count + 1); // process final character, increment count for last char
        TimeWatcher.printElapsedTime();
        return result.length()<str.length()?result.toString():str;
    }

}
