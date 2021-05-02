import java.util.*;

/**
 * Created by xhu on 9/26/16.
 */


public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        }

        List<String> route = new ArrayList<>();
        Queue<String> visiting = new LinkedList<>();

        visiting.offer("JFK");

        while (!visiting.isEmpty()){
            String airport = visiting.poll();
            while(graph.containsKey(airport) && !graph.get(airport).isEmpty()){
                visiting.offer(graph.get(airport).poll());
            }
            route.add(airport);
        }



        return route;

    }

    private void DFS(String airport,Map<String, PriorityQueue<String>> graph,List<String> route){

        while(graph.containsKey(airport) && !graph.get(airport).isEmpty()){
            DFS(graph.get(airport).poll(),graph,route);
        }
        route.add(0,airport);
    }

}

