package RateLimiter;

import org.testng.reporters.jq.Main;

public class TokenBucket2  {
    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucket2(long maxBucketSize,long refillRate){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        currentBucketSize = maxBucketSize;
        lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allRequest(int tokens){
        refill();
        if(currentBucketSize>tokens){
            currentBucketSize-=tokens;
            return true;
        }
        return false;
    }
    private void refill(){
        long now = System.nanoTime();
        double tokenToAdd = (now-lastRefillTimestamp)*refillRate/1e9;
        currentBucketSize = Math.min(currentBucketSize+tokenToAdd,maxBucketSize);
        lastRefillTimestamp = now;
    }


}
