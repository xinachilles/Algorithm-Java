import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/24/16.
 */
public class PascalTriangle {
    public List<List<Integer>>generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();

            if (i == 0) {
                rows.add(1);
            } else if (i == 1) {
                rows.add(1);
                rows.add(1);

            } else {
                rows.add(1);
                for (int j = 1; j < result.get(i - 1).size() - 1; j++) {
                    rows.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
                }

                rows.add(1);
            }

            result.add(rows);
        }

        return result;
    }
}
