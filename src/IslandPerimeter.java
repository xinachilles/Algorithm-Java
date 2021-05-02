public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int result  = 0;
        for(int i = 0; i<rows;i++){
            for(int j = 0; j<cols;j++){
                if(grid[i][i] == 1){
                    if(isBound(grid,i+1, j,rows,cols)) result++;
                    if(isBound(grid,i-1,j,rows,cols))  result++;
                    if(isBound(grid,i,j+1,rows,cols))  result++;
                    if(isBound(grid,i,j-1,rows,cols))  result++;
                }
            }
        }


        return result;
    }

    private boolean isBound(int[][]grid,int row,int col,int rows, int cols){
        if(row<0 || row>=rows || col<0 || col>=cols){
            return true;
        }

        return grid[row][col] == 0;
    }
}

