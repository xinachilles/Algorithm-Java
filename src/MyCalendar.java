import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MyCalendar {
    TreeSet<int[]> books = new TreeSet<int[]>((a,b)->(a[0]-b[0]));



    public boolean book(int start, int end) {
        int[] book = new int[] { start, end }, floor = books.floor(book), ceiling = books.ceiling(book);
        // floor the greatest start time less or equal to the given start time
        // ceiling, the smallest start time greater or equal to the given start time

        if (floor != null && start < floor[1]) return false; // (s, e) start within floor
        if (ceiling != null && ceiling[0] < end) return false; // ceiling start within (s, e)
        books.add(book);
        return true;
    }


}
