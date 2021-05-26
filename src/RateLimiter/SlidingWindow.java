package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindow extends RateLimiter {

    private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

    protected SlidingWindow(int maxRequestPerSec) {
        super(maxRequestPerSec);
    }

    @Override
    boolean allow() {
        long curTime = System.currentTimeMillis();
        long windowLenInMs = 1000;
        long curWindowKey = curTime / windowLenInMs * windowLenInMs;
        windows.putIfAbsent(curWindowKey, new AtomicInteger(0));
        long preWindowKey = curWindowKey - windowLenInMs;
        AtomicInteger preCount = windows.get(preWindowKey);

        if (preCount == null) {
            return windows.get(curWindowKey).incrementAndGet() <= maxRequestPerSec;
        }
        //current time = ：00:01:15
        //current window kye = 00：01:00
        // preweight = 75%
        double preWeight = 1 - (curTime - curWindowKey) / windowLenInMs;
        long count = (long) (preCount.get() * preWeight
                + windows.get(curWindowKey).incrementAndGet());
        return count <= maxRequestPerSec;
    }
}
