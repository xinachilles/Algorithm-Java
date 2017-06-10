import java.util.List;

/**
 * Created by xhu on 10/30/16.
 */
public class Triangle {
    // triangel

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int nums = triangle.get(triangle.size() - 1).size();
        int[] min = new int[nums];

        for (int i = 0; i < min.length; i++)
        {
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums; i++) {
            min[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j<=i; j++)
            min[j] = Math.min(min[j + 1], min[j]) + triangle.get(i).get(j);
        }

        return min[0];
    }
}
