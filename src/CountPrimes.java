/**
 * Created by xhu on 9/18/16.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;
        boolean[] notPrimes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (notPrimes[i] == false) {
                count++;
                for (int j = i; j * i <= n; j++) {
                    notPrimes[i * j] = true;
                }

            }
        }
        return count;
    }
}
