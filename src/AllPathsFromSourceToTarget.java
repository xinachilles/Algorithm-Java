import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length ==0){
            return null;
        }

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        return helper(graph,0, graph.length-1,map);

    }

    private List<List<Integer>> helper(int[][] graph,int start,int target,Map<Integer, List<List<Integer>>>maps){

        if(maps.containsKey(start)){
            return maps.get(start);
        }
        List<List<Integer>> result = new ArrayList<>();
        if(start == target){
            List<Integer> path = new ArrayList<>();
            path.add(start);
            result.add(path);
        }else{
            for(int n: graph[start]){
                List<List<Integer>> temp = helper(graph,n,target,maps);
                for(List<Integer> t: temp){
                    List<Integer> newPath = new ArrayList<>(t);
                    newPath.add(0,n);
                    result.add(newPath);
                }
            }
        }

        maps.put(start,result);
        return maps.get(start);

    }
}
