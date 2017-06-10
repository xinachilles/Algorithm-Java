/**
 * Created by xhu on 10/29/16.
 */
public class UniquePaths {
   /* public int uniquePath(int m, int n)
    {
        if (m < 0 || n < 0) {
            return 0;
        }

        if(m == 0 && n ==0){
            return 1;
        }

        return uniquePath(m - 1, n) + uniquePath(m, n - 1);
    }*/


    private int uniquePath(int m, int n)
    {
        if(m == 0 || n==0){
            return 0;
        }
        int[][] pathes = new int[m][n];

        uniquePathHelper(0,0,pathes,m,n);
        // return 00 or return m-1 n-1
        return pathes[0][0];

    }

    private int uniquePathHelper(int i, int j, int[][] pathes, int m, int n)
    {
        if (i >= m || j >= n)
        {
            return 0;
        }

        if (pathes[i][j] > 0)
        {
            return pathes[i][j];
        }

        pathes[i][j] = uniquePathHelper(i + 1, j, pathes, m, n) + uniquePathHelper(i, j + 1, pathes, m, n);
        return pathes[i][j];
    }

}
