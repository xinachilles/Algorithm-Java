import java.util.*;

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N == 0 || dislikes == null){
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[]dislike : dislikes ){
            int a = dislike[0];
            int b = dislike[1];

            map.computeIfAbsent(a,k->new ArrayList<>()).add(b);
            map.computeIfAbsent(b,k->new ArrayList<>()).add(a);
        }


        int[] visited = new int[N + 1];
        for (int i = 0; i <dislikes.length; i++) {
            if (visited[i] != 0) continue;
            Queue<Integer> visitting = new LinkedList<>();
            visitting.offer(i);
            visited[i] = 1;
            while (!visitting.isEmpty()) {
                int node = visitting.poll();
                if(!map.containsKey(node)) continue;
                for (int n : map.get(node)) {
                    if (visited[n] == 0) {
                        if (visited[n] == visited[node]) {
                            return false;
                        } else {
                            visited[n] = -visited[node];
                            visitting.offer(n);
                        }
                    }
                }
            }
        }

        return true;
    }
}
