package AmazonOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OptimalUtilization {
    public static List<List<Integer>> getPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {

        Comparator<List<Integer>> cmp = Comparator.comparing(p -> p.get(1));

        Collections.sort(a, cmp);
        Collections.sort(b,cmp);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> maxPairs = new ArrayList<>();
        int indexA = 0;
        int indexB = b.size()-1;

        while (indexA<a.size() && indexB>=0){
            List<Integer> x = a.get(indexA);
            List<Integer> y = b.get(indexB);
            int curSum = x.get(1) + y.get(1);
            if (curSum > target) {
                indexB--;

            }else {
                List<Integer> solution = new ArrayList<>();
                solution.add(x.get(0));
                solution.add(y.get(0));

                if (target-curSum == min) {
                    maxPairs.add(solution);
                }else if (target-curSum<min) {
                    min = target-curSum;
                    maxPairs.clear();
                    maxPairs.add(solution);
                }

                indexA++;
            }
        }
        return maxPairs;
    }
}
