import java.util.*;

public class RearrangeStringKDistanceApart2 {

    public String rearrangeString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        Map<Character, Integer> maps = new HashMap<>();
        for (char t : S.toCharArray()) {
            maps.put(t, maps.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Character> letterQueue = new PriorityQueue<>((a, b) -> maps.get(b) - maps.get(a));
        letterQueue.addAll(maps.keySet());

        int count = 0;
        String result = "";
        while (!letterQueue.isEmpty()) {
            List<Character> Letterlist = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                Character c = letterQueue.poll();
                result = result + c;
                maps.put(c, maps.get(c) - 1);
                if (maps.get(c) > 0) Letterlist.add(c);
                if (letterQueue.isEmpty()) {
                    if (i != 1&& result.length() != S.length()) {
                        return "";
                    }
                    break;
                }
            }
            if (!Letterlist.isEmpty()) {
                letterQueue.addAll(Letterlist);
            }
        }

        return result;
    }
}

