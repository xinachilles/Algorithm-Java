import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
    // event and if merge
    TreeMap<int[], Boolean> books = new TreeMap<int[],Boolean>((a,b)->a[0]-b[0]);

    public boolean book(int start, int end) {
        int[] book = new int[]{start,end};
        Map.Entry<int[], Boolean> floor = books.floorEntry(book);
        Map.Entry<int[], Boolean> cell = books.ceilingEntry(book);
        boolean floorOverlap = false;
        boolean cellOverlap = false;

        if(floor!=null && start < floor.getKey()[1]){
            if(floor.getValue()) return false;
            floorOverlap = true;
        }
        if(cell !=null && end >cell.getKey()[0]){
            if(cell.getValue()) return false;
            cellOverlap = true;
        }

        if(floorOverlap && cellOverlap){
            books.put(floor.getKey(),true);
            books.put(cell.getKey(),true);
            books.put(book,true);
        }else if(floorOverlap){
            books.put(floor.getKey(),true);
            books.put(book,true);
        }else if(cellOverlap){
            books.put(cell.getKey(),true);
            books.put(book,true);
        }else{
            books.put(book,false);
        }

        return true;


    }
}
