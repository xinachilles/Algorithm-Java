import java.util.Arrays;

public class SuperEggDrop {

    // since dp(k-1,i-1) -- egg broken is monotonically decease with i
    // dp[k,n-i) -- egg not broken is monotonically increase with i
    // so we can find the min of max(dp(k-1,i-1),dp[k,n-i)) = the first time



    public int superEggDrop(int k, int n) {
        if(k == 0) return 0;
        if(k == 1) return n;
        if(n<=1) return n;

        int[][]ans = new int[k+1][n+1];
        for(int i  =0; i<=k;i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        return helper(k,n,ans);
    }

    private int helper(int k, int n,int[][] ans){
        if(k == 0) return 0;
        if(k == 1) return n;
        if(n<=1) return n;
        if(ans[k][n] != Integer.MAX_VALUE) return ans[k][n];
        int result = Integer.MAX_VALUE;
        int low = 1;
        int high = n;
        while(low+1<high){
            int mid = low+(high-low)/2;
            if(helper(k,n-mid,ans)>=helper(k-1,mid-1,ans)){
                high = mid;
            }else{
                low = mid;
            }
        }

        if(helper(k,n-low,ans)>=helper(k-1,low-1,ans)){
            result = low;
        }else{
            result = high;
        }

        ans[k][n] = result;

        return ans[k][n];
    }



}
