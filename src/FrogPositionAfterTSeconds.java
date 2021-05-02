import java.util.*;

public class FrogPositionAfterTSeconds {
    public double frogPosition(int n, int[][] edges, int t, int target) {

        double[]pa = new double[n]; // the probability that after t seconds the frog is on the vertex target
        Map<Integer, List<Integer>> grap = new HashMap<>();
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];

            grap.computeIfAbsent(node1,k->new ArrayList<>()).add(node2);
            grap.computeIfAbsent(node2,k->new ArrayList<>()).add(node1);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        pa[1] = 1;

        while (!queue.isEmpty() && t>0){
            int size = queue.size();
            for(int i = 0; i<size ; i++){
                int node = queue.poll();

                int childrenNumber = 0;
                for(int child: grap.get(node)){
                    if(visited.contains(child)){
                        continue;
                    }
                    childrenNumber++;
                }

                for(int child: grap.get(node)){
                    if(visited.contains(child)){
                        continue;
                    }
                    queue.offer(child);
                    pa[child] = pa[node]/childrenNumber;
                    visited.add(child);

                }
                if(childrenNumber>0) pa[node] = 0;

            }
            t--;
        }

        return pa[target];
    }

}
