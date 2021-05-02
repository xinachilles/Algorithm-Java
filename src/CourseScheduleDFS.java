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

        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (hasCycle(graph, visited, i)) {
                    return false;
                }
            }
        }
        return (visited.size()==numCourses);

    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, Set<Integer>visited, int course) {

        if (visited.contains(course)){
            return true;
        }

        visited.add(course);
        boolean hasCycle = false;
        for (int next : graph.get(course)) {
            if (visited.contains(next)) {
                return true;
            } else {
                hasCycle = hasCycle || hasCycle(graph, visited, next);
            }
        }


        return hasCycle;
    }
}
