import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        if(A == null || A.length ==0){
            return 0;
        }

        int sum = 0;
        int count = 0;
        Map<Integer,Integer> maps = new HashMap<>();
        for(int i = 0;i<A.length;i++){
            sum +=A[i];
            if(sum % K == 0){
                count++;
            }
            sum = sum %K;
            if(maps.containsKey(sum)){
                count +=maps.get(sum);
            }

            maps.put(sum,maps.getOrDefault(sum,0)+1);
        }

        return count; 
    }
}
