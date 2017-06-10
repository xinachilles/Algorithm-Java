import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by xhu on 5/29/17.
 */
public class MazeII {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null) {
            return -1;
        }

        int row = maze.length;
        int col = maze[0].length;

        int[][] distance = new int[row][col];



        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distance[i][j] = Integer.MAX_VALUE;


            }
        }

        Queue<int[]> toVisited = new LinkedList<>();
        toVisited.offer(new int[]{start[0],start[1],0});
        distance[start[0]][start[1]]  = 0;


        while (!toVisited.isEmpty()) {

            int[] current = toVisited.poll();
            int r = current[0];
            int c = current[1];
            int d = current[2];




            //up
            int i = r;
            int tempDistance = d;
            while (i - 1 >= 0 && maze[i - 1][c] != 1) {
                i--;
                tempDistance++;
            }

            if (distance[i][c] > tempDistance && tempDistance<distance[destination[0]][destination[1]]) {
                distance[i][c] = tempDistance;
                toVisited.offer(new int[]{i, c, tempDistance});

            }

            //down
            i = r;
            tempDistance = d;
            while (i + 1 < row && maze[i + 1][c] != 1) {
                i++;
                tempDistance++;
            }

            if (distance[i][c] > tempDistance && tempDistance<distance[destination[0]][destination[1]]) {
                distance[i][c] = tempDistance;
                toVisited.offer(new int[]{i, c, tempDistance});
            }

            //left
            i = c;
            tempDistance = d;
            while (i - 1 >= 0 && maze[r][i-1] != 1) {
                i--;
                tempDistance++;
            }

            if (distance[r][i] > tempDistance && tempDistance<distance[destination[0]][destination[1]]) {
                distance[r][i] = tempDistance;
                toVisited.offer(new int[]{r, i, tempDistance});
            }

            //right
            i = c;
            tempDistance = d;
            while (i + 1 < col && maze[r][i+1] != 1) {
                i++;
                tempDistance++;
            }

            if (distance[r][i] > tempDistance && tempDistance<distance[destination[0]][destination[1]]) {
                distance[r][i] = tempDistance;
                toVisited.offer(new int[]{r, i, tempDistance});
            }


        }


        return distance[destination[0]][destination[1]];
    }
}
