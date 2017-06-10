/**
 * Created by xhu on 9/12/16.
 */
public class LongestIncreasingPathMatrix {
    // longest increasing path in a matrix
    public int longestIncreasingPath(int[][] matrix){
        if(matrix == null || matrix.length ==0){
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int max = Integer.MIN_VALUE;

        // array to store the for the i,j
        int[][] longest = new int[row][col];

        for(int i = 0;i<row; i++){
            for(int j = 0; j<col; j++){
                int length = longestIncreasingPathHelper(matrix,i,j,row,col,longest);
                if(max <length){
                    max = length;
                }
            }
        }

        return max;
    }

    private int longestIncreasingPathHelper(int[][] matrix, int i, int j, int row, int col,int[][] longest){
        if( i<0 || i>row || j<0 || j>=col){
            return 0;
        }

        if(longest[i][j] >0){
            return longest[i][j];
        }


        int value = matrix[i][j];
        int up = (i-1>=0 && matrix[i-1][j]>value)? longestIncreasingPathHelper(matrix,i-1,j,row,col,longest):0;
        int down = (i+1<=row-1 && matrix[i+1][j]>value)?longestIncreasingPathHelper(matrix,i+1,j,row,col,longest):0;
        int right = (j+1<=col-1 && matrix[i][j+1]>value)?longestIncreasingPathHelper(matrix,i,j+1,row,col,longest):0;
        int left = (j-1>=0 && matrix[i][j-1]>value)?longestIncreasingPathHelper(matrix,i,j-1,row,col,longest):0;

        int length =  Math.max( Math.max( Math.max(up,down),right),left)+1;

        longest[i][j] = length;
        return length;

    }

}
