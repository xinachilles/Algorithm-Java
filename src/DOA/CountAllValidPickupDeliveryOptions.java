package DOA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CountAllValidPickupDeliveryOptions {
    Set<String> serviceD = new HashSet<>();
    Set<String> serviceP = new HashSet<>();

    public List<List<String>> countOrders(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(2,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int n, List<String> solution, List<List<String>> result){
        if(serviceP.size() == n && serviceD.size() == n){
            result.add(new ArrayList<>(solution));
            return;
        }

        for(int i = 1; i<=n; i++){
            String pickup = "P"+String.valueOf(i);
            if(!serviceP.contains(pickup)) {
                serviceP.add(pickup);
                solution.add(pickup);
                dfs(n, solution, result);
                serviceP.remove(pickup);
                solution.remove(pickup);
            }

            String delivery = "D"+String.valueOf(i);
            if(serviceP.contains(pickup) && !serviceD.contains(delivery)){
                serviceD.add(delivery);
                solution.add(delivery);
                dfs(n,solution,result);
                serviceD.remove(delivery);
                solution.remove(delivery);
            }
        }

    }
}
