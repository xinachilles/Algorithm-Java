package MOA;

/**
 * Created by xhu on 6/9/17.
 */
public class LongestCommonSubstring {
    public String longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null){
            return "";
        }

        int[][]dp = new int[A.length()+1][B.length()+1];
        int max = Integer.MIN_VALUE;
        int endPointA = -1;

        for(int i  = 0; i<A.length(); i++){
            for(int j = 0; j<B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;


                    if(max<dp[i+1][j+1]){
                        max  = dp[i+1][j+1];
                        endPointA =i;
                    }
                }else{
                    dp[i+1][j+1] = 0;
                }
            }
        }

        return A.substring(endPointA-max+1,endPointA+1);
    }
}
