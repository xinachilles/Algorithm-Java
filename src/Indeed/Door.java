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
        // people who enter with the badge
        Set<String> enter = new HashSet<>();
        // people enter without badge
        Set<String> invalidEnter = new HashSet<>();
        // people leave without badge
        Set<String> invalidExit = new HashSet();
        for (String[] record : records) {

            String name = record[0];
            String action = record[1];

            if (action.equals("enter")) {
                if (!enter.contains(name)) {
                    enter.add(name);
                } else {
                    // if people already in the enter set means he leave without the badge
                    invalidExit.add(name);
                }
            } else {
                if (enter.contains(name)) {
                    enter.remove(name);
                } else {
                    // if people is not in the set means he enter without the badge
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

    public static Map<String, List<String>> frequentAccess(String[][] records) {
        if (records == null || records.length == 0) {
            return null;
        }
        // naem -> the list of time he swipe the bagde
        Map<String, List<String>> nameToTimes = new HashMap<>();
        for (String[] record : records) {
            nameToTimes.computeIfAbsent(record[0], a -> new ArrayList<>()).add(record[1]);
        }
        Map<String, List<String>> result = new HashMap<>();
        for (String key : nameToTimes.keySet()) {
            List<String> times = nameToTimes.get(key);
            if (times.size() < 3) continue;
            Collections.sort(times, (a, b) -> timeDifference(a, b));
            // find out who swip his badge within one hour
            int start = 0;
            List<String> timeWindows = new ArrayList<String>();
            timeWindows.add(times.get(start));

            for (int i = 1; i < times.size(); i++) {
                if (Math.abs(timeDifference(times.get(start), times.get(i)))< 60) {
                    timeWindows.add(times.get(i));
                } else {
                    if(timeWindows.size()>3) break;
                    start = i;
                    timeWindows = new ArrayList<String>();
                    timeWindows.add(times.get(i));
                }
            }
            if (timeWindows.size() >= 3) {
                result.put(key, timeWindows);
            }

        }
        return result;

    }

    private static int timeDifference(String a, String b) {

        int aHour = (int) Math.floor(Integer.valueOf(a) / 100);
        int bHour = (int) Math.floor(Integer.valueOf(b) / 100);
        int aMinute = Integer.valueOf(a) % 100;
        int bMinute = Integer.valueOf(b) % 100;
        return aHour * 60 + aMinute - (bHour * 60 + bMinute);
    }

    public static void main(String[] args) {
        String[][] records1 = new String[][]{
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

        List<List<String>> result = invalidBadgeRecords(new ArrayList(Arrays.asList(records1)));
        for (List<String> r : result) {
            for (String r1 : r) {
                System.out.print(r1 + ",");
            }
            System.out.println("");
        }
        System.out.println("question 2");
        //String[][] record2 ={ {"James", "1300"}, {"Martha", "1600"}, {"Martha", "1620"}, {"Martha", "1530"}};
        String[][] record2 = {{"Paul", "1355"},
                {"Jennifer", "1910"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "1615"},
                {"John", "1640"},
                {"John", "835"},
                {"Paul", "1405"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"},

        };

        Map<String, List<String>> result2 = frequentAccess(record2);
        for(String key : result2.keySet()){
            System.out.print(key);
            System.out.print("|");
            for(String value: result2.get(key)){
                System.out.print(value);
                System.out.print("|");
            }
            System.out.println("");
        }


    }
}
