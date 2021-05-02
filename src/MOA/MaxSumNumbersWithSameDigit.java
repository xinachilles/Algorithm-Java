package MOA;

import java.util.HashMap;
import java.util.Map;

public class MaxSumNumbersWithSameDigit {
    public int findSum(int[] a) {
        int maxSum = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int curr : a) {
            int digitSum = digitSum(curr);
            if (map.containsKey(digitSum)) {
                int prev = map.get(digitSum);
                maxSum = Math.max(maxSum, prev + curr);
                map.put(digitSum, Math.max(prev, curr));
            } else {
                map.put(digitSum, curr);
            }
        }
        return maxSum;
    }

    private int digitSum(int n)
    {
        int sum = 0;
        while (n != 0)
        {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
