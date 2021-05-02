import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {
    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private int[] queue;
    private int tail = 0;
    private int head = 0;
    private int size = 0;
    public BoundedBlockingQueue(int capacity) {
         queue = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            // if the queue is full, put thread in the full waiting queue
            while(size == queue.length) {
                full.await();
            }
            queue[tail] = element;
            tail = (tail+1)% queue.length;
            size++;
            // if there is any thread in the empty waiting queue, notify them
            empty.notifyAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            // if the queue is full, put thread in the full waiting queue
            while(size == 0) {
                empty.await();
            }
            int r = queue[head];
            head = (head+1) %queue.length;
            size--;
            // if there is any thread in the empty waiting queue, notify them
            full.notifyAll();
            return r;
        } finally {
            lock.unlock();
        }
    }



    public int size() {
        lock.lock();
        try {
            return this.size;
        } finally {
            lock.unlock();
        }
    }
}