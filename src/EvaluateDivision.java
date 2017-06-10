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

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];
        if (equations == null || values == null || queries == null) {
            return null;
        }

        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String node = equations[i][0];

            String neighbor = equations[i][1];

            double value = values[i];

            if (graph.get(node) == null) {
                graph.put(node, new ArrayList<>());
            }

            if (graph.get(neighbor) == null) {
                graph.put(neighbor, new ArrayList<>());
            }


            graph.get(node).add(new Node(neighbor, value));

            graph.get(neighbor).add(new Node(node, 1 / value));
        }

        for (int i = 0; i < queries.length; i++) {
            String from = queries[i][0];
            String to = queries[i][1];
            HashSet<String> visited = new HashSet<String>();
            if (graph.containsKey(from) && graph.containsKey(to)) {
                if (from.equals(to)) {
                    result[i] = 1.0;
                } else {
                    result[i] = DFSEquation(from, to, graph, visited, new ArrayList<>());
                }

            } else {
                result[i] = -1.0;
            }

        }
        return result;

    }

    private double DFSEquation(String from, String dest, Map<String, List<Node>> graph, HashSet<String> visited, List<Double> path) {
        if (from.equals(dest)) {
            Double result = 1.0;
            for (Double n : path) {
                result *= n;
            }

            return result;
        }

        if (graph.get(from) == null || visited.contains(from)) {
            return -1.0;
        }

        visited.add(from);
        for (Node n : graph.get(from)) {
            path.add(n.weight);
            Double value = DFSEquation(n.value, dest, graph, visited, path);
            path.remove(path.size() - 1);
            if (value > 0) {
                return value;
            }
        }

        return -1.0;
    }


}
