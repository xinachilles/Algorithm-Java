package Indeed;

import java.util.*;

public class Door {
    /*
    * Given a list of people who enter and exit, find the people who entered without
their badge and who exited without their badge.
    *
    * */

    public static List<List<String>> invalidBadgeRecords(List<String[]> records) {
        if (records == null || records.size() == 0) {
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        // 0 for exited, 1 for entered
        Set<String> enter = new HashSet<>();
        Set<String> invalidEnter = new HashSet<>();
        Set<String> invalidExit = new HashSet();
        for (String[] record : records) {

            String name = record[0];
            String action = record[1];

            if (action.equals("enter")) {
                if (!enter.contains(name)) {
                    enter.add(name);
                } else {
                    invalidExit.add(name);
                }
            } else {
                if (enter.contains(name)) {
                    enter.remove(name);
                } else {
                    invalidEnter.add(name);
                }
            }
        }
        for (String name : enter) {
            invalidExit.add(name);
        }
        result.add(new ArrayList<>(invalidEnter));
        result.add(new ArrayList<>(invalidExit));

        return result;
    }
    /*
    * 给 list of [name, time], time is string format: '1300' //下午一点
return: list of names and the times where their swipe badges within one hour. if there are multiple intervals that satisfy the condition, return any one of them.
name1: time1, time2, time3...
name2: time1, time2, time3, time4, time5...
example:
input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']]
output: {
'Martha': ['1600', '1620', '1530']
}
    *
    * */

    public Map<String, List<String>> frequentAccess(List<String[]> records) {
        if (records == null || records.size() == 0) {
            return null;
        }
        //const result = [];
        Map<String, List<String>> nameToTimes = new HashMap<>();
        for (String[] record : records) {
            nameToTimes.computeIfAbsent(record[0], a -> new ArrayList<>()).add(record[1]);
        }
        Map<String, List<String>> result = new HashMap<>();
        for (String key : nameToTimes.keySet()) {
            List<String> times = nameToTimes.get(key);
            if (times.size() < 3) continue;
            Collections.sort(times, (a, b) -> timeDifference(a, b));

            int start = 0;
            int count = 1;
            for (int i = 1; i < times.size(); i++) {
                if (timeDifference(times.get(start), times.get(i)) < 60) {
                    count++;
                } else {
                    start = i;
                    count = 1;
                }
                if (count >= 3) {
                    result.put(key, times.subList(start, i));
                    return result;
                }
            }

        }
        return null;

    }

    private int timeDifference(String a, String b) {

        int aHour = (int) Math.floor(Integer.valueOf(a) / 100);
        int bHour = (int) Math.floor(Integer.valueOf(b) / 100);
        int aMinute = Integer.valueOf(a) % 100;
        int bMinute = Integer.valueOf(b) % 100;
        return aHour * 60 + aMinute - (bHour * 60 + bMinute);
    }

    public static void main(String[] args) {
        String[][] records = new String[][]{
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"}
        };

        List<List<String>> result = invalidBadgeRecords(new ArrayList(Arrays.asList(records)));
        for (List<String> r : result) {
            for (String r1 : r) {
                System.out.print(r1 + ",");
            }
            System.out.println("    ");
        }

    }
}
