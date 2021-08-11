import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {
    TreeMap<Integer,Integer> maps= new TreeMap<>();
    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        maps.put(start,maps.getOrDefault(maps.get(start),0)+1);
        maps.put(end,maps.getOrDefault(maps.get(end),0)-1);

        int ongoing = 0;
        int max = 0;
        for(Map.Entry<Integer,Integer> entry: maps.entrySet()){
            ongoing+=entry.getValue();
           max = Math.max(max, ongoing);
        }
        return max;

    }
}