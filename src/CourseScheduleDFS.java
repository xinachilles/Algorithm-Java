import java.util.*;

/**
 * Created by xhu on 11/11/16.
 */
public class CourseScheduleDFS {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] course : prerequisites) {
            int first = course[1];
            int second = course[0];

            graph.get(first).add(second);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] ==0) {
                if (hasCycle(graph, visited, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int[] visited, int course) {
        visited[course] = 1;
        boolean hasCycle = false;
        for (int next : graph.get(course)) {
            if (visited[next] == 1) {
                return true;
            } else {
                hasCycle = hasCycle || hasCycle(graph, visited, next);
            }
        }

        visited[course] = 2;
        return hasCycle;
    }
}
