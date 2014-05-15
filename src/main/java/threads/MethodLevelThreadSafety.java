package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/26/13
 * Time: 5:12 PM
 */

public class MethodLevelThreadSafety {
    
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MyClass c  = new MyClass();
                c.addItemsToMap(110);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // sleep for 5 seconds and then add items. this will overwrite the previous values
                c.addItemsToMap(330);
                System.out.println("T1");
                System.out.println(c.myMap);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                MyClass c  = new MyClass();
                c.addItemsToMap(220);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // sleep for 5 seconds and then add items. this will overwrite the previous values
                c.addItemsToMap(440);
                System.out.println("T2");
                System.out.println(c.myMap);
            }
        });
        t1.start();
        t2.start();
        // print from main. addItemsToMap is never called so map remains null
        System.out.println("Main");
        MyClass c  = new MyClass();
        System.out.println(c.myMap);
        
    }
}

class MyClass{
    Map<String,String> myMap;
    
    public void addItemsToMap(int startIndex){
        myMap = new HashMap<String,String>();
        for(int i=startIndex;i<startIndex+10;i++){
            myMap.put(""+i,""+i);
        }
    }
    
}
