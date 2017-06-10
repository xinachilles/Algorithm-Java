package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by xhu on 6/4/17.
 */
public class ThreeThreadsInSync
{
    private static int id = 1;
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

       // ThreadId threadId = new ThreadId();
        //threadId.setId(1);
        Thread t1 = setThread(lock, condition, 1, 2);
        Thread t2 = setThread(lock, condition, 2, 3);
        Thread t3 = setThread(lock, condition, 3, 1);
        t1.start();
        t2.start();
        t3.start();

    }


    private static Thread  setThread(final Lock lock, final Condition condition, int actualThreadId, int nextThreadId) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (id != actualThreadId)
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        System.out.println("" + actualThreadId);
                        id = nextThreadId;
                        condition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        return thread;
    }


}