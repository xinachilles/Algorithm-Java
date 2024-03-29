package IndeedOnsite;

/* =============================================================================
Question：
=============================================================================*/
/*
Now you have a dice, and throw it multiple times.
        Find the possibility the sum of points is a target number

 */
/* =============================================================================
code
=============================================================================*/
//简单DFS了一下,还是很容易实现的。
//下一步需要看DP和记忆化搜索怎么搞。
public class DiceSum {
    public double getPossibility(int times, int target){
        if (times <= 0 || target < times || target > 6 * times) {
            return 0.0;
        }
        double total = Math.pow(6, times);
        double[] record = new double[1];
        helper(times, target, record);
        double count = record[0];

        return count/total;
    }
    public void helper(int dice, int target, double[] record){
        if (dice == 0 && target == 0){
            record[0]++;
            return;
        }
        if (dice <= 0 || target <= 0){
            return;
        }
        for (int i = 1; i <= 6; i++){
            helper(dice-1, target-i, record);
        }
        return;
    }
    public static void main(String[] args) {
        DiceSum test = new DiceSum();
        int dice = 10;
        int target = 50;
        double res1 = test.getPossibility(dice,target);
        double res2 = test.getPossibility2(dice, target);
        double res3 = test.getPossibility3(dice,target);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

/* =============================================================================
Follow Up
=============================================================================*/
//优化复杂度
/* =============================================================================
Follow Up code
=============================================================================*/
//记忆化搜索解法，复杂度一定比DP要低，就是低到哪里去不太好计算。
//复杂度是 O（状态的个数*状态转移的复杂度），是O(6 * dice)，因为每次只向下查6个。
//anyway，这个是最优解。面试时候直接给这个就行吧。
public double getPossibility2(int dice, int target){
        if (dice <= 0 || target < dice || target > 6*dice) {
        return 0.0;
        }
        double total =  Math.pow(6, dice); //这里注意一下，pow的返回类型是double
      // memo[i][j] how many ways we can get the target sum j if we use i dices
        double[][] memo = new double[dice+1][target+1];
        double count = dfsMemo(dice, target, memo);
    /*
        System.out.println(count);
        for(int r = 0; r < memo.length; r++){
            for (int j = 0; j < memo[0].length; j++) {
                System.out.print(memo[r][j] + " ");
            }
            System.out.println();
        }
    */
        return count/total;
        }
public double dfsMemo(int dice, int target, double[][] memo){
        int res = 0;
        //三个终止条件，能加速就加速吧。
        if (dice == 0){
            if (target == 0) return 1;
            }
        if (target > dice * 6 || target < dice){
            return 0;
        }
        if (memo[dice][target] != 0){
            return memo[dice][target];
        }

        for (int i = 1; i <= 6; i++){
            res += dfsMemo(dice-1, target - i, memo);
        }
        //这一步是更新记忆矩阵
        memo[dice][target] = res;
        return res;
        }
//dp写法，其实下一次扔出某个数字就是上次的结果加上1到6，所以每次向前查6个求和就可以了。
//复杂度也不低，应该是O（dice*target)，如果target很大，就不太好了。
public double getPossibility3(int dice, int target){
        if (dice <= 0 || target < dice || target > 6*dice) {
        return 0.0;
        }
        double total =  Math.pow(6, dice);

        double[][] dp = new double[dice+1][target+1]; //套个0比较方便
        // dp[i][j] means for a dice, throw i times and how many times the sum is j
        for (int j = 1; j <= 6; j++){
            dp[1][j] = 1;
        }
        for (int i = 2; i <= dice; i++){
            for (int j = i; j <= target; j++){
                //每次向前查最多6个。
                for (int k = 1; k <= 6 && j-k >= 0; k++){
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }

        double count = dp[dice][target];
        //System.out.println(count);
        return count/total;
}
}

/* =============================================================================
题目内容：
=============================================================================*/
/*        投dice次数的骰子，求这么多次的点数和为target的概率是多大。
        暴力就是求和的概率就是combination sum（1<->6），比较容易，然后总数就是6的dice次方。

        这题的关键点就在于怎么优化了。记忆化搜索优化的挺好。
        复杂度应该和dp一样，O（6*dice*target）
        *//* =============================================================================
        地里面经总结
        =============================================================================*//*
        写一个函数float sumPossibility(int dice, int target)，就是投dice个骰子，求最后和为target的概率。
        因为总共的可能性是6^dice，所以其实就是combination sum。
        求dice个骰子有多少种组合，使其和为target。先用brute force的dfs来一个O(6^dice)指数复杂度的，
        然后要求优化，用dp，最后结束代码写的是两者结合的memorized search吧*/
