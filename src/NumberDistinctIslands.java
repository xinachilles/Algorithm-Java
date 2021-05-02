import java.util.HashSet;

public class NumberDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder path = new StringBuilder();
                    DFS(grid,i, j,path);
                    if(!set.contains(path.toString())){
                        set.add(path.toString());
                    }
                }
            }
        }

        return set.size();

    }

    private void DFS(int[][]grid, int r, int c, StringBuilder path){

        // mark visited
        grid[r][c] = 2;

        if(r +1 < grid.length && grid[r+1][c]  == 1 ) DFS(grid,r+1,c,path.append("D"));
        if(r-1>= 0 && grid[r-1][c] == 1) DFS(grid, r-1, c,path.append("U"));
        if(c+1 < grid.length && grid[r][c+1] ==1 ) DFS(grid, r,c+1,path.append("R"));
        if(c-1>=0 && grid[r][c-1] ==1) DFS(grid, r, c-1, path.append("L"));

    }
}
