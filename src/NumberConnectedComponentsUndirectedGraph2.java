import java.util.*;

/**
 * Created by xhu on 12/26/16.
 */
public class NumberConnectedComponentsUndirectedGraph2 {
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null) {
            return 0;
        }


        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] node : edges) {
            int node1 = node[0];
            int node2 = node[1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        int[] state = new int[n];
        int count = 0;
        for (int node : graph.keySet()) {
            if (state[node] != 2) {
                count++;
                BFS(graph, state, node);

            }
        }

        return count;
    }

    private void BFS(Map<Integer, List<Integer>> graph, int[] state, int node) {
        Queue<Integer> visting = new LinkedList<>();
        state[node] = 1;
        visting.offer(node);

        while (!visting.isEmpty()) {
            int current = visting.poll();
            // find cycle

            for (int child : graph.get(current)) {
                if (state[child] == 2 || state[child] == 1) {
                    continue;
                }
                state[child] = 1;
                visting.offer(child);
            }

            state[current] = 2;

        }


    }
}
