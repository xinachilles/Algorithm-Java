import java.util.*;

/**
 * Created by xhu on 9/28/16.
 */
public class EvaluateDivision {

    // evaluate division
    class Node {
        String value;
        double weight;

        public Node(String value, double weight) {
            this.value = value;
            this.weight = weight;

        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        if (equations == null || values == null || queries == null) {
            return null;
        }

        Map<String, List<Node>> graph = new HashMap<>();
        int index = 0;
        for (List<String> equation : equations) {
            String node = equation.get(0);

            String neighbor = equation.get(1);

            double value = values[index++];

            if (graph.get(node) == null) {
                graph.put(node, new ArrayList<>());
            }

            if (graph.get(neighbor) == null) {
                graph.put(neighbor, new ArrayList<>());
            }


            graph.get(node).add(new Node(neighbor, value));

            graph.get(neighbor).add(new Node(node, 1 / value));
        }
        index = 0;
        for (List<String> query : queries) {
            String from = query.get(0);
            String to = query.get(1);
            HashSet<String> visited = new HashSet<>();
            if (graph.containsKey(from) && graph.containsKey(to)) {
                if (from.equals(to)) {
                    result[index] = 1.0;
                } else {
                    result[index] = DFSEquation(from, to, graph, visited, 1);
                }

            } else {
                result[index] = -1.0;
            }
            index++;
        }
        return result;

    }

    private double DFSEquation(String from, String dest, Map<String, List<Node>> graph, HashSet<String> visited, double result) {
        if (from.equals(dest)) {
            return result;
        }

        visited.add(from);
        for (Node n : graph.get(from)) {
            if (n.value.equals(from)) {
                continue;
            }

            if (visited.contains(n.value)) {
                return -1.0;
            }
            Double value = DFSEquation(n.value, dest, graph, visited, result * n.weight);

            if (value > 0) {
                return value;
            }
        }

        return 0.0;
    }


}
