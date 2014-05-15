package stringarray;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.StopWatch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/6/13
 * Time: 3:14 PM
 */

public class Uniqueness {
    public static void  main (String[] args){
        String str="abcdeffdg";
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(Uniqueness.hasUniqueChars(RandomStringUtils.randomAlphabetic(50)));
        watch.stop();
        System.out.println("time:"+watch.getTime());
        watch.reset();
        watch.start();
        System.out.println(Uniqueness.hasUniqueChars("abcdefghijklmnopqrstuvwxyz1234567890"));
        watch.stop();
        System.out.println("time:"+watch.getTime());
    }
    public static boolean hasUniqueChars(String input){
        char[] chrArray = input.toCharArray();
        Set<Character> s = new HashSet<Character>();
        for (char aChrArray : chrArray) {
            if (!s.add(aChrArray)) {
                return false;
            }
        }

        return true;
    }
}

