import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 9/14/16.
 */
public class SudokuSolver {
   /* public void solveSudoku(char[][] board)
    {
        if (board == null || board.length == 0)
        {
            return;
        }
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] cubes = new boolean[9][9];

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (board[i][j] != '.')
                {
                    int num = board[i][j] - '0' - 1;
                    int cube_indx = (i / 3) * 3 + j / 3;

                    rows[i][num] = true;
                    cols[j][num] = true;
                    cubes[cube_indx][num] = true;
                }
            }
        }

        boolean result = solveSudokuHelper(board, rows, cols, cubes, 0, 0);
    }

    private Boolean solveSudokuHelper(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] cubes, int rowIndex, int colIndex )
    {
        if (rowIndex >= 9 || colIndex >= 9)
        {
            return true;
        }

        for (int i = 0; i <= 8; i++) {
            int cubeIndex = (rowIndex / 3) * 3 + colIndex / 3;
            if (board[rowIndex][colIndex] != '.' ||  isValidNumber(rows, cols, cubes, rowIndex, colIndex, cubeIndex,i))
            {

                rows[rowIndex][ i] = true;
                cols[colIndex][i] = true;
                cubes[cubeIndex][i] = true;

                if (board[rowIndex][colIndex] == '.')
                {
                    board[rowIndex][colIndex] = (char)(i + 1);
                }
                if (solveSudokuHelper(board, rows, cols, cubes, rowIndex + 1, colIndex) && solveSudokuHelper(board, rows, cols, cubes, rowIndex, colIndex + 1))
                {
                    return true;
                }


                if (board[rowIndex][colIndex] == '.')
                {
                    board[rowIndex][colIndex] = '\0';
                    rows[rowIndex][i] = false;
                    cols[colIndex][i] = false;
                    cubes[cubeIndex][i] = false;
                }

            }
        }

        return false;

    }

    private boolean isValidNumber(boolean[][] rows, boolean[][] cols, boolean[][] cubes, int row, int col,int cubeIndex, int num)
    {

        if ( rows[row][num] == false && cols[col][num] == false && cubes[cubeIndex][num] == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }*/

    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }

        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {

                        if (isValid(board, i, j, k)) {
                            if (solveSudokuHelper(board)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }

        }

        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        Set seen = new HashSet();
        for(int i = 0; i < 9; i++) {
           
        }
        return true;
    }
}
