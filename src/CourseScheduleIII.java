import java.util.*;

/**
 * Created by xhu on 10/19/16.
 */
public class CourseScheduleIII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i<numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int[] courses : prerequisites) {
            int course = courses[0];
            int prereq = courses[1];

            graph.get(prereq).add(course);

        }
        BitSet visited = new BitSet(numCourses);
        BitSet onStack = new BitSet(numCourses);
        Stack<Integer> postDFS = new Stack<>();

        for (int key : graph.keySet()) {
            if (!visited.get(key)) {
                if (DFS(graph, key, visited,onStack,postDFS) == false) {
                    return new int[]{};
                }
            }
        }

        if(postDFS.size() != numCourses){
            return  new int[]{};
        }
        int[] orders = new int[ numCourses];
        for(int i = 0; i<numCourses; i++){
            orders[i] = postDFS.pop();
        }

        return orders;
    }

    private boolean DFS(Map<Integer, List<Integer>> graph, int node, BitSet visited, BitSet onStack,  Stack<Integer> postDFS){
        visited.set(node);
        onStack.set(node);


        for(int n:graph.get(node)){
            if(!visited.get(n)){
                if(DFS(graph,n,visited,onStack,postDFS) == false){
                    return false;
                }

            }else{
                if(onStack.get(n)){
                    return false;
                }
            }
        }

        onStack.clear(node);
        postDFS.push(node);
        return true;
    }
}
