import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
    // event and if merge
    TreeMap<Integer, Integer> books = new TreeMap<Integer, Integer>();

    public boolean book(int start, int end) {
       books.put(start,books.getOrDefault(start,0)+1);
       books.put(end, books.getOrDefault(end,0)-1);
       int count = 0;
       for(Map.Entry<Integer,Integer> entry: books.entrySet()){
           count += entry.getValue();
           if(count>2){
               books.put(start, books.get(start)-1);
               if(books.get(start)  ==0) books.remove(start);

               books.put(end, books.get(end)+1);
               if(books.get(end) == 0) books.remove(end);

               return  false;
           }
       }
       return false;
    }
}
