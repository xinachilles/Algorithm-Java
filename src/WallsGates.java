import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 11/26/16.
 */
public class WallsGates {
    // walls and Gates
    public void WallsAndGates(int[][] rooms) {
        // for each item == 0 do the bfs.
        // the distance of first empty room it meet is shortst distance to ists nearest gate.

        final int INF = Integer.MAX_VALUE;
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> visiting = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    visiting.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int distance = 1;
        while (!visiting.isEmpty()) {
            int size = visiting.size();
            for (int i = 0; i < size; i++) {
                int[] current = visiting.poll();
                for (int j = 0; i < 4; i++) {
                    int x = current[0] + dx[j];
                    int y = current[1] + dy[j];

                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (rooms[x][y] == INF) {
                            rooms[x][y] = distance;
                            visiting.offer(new int[]{x, y});
                        }
                    }


                }

            }

            distance++;
        }
    }

}



