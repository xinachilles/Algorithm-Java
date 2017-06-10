import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 11/26/16.
 */
public class BestMeetingPoint {
    //best meeting point


   /* public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {

                    int total = calculationTotalDistance(grid, i, j);
                    if (total < min) {
                        min = total;
                    }
                }
            }
        }

        return min;
    }

    private int calculationTotalDistance(int[][] grid, int x, int y) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total += Math.abs(i - x) + Math.abs(j - y);

                }

            }
        }

        return total;
    }*/

    // best meeting point

    // main a 2d array for each 1 to +all '0'`s distance
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[row][col];

                    BFS(grid, result,visited, i, j);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, result[i][j]);
                }
            }
        }

        return min;
    }

    private void BFS(int[][] grid, int[][] result,boolean[][] visited, int row, int col) {
        int distance = 1;
        Queue<int[]> visiting = new LinkedList<>();
        visiting.offer(new int[]{row, col});
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!visiting.isEmpty()) {
            int size = visiting.size();

            for (int i = 0; i < size; i++) {
                int[] current = visiting.poll();
                for (int j = 0; j < 4; j++) {
                    int x = current[0] + dx[j];
                    int y = current[1] + dy[j];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0 && visited[i][j] == false) {
                        result[x][y] += distance;
                        visited[i][j] = true;
                        visiting.offer(new int[]{x, y});
                    }


                }
            }

            distance++;
        }

    }


}
