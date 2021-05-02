import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(String cp: cpdomains){
            int count = Integer.valueOf(cp.split(" ")[0]);
            String domin = cp.split(" ")[1];

            for(int i = 0; i<domin.length();i++){
                if(domin.charAt(i) == '.'){
                    String subDomin = domin.substring(i+1,domin.length());
                    map.put(subDomin,map.getOrDefault(subDomin,0)+count);
                }
            }

            map.put(domin,map.getOrDefault(domin,0)+count);
        }
        List<String> result= new ArrayList<>();
        for(String key:map.keySet()){
            result.add(String.valueOf(map.get(key))+" "+key);
        }
        return result;
    }
}
