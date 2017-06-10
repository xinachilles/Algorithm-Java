package Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by xhu on 6/4/17.
 */
public class PrintList {
    private List<Integer> list1 = Arrays.asList(new Integer[]{1,2,3,4,5});
    private List<Integer> list2 = Arrays.asList(new Integer[]{1,2,3,4,5});
    private List<Integer> list3 = Arrays.asList(new Integer[]{1,2,3,4,5});
    private int listSize = 5;

    private Semaphore semaphore = null;

    public PrintList() {
        semaphore = new Semaphore(3);
    }

    public void print() throws InterruptedException{
        semaphore.acquire();
        for(int i = 0;i<listSize;i++){
            System.out.println(list1.get(i));
            System.out.println(list2.get(i));
            System.out.println(list3.get(i));
        }
        semaphore.release();
    }

    public static void main(String[] args) {
        final PrintList printList = new PrintList();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    printList.print();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();t2.start();t3.start();
    }

}
