import java.util.*;

/**
 * Created by xhu on 12/30/16.
 */
public class SequenceReconstruction {
    public Boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org == null || seqs == null) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int n : org) {
            indegree.put(n, 0);
        }

        for (int[] seq : seqs) {
            if (seq.length == 1) {
                if (graph.get(seq[0]) == null) {
                    graph.put(seq[0], new ArrayList<>());
                }
            }

            for (int i = 1; i < seq.length; i++) {
                int node = seq[i - 1];
                int neighbor = seq[i];

                if (graph.get(node) == null) {
                    graph.put(node, new ArrayList<>());
                }

                if(!indegree.containsKey(neighbor)){
                    return false;
                }
                indegree.put(neighbor, indegree.get(neighbor) + 1);
                graph.get(node).add(neighbor);

            }
        }
        if(graph.keySet().size() !=indegree.size()){
            return false;
        }

        Queue<Integer> visting = new LinkedList<>();

        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                visting.offer(key);
            }
        }


        int index = 0;
        while (!visting.isEmpty()) {
            if(visting.size()>1){
                return false;
            }
            if (index >= org.length) {
                return false;
            }
            int current = visting.poll();
            if (current != org[index]) {
                return false;
            }

            if(graph.get(current)!=null) {
                for (int i : graph.get(current)) {
                    indegree.put(i, indegree.get(i) - 1);
                    if (indegree.get(i) == 0) {
                        visting.offer(i);
                    }
                }
            }
            index++;
        }

        return index == org.length;


    }


}
