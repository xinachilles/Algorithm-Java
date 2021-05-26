package IndeedOnsite;

/* =============================================================================
Follow Up
1.memory不够大怎么办（数据点非常密集，5分钟就把内存爆了）
        2.getMedium方法实现
        需要注意的是follow up都是在原有的代码基础上做改进。

        对于1的方法，数据点密集的话，选择10秒的时间段，合并数据，得到一个10秒的和和数据数量，那么queue
        size就被一个int变量替换掉，这样丢掉过期数据的时候要更新sum和数据总和。这样会造成一定的偏差，
        但是没办法，条件不好内存不够就忍忍吧。

        对于2，就是quick select的find kth in an array的方法。复杂度是O(n).
 */
/*=============================================================================*/

import java.util.Deque;
import java.util.LinkedList;

//应付内存不够的办法。
public class MovingAverage2 {
    class Event {
        int val;
        int time;
        int size;

        public Event(int val, int time) {
            this.val = val;
            this.time = time;
            this.size = 1;
        }
    }

    //queue的容量被限制
    private Deque<Event> queue = new LinkedList<>(); //改成deque的话，可以从后面查
    private long sum = 0; //改用long显得严谨点儿
    int dataNum = 0;

    //这个是每次记录读进来的时间的,这个不用自己写,就是直接返回当前系统时间
    //假设它返回的是秒
    private int getNow() {
        return 0;
    }

    private boolean isExpired(int curTime, int preTime) {
        return curTime - preTime > 300;
    }

    private void removeExpireEvent() {
        while (!queue.isEmpty() && isExpired(getNow(), queue.peekFirst().time)) {
            Event curE = queue.poll();
            sum -= curE.val;
            dataNum -= curE.size;
        }
    }

    public void record(int val) { //其实就是record这里有了两种办法，一种是建个新的，另一种就是合起来
        Event last = queue.peekLast();
        // Combine the data in 10 seconds into one event
        if (getNow() - last.time < 10) {
            last.size += 1;
            last.val += val;
        } else {
            Event event = new Event(getNow(), val);
            queue.offer(event);
        }
        dataNum += 1;
        sum += val;
        removeExpireEvent();
    }

    public double getAvg() {
        removeExpireEvent();
        if (!queue.isEmpty()) {
            return (double) sum / dataNum;
        }
        return 0.0;
    }
}

