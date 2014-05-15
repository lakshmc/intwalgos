package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/26/13
 * Time: 10:35 PM
 */
public class MethodLevelThreadSafety2 {

        Map<String,String> myMap;

        public void addItemsToMap(int startIndex){
            myMap = new HashMap<String,String>();
            for(int i=startIndex;i<startIndex+10;i++){
                myMap.put(""+i,""+i);
            }
        }

        public static void main(String[] args){
            final MethodLevelThreadSafety2 c = new MethodLevelThreadSafety2();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    c.addItemsToMap(110);
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // sleep for 5 seconds and then add items. this will overwrite the previous values
                    c.addItemsToMap(330);
                    System.out.println("T1"+c.myMap);
//                    System.out.println(c.myMap);
                }
            });



            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    c.addItemsToMap(220);
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // sleep for 5 seconds and then add items. this will overwrite the previous values
                    c.addItemsToMap(440);
                    System.out.println("T2"+c.myMap);
                    //System.out.println(c.myMap);
                }

            });
            t1.start();
            t2.start();

            // print from main. addItemsToMap is never called so map remains null
            System.out.println("Main");
            System.out.println(c.myMap);
        }
}
