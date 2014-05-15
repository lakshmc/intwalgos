package stringarray;

import timeStuff.TimeWatcher;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/11/13
 * Time: 11:18 AM
 */
public class Compress {
    
    public static void main(String[] args){
        System.out.println(Compress.compress("aaafffnnm6645naaafffnnm6645naaafffnnm6645naaafffnnm6645naaafffnnm6645naaafffnnm6645naaafffnnm6645n"));
        System.out.println(Compress.compress("aaaaaaa"));
    }
    public static String compress(String str) {
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
        result.append(str.charAt(i)).append(count + 1);
        TimeWatcher.printElapsedTime();
        return result.length()<str.length()?result.toString():str;
    }

}
