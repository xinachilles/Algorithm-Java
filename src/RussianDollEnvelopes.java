import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xhu on 12/10/16.
 */
public class RussianDollEnvelopes {
    // sort by witdh first, if width is equal, put the bigger


    public int maxEnvelope(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        List<Envelop> list = new ArrayList<>();

        for (int[] e : envelopes) {
            list.add(new Envelop(e[0], e[1]));
        }

        Collections.sort(list);
        int[] dp = new int[list.size()];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).height < list.get(i).height && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

}

class Envelop implements Comparable<Envelop> {
    int height;
    int width;

    public Envelop(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int compareTo(Envelop ep) {
        if (ep.width == this.width) {
            return ep.height - this.height;
        } else {
            return this.width - ep.width;
        }
    }
}
