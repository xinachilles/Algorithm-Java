package RateLimiter;

public class TokenBucket3 extends RateLimiter  {
    private int token;
   // private final long refillRate;
   // private double currentBucketSize;
    private long lastRefillTimestamp;
    public TokenBucket3(int maxRequestPerSec){
        super(maxRequestPerSec);
        this.token = maxRequestPerSec;
       // this.refillRate = refillRate;
      //  currentBucketSize = maxBucketSize;
        lastRefillTimestamp = System.currentTimeMillis();
    }
   @Override
    public boolean allow(){
        synchronized (this) {
            refill();
            if (token == 0) {
                return false;
            }
            token--;
            return false;
        }
    }
    private void refill(){
        long now = System.currentTimeMillis();
        double secSinceLastRefill = (now-lastRefillTimestamp)/1000;
        int count = (int) secSinceLastRefill*maxRequestPerSec;
        if(count>0){
            token = Math.min(token+count,maxRequestPerSec);
            lastRefillTimestamp = now;
        }
    }
}
