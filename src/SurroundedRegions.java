/**
 * Created by xhu on 12/27/16.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        // search four boards, if it is 'o', dfs it and mark all 'o' to 'a' tempalily
        // search inside, and change all 'o' to 'x'
        // change all 'a' back to 'o'


        if (board == null || board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;


        for (int i = 0; i < col; i++) {

            if (board[0][i] == 'O') {
                boolean[][] visited = new boolean[row][col];
                DFS(board, 0, i);
            }
        }

        // can I combine those two together
        for (int i = 0; i < col; i++) {

            if (board[row - 1][i] == 'O') {
                boolean[][] visited = new boolean[row][col];
                DFS(board, row - 1, i);
            }
        }

        for (int j = 0; j < row; j++) {

            if (board[j][0] == 'O') {
                boolean[][] visited = new boolean[row][col];
                DFS(board, j, 0);
            }
        }

        for (int j = 0; j < row; j++) {

            if (board[j][col - 1] == 'O') {
                boolean[][] visited = new boolean[row][col];
                DFS(board, j, col - 1);
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void DFS(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }

        if (board[row][col] == 'X') {
            return;
        }

        board[row][col] = 'A';


        if (row < board.length - 2 && board[row+1][col] == 'O') DFS(board, row + 1, col);
        if (row >= 2 && board[row-1][col] == 'O' ) DFS(board, row - 1, col);
        if (col < board[0].length - 2 && board[row][col+1] == 'O') DFS(board, row, col + 1);
        if (col >= 2 && board[row][col-1] == 'O') DFS(board, row, col - 1);

        // need change visited back? 
    }
}
