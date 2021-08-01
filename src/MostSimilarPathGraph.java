import com.sun.tools.javac.util.JCDiagnostic;

import java.util.*;

public class MostSimilarPathGraph {
    int[][] visited;
    int[][] nextChoiceFromMin;
    String[]names;
    String[]targetPath;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        visited = new int[names.length][targetPath.length];
        nextChoiceFromMin = new int[names.length][targetPath.length];
        this.names = names;
        this.targetPath = targetPath;

        for (int[] road : roads) {
            int source = road[0];
            int destination = road[1];

            graph.computeIfAbsent(source, a -> new ArrayList<>()).add(destination);
            graph.computeIfAbsent(destination, b -> new ArrayList<>()).add(source);
        }
        for(int[] v: visited) Arrays.fill(v,-1);
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
           int resp =  DFS(i, 0);
           if(resp<min){
               min = resp;
               start = i;
           }
        }

        List<Integer> result = new ArrayList<>();

        while (result.size()<targetPath.length){
            result.add(start);
            start = nextChoiceFromMin[start][result.size()-1];
        }
        return result ;


    }

    private int DFS(int currCityIndex,int currPathIndex) {
       if(visited[currCityIndex][currPathIndex]!=-1) return visited[currCityIndex][currPathIndex];
       int diff = names[currCityIndex].equals(targetPath[currPathIndex]) ? 0 : 1;
       if(currPathIndex == targetPath.length-1) return diff;

       int min = Integer.MAX_VALUE;
       int next = 0;
       for (int city : graph.get(currCityIndex)) {
            int neighborCost = DFS(currCityIndex,currPathIndex);
            if(neighborCost<min){
                min = neighborCost;
                nextChoiceFromMin[currCityIndex][currPathIndex] = next;
            }
       }
       diff+=min;
       visited[currCityIndex][currPathIndex] = diff;
       return diff;
    }
}
