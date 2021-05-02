import java.util.*;

import javafx.util.Pair;

public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // map user->{time, website}
        Map<String,List<Pair<Integer,String>>> userLog = new HashMap<>();
        Map<String,Integer> count = new HashMap<>();

        String maxPattern = "";
        for(int i = 0; i<username.length;i++){
            userLog.computeIfAbsent(username[i], x->new ArrayList<>()).add(new Pair<>(timestamp[i],website[i]));
        }
        for(String user: userLog.keySet()){
            List<Pair<Integer,String>> webLog = userLog.get(user);
            if(webLog.size()<3) continue;
            Set<String> set = new HashSet<>();
            // this set is to avoid visit the same 3-seq in one user
            // sort by time stamp
            Collections.sort(webLog,(a,b)->{return a.getKey()-b.getKey();});
            for(int i = 0; i<webLog.size()-3; i++){
                for(int j = i+1; j<webLog.size()-2;j++){
                    for(int k = j+1; k<webLog.size();k++){
                        String pattern = webLog.get(i).getValue()+" "+webLog.get(j).getValue()+" "+webLog.get(k).getValue();
                        if(set.contains(pattern)) continue;
                        set.add(pattern);
                        count.put(pattern,count.getOrDefault(pattern,0)+1);

                        if(!count.containsKey(maxPattern)||(
                                count.get(maxPattern)<count.get(pattern) || count.get(maxPattern) == count.get(pattern) &&
                                maxPattern.compareTo(pattern)>0)){
                                maxPattern = pattern;
                        }
                    }


                }
            }
        }
        return Arrays.asList(maxPattern.split(" "));
    }
}
