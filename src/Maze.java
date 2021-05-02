import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xhu on 3/4/17.
 */
public class Maze {
    int[][]moves=  new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int rows = 0;
    int cols = 0;
    boolean[][]visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null) {
            return false;
        }
        rows = maze.length;
        cols = maze[0].length;

        visited = new boolean[rows][cols];
        return helper(maze, start[0],start[1],destination);
    }

    private boolean helper(int[][] maze, int row, int col, int[] dest) {

        if (row == dest[0] && col == dest[1]) {
            return true;
        }

        if (visited[row][col]) return false;
        visited[row][col] = true;

        for(int i = 0; i<moves.length;i++){
            int r = row;
            int c = col;

            while (!outBound(r+moves[i][0],c+moves[i][1]) && maze[r+moves[i][0]][c+moves[i][1]] != 1) {
                r+=moves[i][0];
                c+=moves[i][1];
            }
            if (helper(maze, r,c, dest)) return true;

        }
    return false;
    }

    private boolean outBound(int row, int col){
        return (row<0 || row>=rows || col<0 || col>=cols);
    }


}
