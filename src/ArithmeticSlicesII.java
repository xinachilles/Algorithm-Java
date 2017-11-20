import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 7/19/17.
 */
public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }

        Map<Integer,Integer>[] dp = new Map[A.length];
        // dp[i] = map(d,j) means end of i, the number of arithmetic and dp[i] - d[j] = d is j
        int result = 0;
        for(int i = 1;i<A.length;i++){
            dp[i] = new HashMap<>();

            for(int j = 0; j<i; j++){
                long d = A[i]-A[j];

                if(d>=Integer.MAX_VALUE || d<=Integer.MIN_VALUE){
                    continue;
                }

                int c1 = dp[i].getOrDefault(dp[i].get((int)d),0);
                int c2 = dp[j].getOrDefault(dp[i].get((int)d),0);



                if(c1<c2+1){
                    dp[i].put((int)d,c2+1);
                    result = result+c2;
                }

            }
        }

        return result;

    }
}
