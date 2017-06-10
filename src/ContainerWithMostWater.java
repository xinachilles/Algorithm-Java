/**
 * Created by xhu on 10/23/16.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height)
    {
        if (height == null || height.length == 0)
        {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (start < end)
        {
            int area = (end - start + 1) * Math.abs(height[start] - height[end]);
            max = Math.max(area, max);

            if (height[start] <= height[end])
            {
                start++;
            }
            else
            {
                end--;
            }
        }

        return max;
    }
}
