import java.util.*;

/**
 * Created by xhu on 12/30/16.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org == null || seqs == null) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if(seq.size() ==1){
                graph.put(seq.get(0),new ArrayList<>());
            }else {
                for (int i = 1; i < seq.size(); i++) {
                    int node = seq.get(i-1);
                    int neighbor = seq.get(i);
                    if(node == neighbor) return  false;
                    if(graph.containsKey(neighbor) && graph.get(neighbor).contains(node)){
                        return false;
                    }
                    graph.computeIfAbsent(node, k -> new ArrayList<>()).add(neighbor);
                }
            }
        }
       
        return Dfs(org,graph,0);

    }

    private boolean Dfs(int[]org, Map<Integer,List<Integer>>graph,int index){
        if(index == org.length){
            return true;
        }
        int node = org[index];
        if(!graph.containsKey(node)){
            return false;
        }
        if(index+1<org.length && !graph.get(node).contains(org[index+1])){
            return  false;
        }

        return Dfs(org,graph,index+1);
    }


}
