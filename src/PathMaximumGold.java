public class PathMaximumGold {
    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols;j++){

                max = Math.max(max,DFS(grid,i,j,rows,cols,new boolean[rows][cols]));
            }
        }
        return max;
    }

    private int DFS(int[][]grid, int rows,int cols, int i, int j, boolean[][] visited){
        if(i<0 || i>=rows|| j<0 || j>=cols){
            return 0;
        }
        if(visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int down = DFS(grid,rows,cols,i+1,j, visited);
        int up = DFS(grid,rows,cols,i-1,j, visited);
        int right = DFS(grid,rows,cols,i,j+1, visited);
        int left = DFS(grid,rows,cols,i,j-1, visited);

        return Math.max(Math.max(down,up),Math.max(right,left))+grid[i][j];


    }
}
