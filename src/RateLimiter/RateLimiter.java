package RateLimiter;

public abstract class RateLimiter {
    protected final int maxRequestPerSec;
    public RateLimiter(int maxRequestPerSec){
        this.maxRequestPerSec = maxRequestPerSec;
    }
    abstract boolean allow();

}
