import java.util.HashSet;

public class MagicSquaresGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows < 3 || cols < 3) return 0;

        int total = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquares(grid, i, j)) {
                    total++;
                }
            }
        }

        return total;
    }

    private boolean isMagicSquares(int[][] grid, int row, int col) {
        int totalDiagonal = 0;
        int totalAntiDiagonals = 0;
        for (int i = 0; i < 3; i++) {
            totalDiagonal += grid[row + i][col + i];
            totalAntiDiagonals += grid[row + 2 - i][col + i];
        }

        if (totalAntiDiagonals != totalAntiDiagonals) {
            return false;
        }

        HashSet set = new HashSet();

        for (int i = row; i < 3+row; i++) {
            int totalRow = 0;
            int totalCol = 0;
            for (int j = col; j < 3+col; j++) {
                if(grid[i][j]<1 || grid[i][j]>9){
                    return false;
                }
                if(set.contains(grid[i][j])){
                    return  false;
                }else{
                    set.add(grid[i][j]);
                }

                totalRow += grid[row + i][col+j];
                totalCol += grid[row+j][col + i];
            }
            if (totalRow != totalCol) return false;
            if (totalCol != totalDiagonal) return false;

        }
        return true;
    }
}
