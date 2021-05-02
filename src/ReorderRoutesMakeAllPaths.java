import java.util.*;

public class ReorderRoutesMakeAllPaths {
    int dfs( Map<Integer,List<Integer>> graph, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int to : graph.get(from))
            if (!visited[Math.abs(to)])
                // if the dest node is negative, we need to change the path
                change += dfs(graph, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for (int[] c : connections) {
            // postive means there is a path from 0 to 1
            graph.computeIfAbsent(c[0], a->new ArrayList<>()).add(c[1]);
            graph.computeIfAbsent(c[1], a->new ArrayList<>()).add(-c[0]);

        }
        return dfs(graph, new boolean[n], 0);
    }
}
