/**
 * Created by xhu on 2/11/17.
 */
public class GameLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        // if the cell was marked as 2, that is meaning the its state is 1 and its next state is 0
        // if the cell as marked as 3 that is meaning the its state is 0 and its next state is 1

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                scan(i, j, board);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                update(i, j, board);
            }
        }

    }

    private void update(int row, int col, int[][] board) {
        if (board[row][col] == 2) {
            board[row][col] = 0;
        } else if (board[row][col] == 3) {
            board[row][col] = 1;
        }
    }


    private void scan(int row, int col, int[][] board) {
        int numberOfLives = searchNeighbors(row, col, board);


        if (board[row][col] == 1 && (numberOfLives < 2 || numberOfLives > 3)) {
            board[row][col] = 2;
        }

        if (board[row][col] == 0 && numberOfLives == 3) {
            board[row][col] = 3;
        }
    }

    private int searchNeighbors(int row, int col, int[][] board) {
        int numberOfLives = 0 ;

        if (row - 1 >= 0 && (board[row - 1][col] == 1 || board[row - 1][col] == 2)) {
            numberOfLives++;
        }

        if (row + 1 < board.length && (board[row + 1][col] == 1 || board[row + 1][col] == 2)) {
            numberOfLives++;
        }

        if (col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == 2)) {
            numberOfLives++;
        }

        if (col + 1 < board[0].length && (board[row][col + 1] == 1 || board[row][col + 1] == 2)) {
            numberOfLives++;
        }

        if (col - 1 >= 0 && row - 1 >= 0 && (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == 2)){
            numberOfLives++;
        }

        if (row + 1 < board.length && col + 1 < board[0].length && (board[row + 1][col + 1] == 1 || board[row + 1][col + 1] == 2)) {
            numberOfLives++;
        }

        return numberOfLives;
    }
}
