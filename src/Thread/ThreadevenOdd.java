package Thread;

import java.util.concurrent.Semaphore;

/**
 * Created by xhu on 6/4/17.
 */
public class ThreadevenOdd implements Runnable {
    private boolean isEven;
    private int count;
    static Semaphore s = new Semaphore(1);
    static Semaphore t = new Semaphore(0);
    ThreadevenOdd(boolean flag, int c){
        isEven = flag;
        count = c;
    }

    @Override
    public void run() {
        if (isEven){
            try {
                printEven(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                printOdd(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void printOdd(int count) throws InterruptedException{
        int c = 1;
        for(int i=0;i<count;i++){

            s.acquire();
            System.out.println(c);
            c = c+2;
            t.release();

        }

    }

    private void printEven(int count) throws InterruptedException{
        int c = 2;
        for(int i=0;i<count;i++){

            t.acquire();
            System.out.println(c);
            c = c+2;
            s.release();
        }


    }

    public static void main(String[] args){


        Thread a = new Thread(new ThreadevenOdd(true,20));
        Thread b = new Thread(new ThreadevenOdd(false,20));
        a.start();
        b.start();

    }
}
