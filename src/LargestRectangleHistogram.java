import java.util.Stack;

/**
 * Created by xhu on 10/30/16.
 */
public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> index = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= heights.length; i++) {
            int value = Integer.MIN_VALUE;
            if (i < heights.length) {
                value = heights[i];
            }

            while (index.size() > 0 && value < heights[index.peek()]) {
                int j = index.pop();
                int width = index.size() > 0 ? i - index.peek() - 1 : i;
                max = Math.max(width * heights[j], max);

            }

            index.push(i);
        }

        return max;
    }
}
