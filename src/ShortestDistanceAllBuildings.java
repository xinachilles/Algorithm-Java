import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 12/29/16.
 */
public class ShortestDistanceAllBuildings {

    // main a 2d array for each 1 to +all '0'`s distance
    public int shortestDistance(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];

        int numberOfBuilding = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[row][col];
                    BFS(grid, result, i, j, numberOfBuilding);
                    numberOfBuilding--;

                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && grid[i][j] == numberOfBuilding) {
                    min = Math.min(min, result[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void BFS(int[][] grid, int[][] result, int row, int col, int numberOfBuildings) {
        int distance = 1;
        Queue<Integer[]> visiting = new LinkedList<>();
        visiting.offer(new Integer[]{row, col});
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (visiting.size() > 0) {
            int size = visiting.size();

            for (int i = 0; i < size; i++) {
                Integer[] current = visiting.poll();
                for (int j = 0; j < 4; j++) {
                    int x = current[0] + dx[j];
                    int y = current[1] + dy[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == numberOfBuildings) {

                        result[x][y] += distance;
                        grid[x][y]--;
                        visiting.offer(new Integer[]{x, y});
                    }


                }
            }

            distance++;
        }

    }
}
