import java.util.HashMap;

public class threeSumMulti {
    public int threeSumMulti(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int total = 0;
        for (int i : A) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i = 0; i < A.length - 1; i++) // first num
        {
            if (!map.containsKey(A[i])) {
                continue;
            } else {
                map.put(A[i], map.get(A[i]) - 1);
            }

            if (map.get(A[i]) == 0) {
                map.remove(A[i]);
            }


            for(int j: map.keySet()) // second num
            {
                int k = target - A[i] - j;
                if (!map.containsKey(k) || k == j && map.get(j) == 1 ){
                    continue;
                } else if (k == j) {
                    total += map.get(k)-1;
                } else {
                    total+= map.get(k);
                }

            }
        }

        return total;
    }

}
