import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public int countElements(int[] arr) {
        // put the arr in the hashtable, key is the numer and value is how many numbers in the array
        HashSet<Integer> maps  = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            maps.add(arr[i]);
        }

        int count = 0;
        for(int i = 0; i<arr.length; i++){
            int except = arr[i]+1;
            if(maps.contains(except)){
                count ++;

            }
        }

        return count;
    }
}
