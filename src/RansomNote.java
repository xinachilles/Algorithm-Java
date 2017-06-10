import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 10/8/16.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine == null || ransomNote == null){
            return false;
        }

        Map<Character, Integer> magazineIndex = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            if(!magazineIndex.containsKey(c)){
                magazineIndex.put(c, 1);
            }else{
                magazineIndex.put(c, magazineIndex.get(c)+1);
            }
        }

        for(Character c : ransomNote.toCharArray()){
            if(!magazineIndex.containsKey(c)){
                return false;
            }else{
                magazineIndex.put(c,magazineIndex.get(c)-1);
                if(magazineIndex.get(c) == 0){
                    magazineIndex.remove(c);
                }
            }
        }
        return true;
    }

}



