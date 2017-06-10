import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by xhu on 1/26/17.
 */
public class SummaryRanges2 {
    TreeMap<Integer,Interval> list;
    public SummaryRanges2() {
        list = new TreeMap<>();
    }

    public void addNum(int val) {

        if(list.containsKey(val)){
            return;
        }
        Integer low = list.lowerKey(val);
        Integer high = list.higherKey(val);



        if(high!=null && high-1 ==val){

            if( low !=null && list.get(low).end +1 == val ) {
                list.get(low).end = list.get(high).end;
            }else{
                list.put(val,new Interval(val,list.get(high).end));
           }
            list.remove(high);
       }else if(low!=null && list.get(low).end+1 >= val){
           list.get(low).end = Math.max(list.get(low).end, val);

        }else{
            list.put(val,new Interval(val,val));
        }

    }

    public List<Interval> getIntervals() {
        List<Interval> result = new ArrayList<>();
        for(Integer i : list.keySet()){
            result.add(list.get(i));
        }

        return result;
    }
}
