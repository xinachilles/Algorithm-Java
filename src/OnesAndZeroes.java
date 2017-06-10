import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 12/17/16.
 */

class Str{
    int numberOfOne = 0;
    int numberOfZero =0;

    private int countOfNumber(String s, char target) {
        if (s == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                count++;
            }

        }

        return count;
    }

    public Str(String str){
        numberOfOne = countOfNumber(str,'1');
        numberOfZero = countOfNumber(str, '0');
    }
}
public class OnesAndZeroes {
    //int max = Integer.MIN_VALUE;

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        Str[] count = new Str[strs.length];
        int[][][] dp = new int[strs.length][m+1][n+1];

        for(int i = 0; i<strs.length; i++){
            count[i] = new Str(strs[i]);

        }


        //dp[i][j][k] means he max number of strs for 0 to i with j 0s and k 1s

        for(int i = 0;i< strs.length; i++){
            int numberOfZero = count[i].numberOfZero;
            int numberOfOne = count[i].numberOfOne;

            if(i == 0 && numberOfZero <=m && numberOfOne<=n){
                dp[i][numberOfZero][numberOfOne] = 1;
            }

            for(int j = 0; j<=m; j++){
                for(int k =0; k<=n; k++){

                    if(i>0) {
                        dp[i][j][k] += dp[i - 1][j][k];

                        if (numberOfZero<=j && numberOfOne<=k &&  dp[i][j][k] < Math.max(dp[i - 1][j - numberOfZero][k - numberOfOne] +1, dp[i][j - numberOfZero][k - numberOfOne])) {
                            dp[i][j][k] = Math.max(dp[i - 1][j - numberOfZero][k - numberOfOne] +1, dp[i][j - numberOfZero][k - numberOfOne]);
                        }
                    }
                }
            }
        }

        return dp[strs.length-1][m][n];
    }
}
