import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int[] colors = new int[graph.length]; // 0 unvisited, 1 black , -1 white
      for(int i = 0; i<graph.length; i++) {
          if (colors[i] != 0) {
              continue;
          }

          Queue<Integer> visting = new LinkedList<>();
          visting.offer(0);
          colors[0] = 1;

          while (!visting.isEmpty()) {
              int size = visting.size();

              for (int j = 0; j < size; j++) {
                  int current = visting.poll();

                  for (int node : graph[current]) {
                      if (colors[node] == 0) {
                          colors[node] = -colors[current];
                      } else {
                          if (colors[node] == colors[current]) {
                              return false;
                          }
                      }

                      visting.offer(node);
                  }
              }
          }
      }
        return true;
    }

}
