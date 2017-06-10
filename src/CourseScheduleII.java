import java.util.*;

/**
 * Created by xhu on 10/10/16.
 */
public class CourseScheduleII {

    // course schedule ii

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] courses : prerequisites) {
            int course = courses[0];
            int prereq = courses[1];


            graph.get(prereq).add(course);

        }
        int[] visited = new int[numCourses];
        Stack<Integer> postDFS = new Stack<>();

        for (int key : graph.keySet()) {
            if (visited[key] == 0) {
                if (DFS(graph, key, visited, postDFS)) {
                    return new int[]{};
                }
            }
        }

        if (postDFS.size() != numCourses) {
            return new int[]{};
        }
        int[] orders = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            orders[i] = postDFS.pop();
        }

        return orders;
    }

    private boolean DFS(Map<Integer, List<Integer>> graph, int course, int[] visited, Stack<Integer> postDFS) {
        visited[course] = 1;
        boolean hasCycle = false;

        for (int n : graph.get(course)) {
            if (visited[n] == 1) {
                return true;
            } else if (visited[n] == 0) {
                hasCycle = hasCycle || DFS(graph, n, visited, postDFS);
            }
        }

        postDFS.push(course);
        return hasCycle;
    }
}
