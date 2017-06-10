package Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by xhu on 6/10/17.
 */
public class ProducerCumser {
    Queue<Integer> q = new LinkedList<>();
    Random r = new Random();

    public Thread produce(final Lock lock, final Condition condition) throws InterruptedException
    {

        while (true)
        {
            lock.lock();
            try {

                int number = r.nextInt();
                q.offer(number);
                System.out.println("Producer produced-"
                        + number);

                condition.signalAll();
                 Thread.sleep(1000);
            }finally {
                lock.unlock();
            }

        }
    }

    public Thread Coumser(final Lock lock, final Condition condition) throws InterruptedException{
        while (true)
        {
            lock.lock();
            try {

               if(q.isEmpty()) condition.wait();

                System.out.println("Producer produced-"
                        + q.poll());


            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        // ThreadId threadId = new ThreadId();
        //threadId.setId(1);
        Thread t1 = new (lock, condition, 1, 2);
        Thread t2 = setThread(lock, condition, 2, 3);
        Thread t3 = setThread(lock, condition, 3, 1);
        t1.start();
        t2.start();
        t3.start();

    }

}
