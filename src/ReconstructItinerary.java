import java.util.*;

/**
 * Created by xhu on 9/26/16.
 */
class GraphNode implements Comparable<GraphNode> {
    String value;
    PriorityQueue<GraphNode> neighbors;

    public GraphNode(String value) {
        this.value = value;
        neighbors = new PriorityQueue<GraphNode>();
    }

    @Override
    public int compareTo(GraphNode o) {
        return value.compareTo(o.value);
    }

}

class Graph {
    public List<GraphNode> nodes;

    public Graph() {
        nodes = new ArrayList<GraphNode>();
    }

    /*
        public boolean contains(String value) {
            for (GraphNode node : nodes) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    */
    public GraphNode get(String value) {
        for (GraphNode node : nodes) {
            if (node.value.equals(value)) {
                return node;
            }
        }
        return null;

    }

    public void add(GraphNode node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
        }
    }
}

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        Graph graph = new Graph();


        if (tickets == null || tickets.length == 0) {
            return result;
        }

        for (String[] ticket : tickets) {
            GraphNode from = new GraphNode(ticket[0]);
            GraphNode to = new GraphNode(ticket[1]);

            if (!graph.nodes.contains(from)) {
                graph.add(from);
            }

            if (!graph.nodes.contains(to)) {
                graph.add(to);
            }


            graph.get(ticket[0]).neighbors.offer(graph.get(ticket[1]));
        }


            // dfs from
            GraphNode start = graph.get("JFK");
            Stack<GraphNode> visiting = new Stack<>();


            if (start == null) {
                return result;
            }

            visiting.push(start);


            while (!visiting.isEmpty()) {

                while (!visiting.peek().neighbors.isEmpty()) {
                    visiting.push(visiting.peek().neighbors.poll());
                }

                result.add(0,visiting.pop().value);

            }



        return result;
    }

    public List<String> findItinerary2(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}

