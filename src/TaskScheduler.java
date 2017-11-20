import java.util.*;

/**
 * Created by xhu on 7/2/17.
 */
public class TaskScheduler {
    class Task implements Comparable<Task> {
        Character task;
        int frequency;

        public Task(Character task, int frequency) {
            this.task = task;
            this.frequency = frequency;
        }

        @Override

        public int compareTo(Task t) {
            if (t.frequency == this.frequency) {
                return this.task.compareTo(t.task);
            } else {
                return t.frequency - this.frequency;
            }

        }
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> taskMaps = new HashMap<>();
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        int count = 0;

        intial(tasks, taskMaps, taskQueue);

        while (!taskQueue.isEmpty()) {

            List<Task> temp = new ArrayList<>();
            int k = n + 1;
            while (k >= 0 && !taskQueue.isEmpty()) {
                Task current = taskQueue.poll();
                current.frequency--;
                if (current.frequency > 0) {
                    temp.add(current);
                }

                k--;
                count++;

            }


            for (int i = 0; i < temp.size(); i++) {
                taskQueue.offer(temp.get(i));
            }

            if (taskQueue.isEmpty()) break;
            if (k >= 0) count = count + k;

        }

        return count;

    }

    private void intial(char[] task, Map<Character, Integer> taskMaps, PriorityQueue<Task> taskQueue) {
        for (char t : task) {
            taskMaps.put(t, taskMaps.getOrDefault(t, 0) + 1);
        }

        for (char key : taskMaps.keySet()) {
            Task t = new Task(key, taskMaps.get(key));

            taskQueue.offer(t);
        }
    }
}
