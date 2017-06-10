/**
 * Created by xhu on 4/23/17.
 */
public class MinesweeperDFS {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || click == null) {
            return null;

        }

        int row = click[0];
        int col = click[1];


        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }


        updateBoardHelper(board, row, col);
        return board;


    }

    private void updateBoardHelper(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board.length) {
            return;
        }
        if(board[row][col] != 'E'){
            return;
        }

        int num = numberOfMin(board, row, col);
        if (num == 0) {
            board[row][col] = 'B';

            updateBoardHelper(board, row + 1, col);
            updateBoardHelper(board, row - 1, col);
            updateBoardHelper(board, row, col + 1);
            updateBoardHelper(board, row, col - 1);
            updateBoardHelper(board, row + 1, col + 1);
            updateBoardHelper(board, row - 1, col - 1);
            updateBoardHelper(board, row + 1, col - 1);
            updateBoardHelper(board, row - 1, col + 1);

        } else {
            board[row][col] = (char) ('0' + num);
        }

    }

    private int numberOfMin(char[][] board, int row, int col) {
        int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
        int[] dy = {0, 1, 0, 1, 1, -1, -1, 1};

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int r = row + dx[i];
            int c = col + dy[i];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'M') {
                count++;
            }
        }

        return count;
    }
}
