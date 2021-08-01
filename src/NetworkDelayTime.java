import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // create adjacency list map
        // key : source
        // value: {destination,time}
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] time: times){
            int source = time[0];
            int destination = time[1];
            int t = time[2];
            map.computeIfAbsent(source, a->new ArrayList<>()).add(new int[]{destination,t });
        }
        //map will store a id-i,cost pair,  cost is the min cost from node k tp node i
        Map<Integer, Integer> cost = new HashMap<>();
        // heap, sort the node by the cost storted in the cost map
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> cost.get(a)-cost.get(b));
        cost.put(k,0);
        heap.offer(k);
        while (!heap.isEmpty()){
            int node = heap.poll();
            int time = cost.get(node);
            if(!map.containsKey(node)) continue;
            for(int[]neighbors : map.get(node)){
                int des =  neighbors[0];
                int temp  = time+neighbors[1];

                if(!cost.containsKey(des)){
                    cost.put(des,temp);
                    heap.offer(des);
                }else if(cost.get(des)>temp){
                   cost.put(des,temp);
                   heap.offer(des);
                }

            }
        }
        if(cost.size() != n) return -1;
        int res = 0;
        for(int key: cost.keySet()){
            res = Math.max(key,res);
        }
        return res;

    }
}
