import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 9/28/16.
 */
/*class Union {
    Map<Integer, Integer> parents = new HashMap<>();

    public Union(int n) {
        parents.put(n, n);

    }

    public int find(int n) {
        int p = parents.get(n);

        while (p != parents.get(p)) {
            p = parents.get(p);
        }

        while (p != parents.get(n)) {
            int temp = parents.get(n);
            parents.put(n, p);
            n = temp;
        }

        return p;
    }

    public boolean isUnion(int n, int m) {
        return find(n) == find(m);
    }

    public void Union(int n, int m) {
        int parentsM = find(m);

        parents.put(n, parentsM);
    }
}

public class ValidTree {
    public boolean validTree(int n, int[][]edges){
        if(edges == null || edges.length == 0 ){
            return true;
        }

        Union un = new Union(n);

        for(int[] pair : edges){
            int k = pair[0];
            int m = pair[1];

            if(un.isUnion(k,m)){
                return false;
            }

            un.Union(k,m);
        }

        return true;
    }
}*/
