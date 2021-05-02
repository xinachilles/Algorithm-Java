import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;

        Queue<Tuple> queue = new LinkedList<>();
        Set<Tuple> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int tmp = (1 << i);
            set.add(new Tuple(tmp, i));
            queue.add(new Tuple(tmp, i));
        }
        int step = 1;

        while (!queue.isEmpty()) {
            Tuple curr = queue.remove();

            if (curr.bitMask == (1 << N) - 1) {
                return step;
            }
            int size = queue.size();
            for(int i = 0; i<size; i++) {

                for (int v : graph[curr.id]) {
                    int bitMask = curr.bitMask;
                    bitMask = bitMask | (1 << v);

                    Tuple t = new Tuple(bitMask, v);
                    if (!set.contains(t)) {
                        queue.add(new Tuple(bitMask, v));
                        set.add(t);
                    }
                }
            }
                step++;

        }
        return -1;
    }
}

class Tuple {
    int bitMask;
    int id;


    public Tuple(int bit, int n) {
        bitMask = bit;
        id = n;

    }

    public boolean equals(Object o) {
        Tuple p = (Tuple) o;
        return bitMask == p.bitMask && id == p.id;
    }

    public int hashCode() {
        return 1331 * bitMask + 7193 * id;
    }
}
