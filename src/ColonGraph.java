import java.util.*;

/**
 * Created by xhu on 12/26/16.
 */
public class ColonGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMaps = new HashMap<>();
        Queue<UndirectedGraphNode> visiting = new LinkedList<>();
        visiting.offer(node);

        Set<UndirectedGraphNode> visited = new HashSet<>();
        while(!visiting.isEmpty()){
            UndirectedGraphNode current = visiting.poll();
            nodeMaps.put(current, new UndirectedGraphNode(current.label));
            visited.add(current);

            for(UndirectedGraphNode n : current.neighbors){
                if(!visited.contains(n))
                    visiting.offer(n);
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
