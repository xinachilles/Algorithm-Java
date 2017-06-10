import java.util.HashSet;

/**
 * Created by xhu on 9/11/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }


        for (int i = 0; i < 9; i++) {
            HashSet<Integer> cols = new HashSet<>();
            HashSet<Integer> cube = new HashSet<>();
            HashSet<Integer> rows = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                int row_number = board[i][j] - '0';

                if (board[i][j] != '.' && (row_number <= 0 || row_number > 9 || rows.contains(row_number))) {
                    return false;
                }

                int col_number = board[j][i] - '0';
                if (board[j][i] != '.' && (col_number <= 0 || col_number > 9 || cols.contains(col_number))) {
                    return false;
                }

                int row_index = (i / 3) * 3;
                int col_index = (i % 3) * 3;
                int cube_number = board[row_index + j / 3][col_index + j % 3] - '0';

                if (board[row_index][col_index] != '.' && (cube_number <= 0 || cube_number > 9 || cube.contains(cube_number))) {
                    return false;
                }
            }
        }


        return true;

    }
}
