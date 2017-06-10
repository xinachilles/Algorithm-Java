/**
 * Created by xhu on 4/23/17.
 */
public class TicTacToe {
    int[][] rows;
    int[][] cols;
    int[] leftUpCorner;
    int[] rightUpCorner;
    int number;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n][2];
        cols = new int[n][2];
        leftUpCorner = new int[2];
        rightUpCorner = new int[2];

        number = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row][player-1]++;
        cols[col][player-1]++;

        if(row == col){
            leftUpCorner[player-1]++;
        }
        if(row+col ==number-1){
            rightUpCorner[player-1]++;
        }

        if(rows[row][player-1]== number || cols[col][player-1] == number || leftUpCorner[player-1] == number ||
        rightUpCorner[player-1] ==number){
            return player;
        }else{
            return 0;
        }


    }
}