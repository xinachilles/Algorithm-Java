package AmazonOA;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ItemsContainers {
    public  List<Integer> numberOfItems(String s, List<Integer> start, List<Integer> end) {
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
        //key is index of compartments and value is the number of itmes from 0 to i-1
        int countSoFar = 0;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '|') {
                treeMap.put(i, countSoFar);
            } else {
                countSoFar++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<start.size(); i++) {
            list.add(number(treeMap, start.get(i) - 1, end.get(i) - 1));
        }
        return list;
    }

    static int number(NavigableMap<Integer, Integer> treemap, int start, int end) {
        if (treemap.floorEntry(end) == null || treemap.ceilingEntry(start) == null)
            return 0;
        int i = treemap.floorEntry(end).getValue() - treemap.ceilingEntry(start).getValue();
        return Math.max(i, 0);
    }
}
