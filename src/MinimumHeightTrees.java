import java.util.*;

/**
 * Created by xhu on 12/26/16.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 0 || edges == null) {
            return null;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for (int[] node : edges) {
            int node1 = node[0];
            int node2 = node[1];

            graph.getOrDefault(node1,new ArrayList<>()).add(node2);
            graph.getOrDefault(node2,new ArrayList<>()).add(node1);

            indegree[node1]++;
            indegree[node2]++;
        }

        Queue<Integer> visiting = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] <= 1) {
                visiting.offer(i);
            }else{
                result.add(i);
            }
        }

        while (result.size() > 2) {
            int size = visiting.size();
            for(int i = 0; i<size;i++) {
                int node = visiting.poll();
                for (int child : graph.get(node)) {

                    indegree[child]--;
                    if (indegree[child] == 1) {
                        visiting.offer(child);
                        result.remove(child);
                        if(result.size()<=2) break;
                    }
                }
            }
        }

        return result;


    }
}
