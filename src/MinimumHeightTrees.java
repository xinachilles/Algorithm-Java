import java.util.*;

/**
 * Created by xhu on 12/26/16.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 0 || edges == null) {
            return new ArrayList<Integer>();
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] node : edges) {
            int node1 = node[0];
            int node2 = node[1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

            indegree[node1]++;
            indegree[node2]++;
        }

        Queue<Integer> visiting = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] <= 1) {
                visiting.offer(i);
            }
        }

        while (n > 2) {
            int size = visiting.size();
            for(int i = 0; i<size;i++) {
                int node = visiting.poll();
                for (int child : graph.get(node)) {

                    indegree[child]--;
                    if (indegree[child] == 1) {
                        visiting.offer(child);
                    }
                }
            }
        }

        return (List<Integer>) visiting;


    }
}
