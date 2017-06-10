import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by xhu on 9/18/16.
 */
public class TwoSum {
   /* Set<Integer> maps = new HashSet<Integer>();

    public void add( int number){

        if(!maps.contains(number)){
            maps.add(number);
        }

    }

    public boolean find(int value){

       // Iterator<Integer> it = maps.Interaor();
        if(maps.size()<2){
            return false;
        }
        for(int i : maps){
            if(maps.contains(value-i)){
                return true;
            }
        }

        return false;
    }*/

    // two sum ii input sort

    public int[] twoSum(int[] numbers, int target)
    {
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0)
        {
            return result;
        }

        int start = 0;
        int end = numbers.length-1;

        while (start < end)
        {
            int sum = numbers[start] + numbers[end];
            if (sum == target)
            {
                result[0] = start + 1;
                result[1] = end + 1;

                return result;
            }
            else if (sum < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }

        return result;


    }

}
