package timeStuff;

import org.apache.commons.lang.time.StopWatch;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/16/13
 * Time: 12:02 PM
 */
public class TimeWatcher {
    private static StopWatch watch = new StopWatch();
    private TimeWatcher(){}
    
    public static void startTime(){
        watch.reset();
        watch.start();
    }

    /*public static void stopTime(){
        watch.stop();
    }*/

    private static long getElapsedTime(){
        watch.stop();
        return watch.getTime();
    }
    
    public static void printElapsedTime(){
        watch.stop();
        System.out.println("Time taken:"+watch.getTime()+" ms");
    }
    
    

}
