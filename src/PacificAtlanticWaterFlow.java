import java.util.*;

public class PacificAtlanticWaterFlow {
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return null;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            List<List<Integer>> result = new ArrayList<>();
            boolean[][] pacific = new boolean[rows][cols];
            boolean[][] atlantic = new boolean[rows][cols];

            Queue<int[]> pQueue = new LinkedList<>();
            Queue<int[]> aQueue = new LinkedList<>();

            for(int i = 0;i<cols; i++){
                pQueue.offer(new int[]{0,i});
                aQueue.offer(new int[]{rows-1,i} );
            }

            for(int i = 0; i<rows; i++){
               pQueue.offer(new int[]{i,0});
               aQueue.offer(new int[]{i,cols-1});
            }

            BFS(matrix,rows,cols,pQueue,pacific);
            BFS(matrix,rows,cols,aQueue,atlantic);

            for(int i = 0; i<rows; i++){
                for(int j = 0; j<cols; j++){
                    if(pacific[i][j] && atlantic[i][j]){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        result.add(temp);
                    }
                }
            }
            return result;
        }

        private void BFS(int[][] matrix, int rows, int cols, Queue<int[]>queue, boolean[][] result ){
            int[][]moves = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

            while (!queue.isEmpty()){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                if(result[row][col]){
                    continue;
                }
                result[row][col] = true;
                for(int i =0; i<4;i++){
                    int r = row+moves[i][0];
                    int c = col+moves[i][1];

                    if(r<0 || c<0|| r>=rows || c>=cols){
                        continue;
                    }
                     queue.offer(new int[]{r,c});
                }
            }

        }

}
