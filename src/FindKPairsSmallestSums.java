import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xhu on 1/22/17.
 */


public class FindKPairsSmallestSums {
    class Position{
        int indexOfnumber1;
        int indexOfnumber2;


        public Position(int index1, int index2){
            this.indexOfnumber1 = index1;
            this.indexOfnumber2 = index2;

        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        PriorityQueue<Position> queue = new PriorityQueue<Position>((a,b)->{
            return nums1[a.indexOfnumber1]+nums2[a.indexOfnumber2]-
            nums1[b.indexOfnumber1]-nums2[b.indexOfnumber2];});

        for(int i = 0; i< nums1.length; i++){
            queue.offer(new Position(i,0));
        }

        while (!queue.isEmpty()&& result.size()<k  ) {
            Position current = queue.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(current.indexOfnumber1);
            temp.add(current.indexOfnumber2);
            result.add(temp);

            if(current.indexOfnumber2+1<nums2.length){
                queue.offer(new Position(current.indexOfnumber1,current.indexOfnumber2+1));
            }

        }



        return result;
    }
}
