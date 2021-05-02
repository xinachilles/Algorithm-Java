import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 12/14/16.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> indexOfchars = new HashMap<>();
        for(int i = 0; i<t.length();i++){
            indexOfchars.putIfAbsent(t.charAt(i),new ArrayList<>()).add(i);
        }
        int previous = -1;
        for(int i = 0; i<s.length();i++){
            // find the smallest index great than previous index
            if(indexOfchars.containsKey(s.charAt(i))){
                previous = binarySearch(indexOfchars.get(s.charAt(i)),previous);
                if(previous == -1) return false;
            }else{
                return false;
            }
        }
        return true;
    }

    private int binarySearch(List<Integer> list,int target){
        int begin = 0;
        int end = list.size()-1;
        while (begin+1 <end){
            int mid = begin+ (end-begin)/2;
            if(list.get(mid)<=target){
                begin = mid;
            }else{
                end = mid;
            }

        }

        if(list.get(begin)>target){
            return begin;
        }

        if(list.get(end)>target){
            return end;
        }
        return -1;
    }


}
