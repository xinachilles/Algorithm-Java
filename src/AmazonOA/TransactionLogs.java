package AmazonOA;

import java.util.*;

public class TransactionLogs {
    public List<String> getFraudIds(String[] input, int threshold) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String log : input) {
            String[] parsed = log.split(" ");
            String usr1 = parsed[0];
            String usr2 = parsed[1];
            if(!usr2.equals(usr1)) {
                map.put(usr2, map.getOrDefault(usr2, 0)+1);
                if(map.get(usr2) >= threshold && !list.contains(usr2)) list.add(usr2);
            }
            map.put(usr1, map.getOrDefault(usr1, 0)+1);
            if(map.get(usr1) >= threshold && !list.contains(usr1)) list.add(usr1);
        }

        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.valueOf(s2).compareTo(Integer.valueOf(s1));
            }
        });
        //Collections.sort(list,Collections.reverseOrder());
        return list;
    }
}
