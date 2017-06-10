import java.util.*;

/**
 * Created by xhu on 12/25/16.
 */

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges == null || edges.length == 0) {
            return true;
        }

        if (n != edges.length + 1) {
            return false;
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

        for (int node : graph.keySet()) {
            if (state[node] != 2) {
                if (hasCycleBFS(graph, state, node)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycleBFS(Map<Integer, List<Integer>> graph, int[] state, int node) {
        Queue<Integer> visting = new LinkedList<>();
        state[node] = 1;
        visting.offer(node);

        while (!visting.isEmpty()) {
            int current = visting.poll();
            // find cycle

            for (int child : graph.get(node)) {
                if (state[child] == 2) {
                    continue;
                }

                if (state[child] == 1) {
                    return true;
                }

                state[child] = 1;
                visting.offer(child);
            }

            state[node] = 2;

        }

        return false;


    }


}

