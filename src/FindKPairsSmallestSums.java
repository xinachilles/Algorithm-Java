import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xhu on 1/22/17.
 */
class Position implements Comparable<Position> {

    int row;
    int col;
    int val;

    public Position(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;

    }
    public int compareTo(Position a) {
        return this.val-a.val;
    }
}

public class FindKPairsSmallestSums {


    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        PriorityQueue<Position> queue = new PriorityQueue<Position>();

        for(int i = 0; i< nums1.length; i++){
            queue.offer(new Position(i,0,nums1[i]+nums2[0]));
        }

        while (!queue.isEmpty()&& result.size()<k  ) {
            Position current = queue.poll();
            result.add(new int[] {current.row,current.col });
            if(current.col+1<nums2.length){
                queue.offer(new Position(current.row,current.col+1,nums1[current.row]+nums2[current.col+1]));
            }

        }



        return result;
    }
}
