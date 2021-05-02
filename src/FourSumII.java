import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    int count = 0;

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        createPair(A, B, sumCount, false);
        createPair(C, D, sumCount, true);
        return count;
    }

    private void createPair(int[] A, int[] B, Map<Integer, Integer> maps, boolean first) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];

                if (first) {
                    maps.put(sum, maps.getOrDefault(sum, 0) + 1);
                } else {
                    if (maps.containsKey(-sum)) {
                        count += maps.get(-sum);
                    }
                }

            }
        }


    }
}
