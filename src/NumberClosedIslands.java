import java.util.HashSet;
import java.util.Set;

public class NumberClosedIslands {
    public int closedIsland(int[][] grid) {
        // update all 0 is not totally surrounded by 1 to 2
        // then count how many closed island is an island totally surrounded by 1
        int rows = grid.length;
        int cols = grid[0].length;
        updateNonclosedIsland(grid,rows,cols);
        return closedIsland(grid,rows,cols);
    }

    private void updateNonclosedIsland(int[][] grid,int rows, int cols){
        for(int i = 0; i<cols;i++){
            if(grid[0][i] == 0){
                updateIsland(0,i,rows,cols,grid,0,2);
            }
        }
        for(int i = 0; i<cols;i++){
            if(grid[rows-1][i] == 0){
                updateIsland(rows-1,i,rows,cols,grid,0,2);
            }
        }
        for(int i = 0; i<rows;i++){
            if(grid[i][0] == 0){
                updateIsland(i,0,rows,cols,grid,0,2);
            }
        }
        for(int i = 0; i<rows;i++){
            if(grid[i][cols-1] == 0){
                updateIsland(i,cols-1,rows,cols,grid,0,2);
            }
        }
    }

    private void updateIsland(int r, int c, int rows, int cols, int[][]grid,int target, int updated ){
        if(r<0 || r>=rows || c<0 || c>=cols){
            return;
        }
        if(grid[r][c]!=target){
            return;
        }
        grid[r][c] = updated;
        updateIsland(r+1,c,rows,cols,grid,target,updated);
        updateIsland(r-1,c,rows,cols,grid,target,updated);
        updateIsland(r,c+1,rows,cols,grid,target,updated);
        updateIsland(r,c-1,rows,cols,grid,target,updated);

    }

    private int closedIsland(int[][] grid,int rows, int cols){
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 2){
                    updateIsland(i,j,rows,cols,grid,2, 0);
                    count++;
                }
            }
        }
        return count;
    }


}
