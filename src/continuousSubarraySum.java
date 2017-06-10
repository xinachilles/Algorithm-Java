import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 4/29/17.
 */
public class continuousSubarraySum {
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
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
    }
}
