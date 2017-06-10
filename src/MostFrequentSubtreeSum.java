import java.util.*;

/**
 * Created by xhu on 3/9/17.
 */
public class MostFrequentSubtreeSum {


    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        Map<Integer, Integer> counts = new HashMap<>();

        findFrequentTreeSumHelper(root, counts);

        //Transfer as List and sort it
        ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList(counts.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {

            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> result = new ArrayList<>();

        result.add(l.get(0).getKey());

        for (int i = 1; i < l.size(); i++) {
            if (l.get(i).getValue() != l.get(i - 1).getValue()) {
                break;
            } else {
                result.add(l.get(i).getKey());
            }
        }

        int[] solution = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            solution[i] = result.get(i);
        }

        return solution;
    }


    private int findFrequentTreeSumHelper(TreeNode root, Map<Integer, Integer> counts) {
        if (root == null) {
            return 0;
        }

        int left = findFrequentTreeSumHelper(root.left, counts);
        int right = findFrequentTreeSumHelper(root.right, counts);

        int sum = left + right + root.val;

        if (counts.containsKey(sum)) {
            counts.put(sum, counts.get(sum) + 1);
        } else {
            counts.put(sum, 1);
        }

        return sum;
    }

}
