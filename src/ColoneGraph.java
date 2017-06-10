import java.util.*;

/**
 * Created by xhu on 9/28/16.
 */
class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class ColoneGraph {
    public UndirectedGraphNode coloneGraph(UndirectedGraphNode node){
        if(node == null){
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMaps = new HashMap<>();
        Stack<UndirectedGraphNode> visiting = new Stack<>();
        visiting.push(node);

        Set<UndirectedGraphNode> visited = new HashSet<>();
        while(!visiting.isEmpty()){
            UndirectedGraphNode current = visiting.pop();
            nodeMaps.put(current, new UndirectedGraphNode(current.label));
            visited.add(current);

            for(UndirectedGraphNode n : current.neighbors){
                if(!visited.contains(n))
                visiting.push(n);
            }

        }

        for(UndirectedGraphNode n: nodeMaps.keySet()){
            for(UndirectedGraphNode n1 : n.neighbors){
                nodeMaps.get(n).neighbors.add(nodeMaps.get(n1));
            }
        }

        return nodeMaps.get(node);
    }
}
