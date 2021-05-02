import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ShortestSubarraySumLeastK {
    public int shortestSubarray(int[] A, int K) {
        if(A == null || A.length ==0){
            return -1;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(;right<A.length;right++){
            sum +=A[right];
            while(left<=right && sum >=K){
                min = Math.min(right -left +1, min);
                sum = sum -A[left];
                left ++;
            }
        }

        return min;


    }
}
