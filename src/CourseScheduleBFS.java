import java.util.*;

/**
 * Created by xhu on 11/12/16.
 */
public class CourseScheduleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> Graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            Graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int prereq = prerequisites[i][0];

            Graph.get(course).add(prereq);
        }


        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            for (int n : Graph.get(i)) {
                indegree[n]++;
            }
        }

        Queue<Integer> visiting = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                visiting.offer(i);
                count++;
            }
        }

        while (!visiting.isEmpty()) {
            int current = visiting.poll();

            for (int n : Graph.get(current)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    visiting.offer(n);
                    count++;
                }
            }
        }
        return count == numCourses;
    }

}
