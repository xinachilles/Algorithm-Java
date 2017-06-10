/**
 * Created by xhu on 12/10/16.
 */
public class PaintFence {

    // paint fence
    /*int count = 0;
    public int numWays(int n, int k)
    {
        numWaysHelper(n, k, 0, -1);
        return count;
    }

    private void numWaysHelper(int n, int k, int index, int preColor)
    {
        if (index == n)
        {
            count++;
            return;
        }

        for (int i = index; i <= n; i++)
        {
            for (int j = 0; j <= k; j++)
            {
                if (j == preColor)
                {
                    continue;
                }

                numWaysHelper(n, k, i + 1, j);
            }
        }
    }*/

    //paint fence
    int count = 0;
    public int numWays(int n, int k)
    {
        if (n == 0)
        {
            return 0;
        }

        if(n == 1){
            return k;
        }
        if(n == 2){
            return k*k;
        }

        int[] dp  = new int[n];
        dp[0] = k;
        dp[1] = k*k;

        for(int i =2; i<=n;i++){
            dp[i] = (k-1)*(dp[i-1]+dp[i-2]);
        }

        return dp[n-1];
    }
    //// first version
    //private void numWaysHelper(int n, int k, int index, int[] colors)
    //{
    //    if (index > n)
    //    {
    //        count++;
    //        return;
    //    }
    //    // color array to remember the color for each fenc

    //    for (int i = index; i <= n; i++)
    //    {
    //        for (int j = 1; j <= k; j++)
    //        {
    //            // if already have two adjacent fence have same color with i
    //            if (i >= 2 && colors[i - 2] == j && colors[i - 1] == j)
    //            {
    //                continue;
    //            }
    //            colors[i-1] = j;
    //            numWaysHelper(n, k, i + 1, colors);
    //            colors[i-1] = 0;
    //        }
    //    }





    //}

    private void numWaysHelper(int n, int k, int index, int[] colors)
    {
        if (index > n)
        {
            count++;
            return;
        }
        // color array to remember the color for each fenc


        for (int j = 1; j <= k; j++)
        {
            // if already have two adjacent fence have same color with i
            if (index >= 2 && colors[index - 2] == j && colors[index - 1] == j)
            {
                continue;
            }
            colors[index - 1] = j;
            numWaysHelper(n, k, index + 1, colors);
            colors[index - 1] = 0;
        }
    }
}
