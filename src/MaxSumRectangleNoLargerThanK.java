import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by xhu on 12/23/16.
 */
public class MaxSumRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;


        for (int left = 0; left < col; left++) {
            int[] sumsCol = new int[row+1];
            for (int right = left; right < col; right++) {
                List<Integer> sumRow = new ArrayList<>();
                sumRow.add(0);
                for (int i = 0; i < row; i++) {

                    sumsCol[i+1] += sumsCol[i];
                    sumsCol[i+1] += matrix[i][right];
                    sumRow.add(sumsCol[i+1]);

                    Collections.sort(sumRow);
                    int index = BinarySearch(sumRow, sumsCol[i+1] - k);
                    if (index >= 0 && index < sumRow.size())
                    {
                        max = Math.max(max, sumsCol[i+1] - sumRow.get(index));

                    }




                }
            }
        }

        return max;
    }

    private int BinarySearch(List<Integer> array, int target){
        int start = 0;
        int end = array.size()-1;

        while (start+1<end){
            int mid = start + (end-start)/2;
            if(array.get(mid)== target){
                return mid;
            }else if(array.get(mid)<target){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(array.get(start)>=target){
            return  start;
        }else if(array.get(end)>=target){
            return end;
        }else {
            return -1;
        }

    }

    /*public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int result = Integer.MIN_VALUE;


        for (int left = 0; left < col; left++) {
            int[] sums = new int[row];
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++) {
                    sums[i] += matrix[i][right];
                }

                //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
                TreeSet<Integer> set = new TreeSet<Integer>();
                //add 0 to cover the single row case
                set.add(0);
                int currSum = 0;

                for(int sum : sums){
                    currSum += sum;
                    //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
                    //therefore we need to look for the smallest sum >= currSum - k
                    Integer num = set.ceiling(currSum - k);
                    if(num != null) result = Math.max( result, currSum - num );
                    set.add(currSum);
                }

            }
        }


        return result;
    }*/
}




