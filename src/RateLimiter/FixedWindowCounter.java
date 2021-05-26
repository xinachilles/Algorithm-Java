package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowCounter extends RateLimiter {
    // key is sec, value is count
    // threadsafe
    private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();
    public FixedWindowCounter(int maxRequestPerSec){
        super(maxRequestPerSec);
    }
@Override
    boolean allow(){

        // remove the last 3 digit convert to second
        // epoch time start time as 1970 -1-1, how many millsecond have passed since 1970-1-1
        long windowsKey = System.currentTimeMillis()/1000*1000;
        // thread safe
        windows.putIfAbsent(windowsKey,new AtomicInteger(0));
        // atomic operation
        return windows.get(windowsKey).incrementAndGet()<=maxRequestPerSec;
        // other
        /*
        AtomicInteger counter = windows.get(windowsKey);
        boolean result = windows.get(windowsKey).incrementAndGet()<=maxRequestPerSec;
        if(!result){
            counter.decrementAndGet();
        }
        return result;
        */

    }
}
