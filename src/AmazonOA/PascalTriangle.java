package AmazonOA;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> rows = new ArrayList<>();

            if (i == 1) {
                rows.add(1);
            } else if (i == 2) {
                rows.add(1);
                rows.add(1);

            } else {
                rows.add(1);
                for (int j = 1; j < i-1; j++) {
                    rows.add(result.get(i - 1).get(j-1) + result.get(i - 1).get(j));
                }

                rows.add(1);
            }

            result.add(rows);
        }

        return result;
    }

}
