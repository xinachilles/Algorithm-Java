import java.util.*;

/**
 * Created by xhu on 12/26/16.
 */
public class ColonGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer,UndirectedGraphNode> maps =new HashMap<>();
        return clon(node,maps);

    }

    private UndirectedGraphNode clon(UndirectedGraphNode node,  Map<Integer,UndirectedGraphNode> maps){
        if(node == null){
            return null;
        }

        if(maps.containsKey(node.label)){
            return maps.get(node.label);
        }
        UndirectedGraphNode clonNode = new UndirectedGraphNode(node.label);
        maps.put(node.label,clonNode);

        for(UndirectedGraphNode n : node.neighbors){
            maps.get(node.label).neighbors.add(clon(n,maps));
        }

        return maps.get(node.label);
    }
}

