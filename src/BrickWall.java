import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 7/15/17.
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }

        int length = 0;

        for (int l : wall.get(0)) {
            length += l;
        }

        Map<Integer, Integer> maps = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
            }


            maps.put(sum, maps.getOrDefault(sum, 0) + 1);
            max = Math.max(maps.get(sum), max);
        }

        return length - max;


    }
}
