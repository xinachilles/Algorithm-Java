import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int rows = A.length;
        int cols = A[0].length;

        for(int i =0;i<rows  ; i++){
            for(int j =0;j<cols; j++){
                if(A[i][j] == 1){
                    // put whole "island" to the queue
                    // and change all island cell to 2
                    DFS(A,rows,cols,i, j,queue);
                    break;
                }
            }
        }
        int step= 0;
        int[][] moves = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                int[] current = queue.poll();
                A[current[0]][current[1]] = 2;

                for(int j = 0; j<4;j++){
                    int r = moves[j][0]+current[0];
                    int c = moves[j][1] +current[1];
                    if(r<0 || r>=rows || c<0 || c>=cols){
                        continue;
                    }
                    if(A[r][c] == 1){
                        return step;
                    }else if(A[r][c] == 0){
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private void DFS(int[][]A, int rows, int cols, int r, int c,Queue<int[]> queue){
        if(r<0 || c< 0 || r>=rows || c>=cols){
            return;
        }
        queue.offer(new int[]{r,c});
        A[r][c] = 2;
        if(r+1<rows && A[r+1][c] == 1) DFS(A,rows,cols,r+1,c,queue);
        if(r-1>=0 && A[r-1][c] == 1) DFS(A,rows,cols,r-1,c,queue);
        if(c+1<cols && A[r][c+1] == 1) DFS(A,rows,cols,r,c+1,queue);
        if(c-1>=0 && A[r][c-1] == 1)  DFS(A,rows,cols,r,c-1,queue);
    }
}
