import java.util.*;

public class EmployeeFreeTime {
    class Job{
        int row; //
        int col;

        Job(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Job> pq = new PriorityQueue<Job>((a, b) -> schedule.get(a.row).get(a.col).start - schedule.get(b.row).get(b.col).start);
        for(int i = 0; i<schedule.size();i++){
            pq.offer(new Job(i, 0));
        }
        List<Interval> result = new ArrayList<>();
        Interval i = schedule.get(pq.peek().row).get(pq.peek().col);
        while (!pq.isEmpty()) {
            Job j = pq.poll();
            Interval current = schedule.get(j.row).get(j.col);

            if (schedule.get(j.row).size() > j.col + 1) {
                pq.offer(new Job(j.row, j.col + 1));
            }
            if (i.end < current.start) {
                result.add(new Interval(i.end, current.start));

            }

            i.end = Math.max(i.end, current.end);
        }

        return result;
    }




}




