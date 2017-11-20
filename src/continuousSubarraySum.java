import java.util.*;

/**
 * Created by xhu on 4/29/17.
 */
public class continuousSubarraySum {
   /* public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        int[] solution = {0,0};
        ArrayList<Integer> result = new ArrayList<>();

        if (A == null || A.length ==0)
        {
            return result;
        }



        int local = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++)
        {
            if(A[i]+local <A[i]){
                solution[0]  =i;
                local = A[i];
            }else{
                local = A[i]+local;
            }
            if(max<local){
                solution[1] = i;
            }


        }

        result.add(A[0]);
        result.add(A[1]);

        return result;
    }*/

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int sum = 0;
        for(int i = 0; i<nums.length;i++){
            sum = sum+nums[i];
            if(k != 0) {
                sum = sum % k;
            }
            if(map.containsKey(sum)){
                if(i-map.get(sum)>1){
                    return true;
                }
            }

            map.put(sum,i);
        }

        return false;

    }
}
