import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0){
            return image;
        }

        int color = image[sr][sc];
        int[][] moved = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> visiting = new LinkedList<>();
        visiting.offer(new int[]{sr,sc});


        while(!visiting.isEmpty()){
            int[] value = visiting.poll();
            int row = value[0];
            int col = value[1];

            image[row][col] = newColor;
            for(int i = 0;i<4;i++){
                int r = row+moved[i][0];
                int c = col+moved[i][1];

                if(r>=0 && c>=0 && r<image.length && c<image[0].length){
                    if(image[r][c] == color){
                        visiting.offer(new int[]{r,c});
                    }
                }
            }
        }

        return image;
    }
}
