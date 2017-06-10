/**
 * Created by xhu on 1/15/17.
 */
public class TrappingRainWater {
    // need matainance two arrays, one the the maxumum height form 0 to i-1 anotheris maximum height from i+1 to n.length-1
    // so the water i can able to trap is min(left[i],right[i]
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int[] left = new int[height.length-1];
        int[] right  = new int[height.length-1];

        left[1] = height[0];
        for(int i = 2;i<height.length;i++ ){
            left[i] = Math.max(left[i-1],height[i-1]);
        }

        right[height.length-2] = height[height.length-1];
        for(int i = height.length-3;i>=0;i++){
            right[i] = Math.max(right[i+1],right[i+1]);
        }

        int total = 0;
        for(int i =2;i<=height.length-2; i++){
            total += Math.max(Math.min(left[i],right[i])-height[i],0);
        }

        return total;
    }
}
