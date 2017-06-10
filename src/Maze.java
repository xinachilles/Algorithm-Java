import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 3/4/17.
 */
public class Maze {


    //maze I
  /*  public boolean hasPath(int[][] maze, int[] start, int[] destination){
        if(maze == null || start == null || destination == null){
            return false;
        }
        int rowStart = start[0];
        int colStart = start[1];

        int rowDestionation = destination[0];
        int colDestionation = destination[1];
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        return hasPathHelper(maze, rowStart,colStart, rowDestionation,colDestionation, visited);



    }

    private boolean hasPathHelper(int[][] maze, int rowStart, int colStart, int rowDestionation, int colDestionation, boolean[][] visited){
        if(rowStart == rowDestionation && colStart == colDestionation){
            return true;
        }

        if(rowStart< 0 || rowStart>maze.length || colStart<0 || colStart>maze[0].length){
            return false;
        }

        if(visited[rowStart][colStart]){
            return false;
        }

        if(maze[rowStart][colStart] == 1){
            return false;
        }

       visited[rowStart][colStart] = true;

        // up

        if (rowStart-1 >= 0 && maze[rowStart-1][colStart] != 1 && !visited[rowStart-1][colStart]) {


            if(hasPathHelper(maze,rowStart-1,colStart,rowDestionation,colDestionation,visited)){
                return true;
            }
        }

        // down
        if (rowStart+1<maze.length && maze[rowStart+1][colStart] != 1 && !visited[rowStart+1][colStart]) {
            int i = rowStart + 1;

            if(hasPathHelper(maze,i,colStart,rowDestionation,colDestionation,visited)){
                return true;
            }
        }

        // left
        if (colStart-1< && maze[rowStart+1][colStart] != 1 && !visited[rowStart+1][colStart]) {
            int i = rowStart + 1;

            if(hasPathHelper(maze,i,colStart,rowDestionation,colDestionation,visited)){
                return true;
            }
        }


        return (left || right|| up||down);

    }*/
}
