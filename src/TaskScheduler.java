import java.util.*;

/**
 * Created by xhu on 7/2/17.
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int total = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for(char t: tasks){
            freq.put(t, freq.getOrDefault(t,0)+1);
        }


        PriorityQueue<Character> queue = new PriorityQueue<>((a,b)->{if(freq.get(a) == freq.get(b)) {return a.compareTo(b); } else {return freq.get(b)- freq.get(a); }  } );

        queue.addAll(freq.keySet());

        while(queue.size()>0){
            List<Character> temp = new ArrayList<>();
            int time = n+1;
            while (queue.size()>0 && time>0){
                Character a = queue.poll();
                freq.put(a, freq.get(a)-1);
                if(freq.get(a)>0){
                    temp.add(a);
                }
                time--;
                total++;

            }

            queue.addAll(temp);
            if(queue.size() == 0) break;
            total+=time;
        }
        return  total;


    }
}
