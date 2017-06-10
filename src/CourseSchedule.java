import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xhu on 9/26/16.
 */
class Graph2{
    int value;
    List<Graph2> neighbours;

    public Graph2(int value){
        this.value = value;
        neighbours = new ArrayList<>();
    }

}
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        if(numCourses == 0 || prerequisites == null || prerequisites.length ==0){
            return true;
        }
        Graph2[] courses = new Graph2[numCourses];


        for(int i = 0;i<prerequisites.length;i++){
            int courseIndex = prerequisites[i][1];
            int prereq = prerequisites[i][0];

            if(courses[courseIndex] == null){
                courses[courseIndex] = new Graph2(courseIndex);
            }
            courses[courseIndex].neighbours.add(new Graph2(prereq));
        }


        Queue<Graph2> queue = new LinkedList<Graph2>();
        int[] indegree = new int[numCourses];

        for(Graph2 g : courses){
            if(g == null){
                continue;
            }
            for(Graph2 n : g.neighbours){
                indegree[n.value]++;
            }
        }

        int count = 0;
        for(int i = 0; i<indegree.length;i++){
            if(indegree[i] == 0){
                count++;
                queue.offer(courses[i]);
            }
        }

        while(!queue.isEmpty()){
            Graph2 current = queue.poll();
            for(Graph2 n : current.neighbours){
                indegree[n.value]--;
                if(indegree[n.value] == 0){
                    queue.offer(courses[n.value]);
                    count++;
                }
            }
        }
        return count== numCourses;
    }
}
