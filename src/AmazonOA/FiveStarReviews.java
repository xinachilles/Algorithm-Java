package AmazonOA;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//For each product, we want to calculate the biggest percentage jump if we add one more five-start to it.
// So we can use a max-heap ,so the top  of the heap is current biggest jump product.
// Then we create a new rating based on this head, add one more five-start to this new rating and push to the heap again. Reminder to keep track the updated rating until we are above the threshold. I don't have enough test cases, so please point me out any problems. Thanks!
public class FiveStarReviews {
    public  int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold){
        int num = 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> diff(l2) - diff(l1)); // max-heap.
        for(List<Integer> rating : productRatings) pq.offer(rating); // initialize PriorityQueue.
        double curRating = 0;
        for(List<Integer> rating : productRatings) {
            curRating += 100.0 * rating.get(0) / rating.get(1); // initialize curRating.
        }
        while(curRating / productRatings.size() < ratingsThreshold ) {
            num++;
            List<Integer> rating = pq.poll();
            List<Integer> newRating = Arrays.asList(rating.get(0)+1, rating.get(1)+1);
            curRating = curRating - 100.0 * rating.get(0) / rating.get(1) + 100.0 * newRating.get(0) / newRating.get(1); // keep updating the rating.
            pq.offer(newRating);
        }
        return num;
    }
    private int diff(List<Integer> p) {
        double currRating = 100.0 * p.get(0) / p.get(1);
        double newRating = 100.0 * (p.get(0)+1) / (p.get(1)+1);
        return (int)(newRating - currRating);
    }
}
