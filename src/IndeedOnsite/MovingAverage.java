package IndeedOnsite;

import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

/* =============================================================================
Question Description
=============================================================================*/
/*
Given a stream of input, and a API int getNow() to get the current time stamp,
         Finish two methods:

         1. void record(int val) to save the record.
         2. double getAvg() to calculate the averaged value of all the records in 5 minutes.
/* =============================================================================
code
=============================================================================*/
public class MovingAverage {
    private Queue<Event> queue = new LinkedList<>();
    private int sum = 0;

    //这个是每次记录读进来的时间的,这个不用自己写,就是直接返回当前系统时间
    private int getNow(){
        return 0; //暂时写个0，苟活
    }

    private boolean isExpired(int curTime, int preTime){
        return curTime - preTime > 300;
    }
    private void removeExpireEvent(){
        while (!queue.isEmpty() && isExpired(getNow(), queue.peek().time)){
            Event curE = queue.poll();
            sum -= curE.val;
        }
    }
    public void record(int val){
        Event event = new Event(getNow(), val);
        queue.offer(event);
        sum += val;

        removeExpireEvent();
    }

    public double getAvg(){
        removeExpireEvent();
        if (!queue.isEmpty()){
            return (double) sum/queue.size();
        }

        return 0.0;
    }
}
class Event{
    int val;
    int time;
    public Event(int val, int time){
        this.val = val;
        this.time = time;
    }
}
