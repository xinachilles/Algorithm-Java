import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 3/10/17.
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || click == null){
            return null;
        }

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> visiting = new LinkedList<>();

        int[] dx = {1,0,-1,0,-1,-1,1,1 };
        int[] dy = {0,1,0,-1,-1,1,-1,1};


        visiting.offer(click);

        while(!visiting.isEmpty()){
            int[] current = visiting.poll();
            int row = current[0];
            int col = current[1];

            if(board[row][col] == 'M'){
                board[row][col] ='X';
                return board;
            }


            int numberOfMine = getNumberOfMine(board,row, col);
            if(numberOfMine == 0){
                board[row][col] = 'B';

                for(int i = 0;i<8;i++){
                    int x = row+dx[i];
                    int y = col+dy[i];

                    if(x>=0 && x<rows && y>=0 && y<cols && board[x][y]=='E' ){
                        visiting.offer(new int[]{x,y});
                    }
                }
            }else{
                board[row][col] =(char)('0'+numberOfMine);
            }


        }

        return board;

    }

    private int getNumberOfMine(char[][] board, int row, int col){
        int[] dx = {1,0,-1,0,-1,-1,1,1 };
        int[] dy = {0,1,0,-1,-1,1,-1,1};

        int result = 0;

        for(int i = 0; i<8;i++){

            int x = dx[i]+row;
            int y = dy[i]+col;

            if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y]=='M' ){
                result++;
            }
        }

        return result;
    }
}
