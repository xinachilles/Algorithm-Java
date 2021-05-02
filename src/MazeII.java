import java.util.*;

/**
 * Created by xhu on 5/29/17.
 */
public class MazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null) {
            return 0;
        }
        int rows = maze.length;
        int cols = maze[0].length;

        PriorityQueue<int[]> visiting = new PriorityQueue<int[]>((a, b) -> {
            return a[2] - b[2];
        });
        // if the element first time pop from the queue
        boolean[][] resoved = new boolean[rows][cols];
        visiting.offer(new int[]{start[0], start[1], 0});
        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!visiting.isEmpty()) {
            int[] current = visiting.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];


            if (row == destination[0] && col == destination[1]) {
                return distance;
            }

            if (resoved[row][col]) {
                continue;
            }

            resoved[row][col] = true;

            for (int i = 0; i < 4; i++) {
                int r = row;
                int c = col;
                int d = distance;
                // down
                while (!outofBoundary(r + moves[i][0], c + moves[i][1], rows, cols) && maze[r + moves[i][0]][col + moves[i][1]] != 1) {
                    r = r + moves[i][0];
                    c = c + moves[i][1];
                    d++;
                }
                if (resoved[r][c] == false) {
                    visiting.offer(new int[]{r, col, d});
                }


            }
        }

        return -1;
    }

    private boolean outofBoundary(int r, int c, int rows, int cols) {
        return (r < 0 || r >= rows || c < 0 || c >= cols);
    }

}
