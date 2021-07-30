import java.util.*;

public class ShortestPathGridObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        if(grid.length == 1 && grid[0].length == 1){
            return 1;
        }

        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> visiting = new LinkedList<>();
        // x, y, number of obstacles eliminated
        visiting.offer(new int[]{0, 0, 0});
        Set<String> visited = new HashSet<>();
        //int[][][] visited = new int[40][40][1601];
        visited.add("0->0->0");
        //visited[0][0][0] = 1;
        int step = 0;
        while (!visiting.isEmpty()) {
            int size = visiting.size();
            for (int i = 0; i < size; i++) {
                int[] current = visiting.poll();
                int row = current[0];
                int col = current[1];
                int ob = current[2];
                if (row == grid.length-1 && col == grid[0].length-1 ) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    int r = direction[j][0] + row;
                    int c = direction[j][1] + col;
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
                        continue;
                    }
                    int nextOb = grid[r][c] == 1 ? ob + 1 : ob;
                    if (nextOb > k) continue;
                    String position = String.valueOf(r) + "->" + String.valueOf(c) + "->" + String.valueOf(nextOb);

                   if (!visited.contains(position)) {
                    //if(visited[r][c][nextOb] == 0){
                        visited.add(position);
                       // visited[r][c][nextOb] = 1;
                        visiting.offer(new int[]{r, c, nextOb});
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
