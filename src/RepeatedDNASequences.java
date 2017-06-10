import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xhu on 3/24/17.
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();

        if(s == null || s.length() == 0){
            return result;
        }

        int[] hash  = new int[26];
        hash[0] = 0;
        hash['C'-'A'] = 1;
        hash['G'-'A'] = 2;
        hash['T'-'A'] = 3;

        Set<Integer> maps = new HashSet<>();

        for(int i = 0; i+10<=s.length(); i++){
            int code = 0;
            for(int j = i; j<10 && j<s.length();j++){
                code<<=2;
                code  |= hash[s.charAt(j)-'A'];
            }

            if(maps.contains(code) && !result.contains(s.substring(i,i+10))){
                result.add(s.substring(i,i+10));
            }else{
                maps.add(code);
            }

        }

        return result;
    }
}
