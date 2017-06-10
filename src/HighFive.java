import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by xhu on 3/12/17.
 */
class Record {
    public int id, score;

    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}

public class HighFive {

    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> result = new HashMap<>();
        if (results == null || results.length == 0) {
            return result;
        }

        Map<Integer, PriorityQueue<Integer>> counts = new HashMap<>();
        for (Record r : results) {
            if (counts.containsKey(r)) {
                if (counts.get(r.id).size() > 5) {
                    if (counts.get(r.id).peek() < r.score) {
                        counts.get(r.id).poll();

                    } else {
                        continue;
                    }
                }
                counts.get(r.score).offer(r.score);
            } else {
                counts.put(r.id, new PriorityQueue<Integer>());
                counts.get(r.id).offer(r.score);
            }

        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : counts.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            int sum = 0;
            double average = 0;
            for (int i = 0; i < 5; ++i){
                sum += scores.poll();
            }

            average = (double)sum/5.0;
            result.put(id, average);
        }

        return result;
    }
}
