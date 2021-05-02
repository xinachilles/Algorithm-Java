import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        // sort by the end point
        Arrays.sort(points,(a,b)->a[1]-b[1]);
        int[] endPoint = points[0];
        int result = 0;
        for(int i = 1; i<points.length;i++){
            if(points[i][1]<endPoint[0]){
                endPoint[0] = Math.min(points[i][0],endPoint[0]);
                endPoint[1] = Math.max(points[i][1],endPoint[1]);
                result++;
            }else{
                endPoint = points[i];
            }

        }

        return points.length-1-result;

    }
}
