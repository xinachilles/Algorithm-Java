import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return null;
        }

        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> sourceMap = new HashMap<>();
        for (char target : t.toCharArray()) {
            if (!targetMap.containsKey(target)) {
                targetMap.put(target, 1);
            } else {
                targetMap.put(target, targetMap.get(target) + 1);
            }
        }

        int left = 0;
        int right = 0;
        int count = 0;
        String result = "";
        int min = Integer.MAX_VALUE;
        int size  = targetMap.size();

        for (; right < s.length(); right++) {
            Character current = s.charAt(right);

            if (targetMap.containsKey(current)) {
                targetMap.put(current, targetMap.get(current)-1);

                if(targetMap.get(current) == 0){
                    size--;
                }
            }

            while (size == 0) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                char l = s.charAt(left);

                if (targetMap.containsKey(l)) {
                    targetMap.put(l, targetMap.get(l)+1);

                    if(targetMap.get(l) > 0){
                        size--;
                    }
                }



                left++;
            }

        }

        return result;

    }
}
