package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: bgandhi
 * Date: 11/3/13
 * Time: 2:29 PM
 */

public class ProducerConsumer {
    Queue<Integer> queue = new LinkedList<Integer>();

    private static final int MAXSIZE = 10;

    public void put(Integer num) {
        synchronized (this) {
            if (queue.size() < MAXSIZE) {
                queue.offer(num);
                System.out.println("queue = " + queue);
                notify();
            } else {
                try {
                    System.out.println("Producer waiting to be notified");
                    wait();
                    queue.offer(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int get() {
        synchronized (this) {
            while (queue.isEmpty()) {
                try {
                    System.out.println("Consumer waiting to be notified");
                    wait();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("queue = " + queue);
            int result = queue.poll();
            notify();
            return result;
        }
    }

    public int getSize() {
        return queue.size();
    }

    public static void main(String[] args) {
        final ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("Adding: " + i);
                    pc.put(i);
                    /*try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    //while (true) {
                    //     if (pc.getSize() != 0) {
                    int next = pc.get();
                    System.out.println("Processing: " + next);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //   }
                }
            }
        });

        producer.start();
        consumer.start();


    }

}
