import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RangeModule {
    List<Interval> list;

    public RangeModule() {
        list = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        Interval new_interval = new Interval(left, right);
        List<Interval> temp = new ArrayList<>();
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i).end < new_interval.start) {
                temp.add(list.get(i));
            } else if (list.get(i).end >= new_interval.start) {
                new_interval.start = Math.min(list.get(i).start, new_interval.start);
                new_interval.end = Math.max(list.get(i).end, new_interval.end);
            } else if (list.get(i).start > new_interval.end) {
                break;
            }
        }
        temp.add(new_interval);
        for (; i < list.size(); i++) {
            temp.add(list.get(i));
        }

        list = temp;
    }

    public boolean queryRange(int left, int right) {
        if (list.size() == 0) return false;
        // binary search find the greatest interval which start <=left
        int start = 0;
        int end = list.size() - 1;
        Interval temp = new Interval(left, right);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid).end < temp.start) {
                start = mid;
            } else if (list.get(mid).start > temp.end) {
                end = mid;
            } else {
                return totalOverlap(list.get(mid), temp);
            }
        }
            if (totalOverlap(list.get(start), temp)) return true;
            if (totalOverlap(list.get(end), temp)) return true;
            return false;

    }

    private boolean totalOverlap(Interval a, Interval b) {
        return (a.start <= b.start) && (a.end >= b.end);
    }

    public void removeRange(int left, int right) {
        Interval new_interval = new Interval(left, right);
        List<Interval> temp = new ArrayList<>();
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i).end < new_interval.start) {
                temp.add(list.get(i));
            } else if (list.get(i).end >= new_interval.start) {
                if (list.get(i).start < new_interval.start) {
                    temp.add(new Interval(list.get(i).start, new_interval.start));
                }

                if (list.get(i).end > new_interval.end) {
                    temp.add(new Interval(new_interval.end, list.get(i).end));
                }

            } else if (list.get(i).start > new_interval.end) {
                break;
            }
        }
        temp.add(new_interval);
        for (; i < list.size(); i++) {
            temp.add(list.get(i));
        }

        list = temp;
    }

}
