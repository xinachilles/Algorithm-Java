public class Excel {
    int[][] board;
    int rows;
    int cols;

    public Excel(int H, char W) {
        rows = H;
        cols =  W-'A'+1;

        board = new int[rows][cols];
    }

    public void set(int r, char c, int v) {
        if(isBound(r,c)){
            board[r][c] = v;
        }
    }

    public int get(int r, char c) {
        if(isBound(r,c)){
            return board[r][c];
        }else{
            return 0;
        }
    }

    public int sum(int r, char c, String[] strs) {
        String left = strs[0];
        String right = strs[1].split(":")[1];

        int r1 = left.charAt(1)-'0';
        int c1 = left.charAt(0)- 'A'+1;

        int r2 = right.charAt(1)-'0';
        int c2 = right.charAt(0) - 'A'+1;

        if(!isBound(r, c-'A'+1) ||  !isBound(r1,c1) || !isBound(r2,c2)){
            return 0;
        }
        int sum = 0;
        for(int i = r1; i<=r2;i++){
            for(int j = c1;j<=c2;j++){
                sum += board[i][j];
            }
        }

        board[r][c-'A'+1] = sum;
        return sum;
    }

    private boolean isBound(int r, int c){
        if(r>=0 && r<rows && c>=0 && c<cols){
            return true;
        }else{
            return false;
        }
    }
}
