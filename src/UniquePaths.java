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
        int[]pathes = new int[n];
        pathes[0] = 1;
        for(int i = 0; i<m; i++){
           for(int j = 0; j<n; j++){
               if(j>0) {
                   pathes[j] = +pathes[j - 1];
               }
           }
       }

        return pathes[n];

    }



}
