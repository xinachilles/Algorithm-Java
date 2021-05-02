package AmazonOA;

public class ValidTicTacToeState {

    public boolean validTicTacToe(String[] board) {
        boolean xWin = false;
        boolean oWin = false;
        int turn = 0;
        int [] rows = new int[3];
        int [] cols = new int[3];
        int diag = 0;
        int antidiag = 0;

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[i].charAt(j) == 'X'){
                    rows[i] ++;
                    cols[j] ++;
                    if(i == j) diag++;
                    if(i+j == 2) antidiag++;
                }else if(board[i].charAt(j) == 'O'){
                    rows[i] --;
                    cols[j] --;
                    if(i == j) diag--;
                    if(i+j == 2) antidiag--;
                }
            }
        }

        for(int i = 0; i<3;i++){
            xWin |= (rows[i] == 3 || cols[i] == 3);

        }
         xWin |=(diag == 3 || antidiag == 3);

        for(int i = 0; i<3;i++){
            oWin |= (rows[i] == -3 || cols[i] == -3);

        }
        oWin |=(diag == -3 || antidiag == -3);

        if( turn < 0 || turn >1 || (turn == 0 && xWin ) || (turn == 1 && oWin )){
            return false;
        }

        return true;

    }
}
