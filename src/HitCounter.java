import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xhu on 4/23/17.
 */
public class HitCounter {
    Deque<Integer> count = new LinkedList<>();
    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while(!count.isEmpty() && (timestamp- count.getFirst()>300)){
            count.removeFirst();
        }

        if(!count.contains(timestamp)) {
            count.add(timestamp);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!count.isEmpty() && (timestamp- count.getFirst()>300)){
            count.removeFirst();
        }

        return count.size();
    }
}
