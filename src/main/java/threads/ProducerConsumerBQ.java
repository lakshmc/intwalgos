package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Uses Blocking Queue to handle synchronization
 * ArrayBlockingQueue takes max size as argument
 * queue.put()-> adds an item to the queue. if queue is full, then the thread will wait (add() would throw exception)
 * queue.take()-> removes an item from the queue. if queue is empty, then the thread will wait (remove() would throw exception)
 *
 */

public class ProducerConsumerBQ {

    static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args){

        Thread producer = new Thread(new Runnable(){
                public void run(){
                Random rand = new Random();
                    for(int i=0;i<20;i++){ // while(true) produces forever
                        int number = rand.nextInt(10);
                        System.out.println("producing:"+number +" queue:"+queue);
                        try {
                            queue.put(number);
                            //Thread.sleep(500);
                            TimeUnit.MILLISECONDS.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        Thread consumer = new Thread(new Runnable(){
            public void run(){
                while(true){ // consumes forever
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
