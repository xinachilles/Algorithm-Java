package RateLimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucket {

    private final int capacity;
    private final int tokensPerSeconds;
    private int tokens = 0;
    private long timestamp = System.currentTimeMillis();

    public TokenBucket(int tokensPerUnit, TimeUnit unit) {
        capacity = tokensPerSeconds = (int) (tokensPerUnit / unit.toSeconds(1L));
    }

    public boolean take() {
        long now = System.currentTimeMillis();
        // each second put 4 token
        tokens += (int) ((now - timestamp) * tokensPerSeconds / 1000);
        if (tokens > capacity) tokens = capacity;
        timestamp = now;
        if (tokens < 1) return false;
        tokens--;
        return true;
    }


    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(250, TimeUnit.MINUTES);
        Thread.sleep(1000L);
        for (int i = 0; i < 5; i++) {
            System.out.println(bucket.take());
        }
        Thread.sleep(1000L);
        for (int i = 0; i < 5; i++) {
            System.out.println(bucket.take());
        }
    }
}
