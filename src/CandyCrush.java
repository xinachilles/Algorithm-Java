public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        // error check
        if(board == null || board.length ==0){
            return board;
        }
        boolean done = true; // if we found any 3 adject number are same value, we flap this value to false
        // crush all rows
        for(int i =0; i<board.length;i++){
            for(int j = 0; j<=board[i].length-3;j++){
                    int number1 = Math.abs(board[i][j]);
                    int number2 = Math.abs(board[i][j+1]);
                    int number3 = Math.abs(board[i][j+2]);
                    if(number1 == number2 && number2==number3 && number1!=0){
                        board[i][j] = -number1;
                        board[i][j+1] = -number1;
                        board[i][j+2] = -number1;
                        done = false;
                    }
            }
        }
        // crush all cols
        for(int j =0; j<board[0].length;j++){
            for(int i = 0; i<=board.length-3;i++){
                int number1 = Math.abs(board[i][j]);
                int number2 = Math.abs(board[i+1][j]);
                int number3 = Math.abs(board[i+2][j]);
                if(number1 == number2 && number2==number3 && number1!=0){
                    board[i][j] = -number1;
                    board[i+1][j] = -number1;
                    board[i+2][j] = -number1;
                    done = false;
                }
            }
        }

        //gravity column by column
        for(int j = 0;j<board[0].length;j++ ){
            // move all native to the top

            int index =board.length-1;
            for(int i =board.length-1; i>=0;i--){
                if(board[i][j] >0){
                    board[index--][j] = board[i][j];
                }
            }
            //put zero in for the missing pieces
            for(int i = index; i>=0;i--){
                board[i][j] = 0;
            }
        }


        if(done){
            return  board;
        }else{
            return candyCrush(board);
        }
    }
}
