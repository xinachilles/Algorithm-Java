import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TimeNeededInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,Set<Integer>> maps = new HashMap<>();

        for(int i = 0; i<n;i++){
            maps.computeIfAbsent(manager[i],k->new HashSet<>()).add(i);
        }
        return DFS(headID,maps,manager,informTime);



        }

        private int DFS(int headID, Map<Integer,Set<Integer>> maps,int[] manager, int[] informTime){
            if(!maps.containsKey(headID)) return 0;
            int total = 0;
            for(int id: maps.get(headID)){
                total = Math.max(total,DFS(id,maps,manager,informTime));
            }

            return total+informTime[headID];

    }

}
