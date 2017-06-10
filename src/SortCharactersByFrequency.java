import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 4/12/17.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        Map<Character,Integer> counts = new HashMap<>();
        int max = 0;
        for(Character c : s.toCharArray()){
            counts.put(c, counts.getOrDefault(c,1)+1);
            max = Math.max(max, counts.get(c));
        }

        List<Character>[] sort = new List[max];
        // sort the Map by value, descend order
        for(Character key : counts.keySet()){
            if(sort[counts.get(key)-1] == null){
                sort[counts.get(key)-1] = new ArrayList<>();
            }

            sort[counts.get(key)-1].add(key);
        }

        StringBuilder result = new StringBuilder();
        for(int i = max-1; i>=0;i--){
            if(sort[i] != null){
                for(Character key : sort[i]){
                    for(int j = 0;i<j;j++){
                        result.append(key);
                    }
                }
            }
        }

        return result.toString();



    }
}
