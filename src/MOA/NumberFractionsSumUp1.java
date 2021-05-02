package MOA;

import java.util.HashMap;
import java.util.Map;

public class NumberFractionsSumUp1 {
    public int solve(int[] x, int[] y) {
        int mod = (int) 1e9 + 7;
        int res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            int p = x[i];
            int q = y[i];
            if (p > q) continue;

            int g = gcd(p, q);
            p /= g;
            q /= g;
            // fraction=p/q, we need (q-p)/q for the other term
            long a1 = (long)(p*mod+q);
            long a2 = (long)( (q - p) * mod + q);

            res = (res + map.getOrDefault(a2, 0)) % mod;
            map.put(a1, map.getOrDefault(a1,0) + 1);

        }
        return res;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x :
                gcd(y, x % y);
    }
}