import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if(words == null || k<=0){
            return result;
        }
        HashMap<String,Integer> maps = new HashMap<>();
        for(int i = 0; i<words.length;i++){
            maps.put(words[i],maps.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<String> queue = new PriorityQueue<String>((a,b)->{ if(maps.get(a) == maps.get(b)) {return a.compareTo(b);}
        else return maps.get(b)-maps.get(a);});

        for(String key: maps.keySet()){
            queue.offer(key);
        }

        while(result.size()<k && !queue.isEmpty()){
            result.add(queue.poll());
        }

        return result;
    }
}
