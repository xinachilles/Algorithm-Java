import java.util.*;

/**
 * Created by xhu on 11/13/16.
 */
public class AlienDictionary2 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();


        if (words == null || words.length == 0) return "";
        for (String s : words) {
            for (char c : s.toCharArray()) {

                graph.put(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<Character>();
                    if (graph.containsKey(c1)) set = graph.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        graph.put(c1, set);

                    }
                    break;
                }
            }
        }
        Stack<Character> postorder = new Stack<>();
        int[] visited = new int[26];

        for(Character c : graph.keySet()){
            if (visited[c-'a'] == 0) {
                if( hasLoop(graph, c, visited, postorder)){
                    return "";
                }
            }

        }

        StringBuilder result = new StringBuilder();
        while (!postorder.isEmpty()) {
            result.append(postorder.pop());
        }

        return result.toString();
    }

    private boolean hasLoop(Map<Character, Set<Character>> graph, Character c, int[] visited, Stack<Character> postorder) {
        visited[c-'a'] = 1;
        boolean hasLoop = false;

        for (Character next : graph.get(c)) {
            if (visited[next-'a'] == 0) {
                hasLoop = hasLoop || hasLoop(graph, next, visited, postorder);
            }else if(visited[next-'a'] == 1){
                return true;
            }
        }

        postorder.push(c);
        visited[c-'a'] = 2;

        return hasLoop;
    }
}
