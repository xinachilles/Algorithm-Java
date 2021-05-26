package Indeed;

import java.util.*;

public class LargestRoom {

    private void findLargestGroup(String[][] badge_records) {
        List<Log> logs = new ArrayList<>();
        for (String[] record : badge_records) {
            logs.add(new Log(record));
        }
        Collections.sort(logs, (a, b) -> a.time - b.time);

        Set<String> inRoom = new HashSet();
        inRoom.add(logs.get(0).name);
        List<Status> statuses = new ArrayList<>();
        for (int i = 1; i < logs.size(); i++) {
            Log l = logs.get(i);
            Log pre = logs.get(i - 1);
            statuses.add(new Status(pre.time, l.time, new HashSet<>(inRoom)));
            if (l.isEnter) {
                inRoom.add(l.name);
            } else {
                inRoom.remove(l.name);
            }
        }

        Set<String> largest = new HashSet<>();
        for (int i = 0; i < statuses.size(); i++) {
            for (int j = i + 1; j < statuses.size(); j++) {
                Status a = statuses.get(i);
                Status b = statuses.get(j);
                if (b.start > a.end) {
                    Set<String> common = new HashSet<>(a.people);
                    common.retainAll(b.people);
                    if (common.size() > largest.size()) {
                        largest = common;
                    }
                }
            }
        }

        System.out.println(largest);
        for (Status s : statuses) {
            if (s.people.containsAll(largest)) {
                System.out.println("" + s.start + "," + s.end);
            }
        }
    }

    class Status {
        Set<String> people;
        int start, end;

        public <E> Status(int time, int time1, HashSet<String> es) {
            people = es;
            start = time;
            end = time1;
        }
    }

    class Log {
        String name;
        boolean isEnter;
        int time;

        Log(String[] record) {
            name = record[0];
            time = Integer.parseInt(record[1]);
            isEnter = "enter".equals(record[2]);
        }
    }
}
