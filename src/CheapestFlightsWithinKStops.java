/*
import java.util.*;

public class CheapestFlightsWithinKStops {
    class Node{
        List<Node> neighbor;
        List<Integer> cost;
        int value;
        int id;


        public Node(int id, int value){
            this.value = value;
            this.node = node;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            if(flights == null || flights.length == 0){
                return 0;
            }




            PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
            pq.offer(new Node(src,0));
            while (!pq.isEmpty() && K>0){
                Node current = pq.poll();
                if(current.node == dst){
                    return current.cost;
                }

                for(int i: flights[current.node])
                    if(n1.cost>current.cost+ )
                }
            }


    }
}
*/
