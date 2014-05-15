package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/4/13
 * Time: 9:48 AM
 */

public class ProducerConsumerBQ {

    static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args){

        Thread producer = new Thread(new Runnable(){
                public void run(){
                Random rand = new Random();
                    for(int i=0;i<20;i++){
                        int number = rand.nextInt(10);
                        System.out.println("producing:"+number +" queue:"+queue);
                        try {
                            queue.put(number);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        Thread consumer = new Thread(new Runnable(){
            public void run(){
                while(true){
                    try {
                        int number = queue.take();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("consuming:"+number+" queue:"+queue);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
