package RateLimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog extends RateLimiter {
    private final Queue<Long> log = new LinkedList<>();

    protected SlidingWindowLog(int maxRequestPreSec){
        super(maxRequestPreSec);
    }
    @Override
    boolean allow(){
        long curTime = System.currentTimeMillis();
        long boundary = curTime -1000; // one second ago
        synchronized(log){
            while (!log.isEmpty() && log.peek()<=boundary){
                log.poll();
            }
            log.add(curTime);
            return log.size()<=maxRequestPerSec;
        }
    }
}
