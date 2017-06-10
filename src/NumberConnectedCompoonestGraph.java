import java.util.*;

/**
 * Created by xhu on 9/28/16.
 */
public class NumberConnectedCompoonestGraph {

    int count = 1;
    public int countComponetns(int n, int[][]edges){
        if(n<=0 || edges.length ==0){
            return 0;
        }

        Map<Integer, List<Integer>> mapping = new HashMap<>();

        for(int[]e :edges){
            int i = e[0];
            int j = e[1];

            if(!mapping.containsKey(i)){
                mapping.put(i,new ArrayList<Integer>());
            }

            mapping.get(i).add(j);
        }
        Set<Integer> visited = new HashSet<Integer>();
        for(int i : mapping.keySet()){
            if(!visited.contains(i)){
                countComponetnsHelper(mapping,edges[0][0],visited);
            }
        }

        return count;
    }

    private void countComponetnsHelper(Map<Integer, List<Integer>> mapping,int current, Set<Integer> visited){
        visited.add(current);
        if(mapping.get(current) == null){
            return;
        }
        for(int i : mapping.get(current)){
            if(!visited.contains(i)){
                countComponetnsHelper(mapping,i,visited);

            }
        }

    }

}
