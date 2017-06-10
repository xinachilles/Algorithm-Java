import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 4/1/17.
 */
public class findAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result  = new ArrayList<>();
        if(s == null || p == null){
            return result;
        }

        Map<Character,Integer> pMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();

        for(Character p1 : p.toCharArray()){
            pMap.put(p1, pMap.getOrDefault(p1,0)+1);
        }

        int left = 0;
        int right  = 0;
        int count = 0;

        for(;right<s.length();right++){
            Character current = s.charAt(right);
            sMap.put(current, sMap.getOrDefault(current,0)+1);

            if(pMap.containsKey(current)){
                if(sMap.get(current)<=pMap.get(current)){
                    count++;
                }
            }

            while(count ==p.length()){
                if(right-left+1 == p.length()) {
                    result.add(left);
                }
                Character leftChar = s.charAt(left);
                sMap.put(leftChar,sMap.get(leftChar)-1);

                if(sMap.get(leftChar)<pMap.get(leftChar)){
                    count--;
                }

                left++;
            }
        }

        return result;
    }
}
