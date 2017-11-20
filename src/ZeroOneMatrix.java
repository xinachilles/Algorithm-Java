import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 7/15/17.
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] update = new int[rows][cols];

        Queue<int[]> toVisited = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    toVisited.offer(new int[]{i, j});
                } else {
                    update[i][j] = Integer.MAX_VALUE;
                }

            }
        }

        int distance = 1;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!toVisited.isEmpty()) {
            int size = toVisited.size();
            for (int i = 0; i < size; i++) {
                int[] current = toVisited.poll();


                for (int j = 0; j < 4; j++) {
                    int r = current[0] + dx[j];
                    int c = current[1] + dy[j];

                    if (isBound(r, c, rows, cols) && matrix[r][c] == 1) {
                        if (update[r][c] > distance) {
                            update[r][c] = distance;
                        }
                        toVisited.offer(new int[]{r, c});

                    }


                }

            }

            distance++;
        }

        return update;
    }

    private boolean isBound(int r, int c, int row, int col) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return false;
        }

        return true;
    }
}
