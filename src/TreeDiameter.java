import java.util.ArrayList;
import java.util.List;

public class TreeDiameter {
    int max  = 1;
    public int treeDiameter(int[][] edges) {
        int edge = edges.length;
        List<Integer>[] graph = new List[edge];

        for(int i = 0; i<edge; i++ ){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<edge; i++){
            int a  = edges[i][0];
            int b = edges[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }

        return helper(graph,0,-1);
    }

    private int helper(List<Integer>[]graph,int root, int parents){
       int deapest1 =1;
       int deapest2 =1;

       for(int child : graph[root]){
           if(child == parents) continue;
           int deap = helper(graph,child,root);
           if(deap > deapest1 ){
               deapest2 =  deapest1;
               deapest1 =  deap;
           }else if(deap > deapest2){
               deapest2 = deap;
           }
       }
       max = Math.max(max,deapest1+deapest2+1);
       return deapest1+1;
    }
}
