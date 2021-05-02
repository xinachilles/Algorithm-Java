import java.util.HashMap;
import java.util.Map;

public class FindTwoNonoverlappingSubarrays {
    public int minSumOfLengths(int[] arr, int target) {
        // map<i,j> key -i is the total sum from 0 to index j
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            map.put(sum,i);
        }
        sum = 0;
        int firstLength = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length;i++){
            sum+=arr[i];
            if(sum == target){
               firstLength = Math.min(firstLength,i);
            }

            if(map.containsKey(sum-target)){
                firstLength = Math.min(firstLength,i-map.get(sum-target));
            }

            if(map.containsKey(sum+target) && firstLength <Integer.MAX_VALUE){
                result = Math.min(result,firstLength+ map.get(sum+target)-i );
            }

        }
        return result;

    }
}
