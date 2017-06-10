package Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by xhu on 6/10/17.
 */
public class ProducerCumser {
    enum Type {paper,usb};
    static  Queue<Type> q = new LinkedList<>();
    //static  Random r = new Random();


    public static Thread Produce(final Lock lock, final Condition condition,Type type) {
        Thread thread = new Thread() {
            @Override
            public void run() {

                    lock.lock();
                    try {

                        //int number = r.nextInt();
                        q.offer(type);
                        System.out.println("Producer produced-"
                                + type);

                        condition.signalAll();
                        //Thread.sleep(3000);

                    }finally {
                        lock.unlock();
                    }

                }

        };

        return thread;
    }

    public static Thread PaperConsumer(final Lock lock, final Condition condition ){
        Thread thread = new Thread() {

            public void run() {
                while (true) {
                    lock.lock();
                    try {

                        while (q.isEmpty() || q.peek() != Type.paper) condition.await();

                        System.out.println("Consumer consum paper-"
                                + q.poll());


                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        lock.unlock();
                    }

                }
            }
        };

        return thread;
    }

    public static Thread UsbConsumer(final Lock lock, final Condition condition ){
        Thread thread = new Thread() {

            public void run() {
                while (true) {
                    lock.lock();
                    try {

                        while (q.isEmpty() || q.peek() != Type.usb) condition.await();

                        System.out.println("Consumer consum usb-"
                                + q.poll());


                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        lock.unlock();
                    }

                }
            }
        };

        return thread;
    }


    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        Thread t2 = UsbConsumer(lock, condition);
        Thread t3 = PaperConsumer(lock, condition);

        t2.start();
        t3.start();
        // ThreadId threadId = new ThreadId();
        //threadId.setId(1);

        ExecutorService executor = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 10; i++) {

            Runnable worker = Produce(lock,condition,Type.paper);

            executor.execute(worker);

        }

        for (int i = 0; i < 10; i++) {

            Runnable worker = Produce(lock,condition,Type.usb);

            executor.execute(worker);

        }


    }

}
