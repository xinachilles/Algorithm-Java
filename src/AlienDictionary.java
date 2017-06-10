import java.util.*;

/**
 * Created by xhu on 9/28/16.
 */
public class AlienDictionary {
//    public String alienOrder(String[] words){
//        if(words == null || words.length ==0){
//            return null;
//        }
//        int max = 0;
//        for(String w :words){
//            max = Math.max(w.length(), max);
//        }
//
//        StringBuilder result = new StringBuilder();
//        for(int i =0; i<max; i++){
//            for(int j = 0; j<words.length;j++){
//                if(i >=words[j].length()){
//                    continue;
//                }
//                if(result.toString().indexOf(words[j].charAt(j))<0){
//                    result.append(words[j].charAt(j));
//                }
//            }
//        }
//
//        return result.toString();
//    }

//    public String alienOrder(String[] words) {
//        if (words == null || words.length == 0) {
//            return null;
//        }
//
//        Map<Character, Integer> degree = new HashMap<>();
//
//        for (String w : words) {
//            for (Character c : w.toCharArray()) {
//                degree.put(c, 0);
//            }
//        }
//        Map<Character, List<Character>> graph = new HashMap<>();
//
//        for (int i = 0; i < words.length - 1; i++) {
//                int j = i+1;
//                int min = Math.min(words[i].length(), words[j].length());
//
//                for (int k = 0; k < min; k++) {
//                    if (words[i].charAt(k) != words[j].charAt(k)) {
//                        Character node = words[i].charAt(k);
//                        Character neighbor = words[j].charAt(k);
//
//                        if (!graph.containsKey(node)) {
//                            graph.put(node, new ArrayList<Character>());
//                        }
//                            graph.get(node).add(neighbor);
//                            degree.put(neighbor, degree.get(neighbor) + 1);
//                        }
//                    }
//                }
//
//
//        StringBuilder result = new StringBuilder();
//        Queue<Character> visited = new LinkedList<>();
//
//        for (Character key : degree.keySet()) {
//            if (degree.get(key) == 0) {
//                result.append(key);
//                visited.offer(key);
//            }
//        }
//        if(result.length() == degree.size()){
//            return "";
//        }
//
//
//        while (!visited.isEmpty()) {
//            Character current = visited.poll();
//                if(graph.get(current) == null){
//
//                    continue;
//                }
//
//            for (Character n : graph.get(current)) {
//                degree.put(n, degree.get(n) - 1);
//                if (degree.get(n) == 0) {
//                    visited.offer(n);
//                    result.append(n);
//                }
//
//            }
//        }
//
//        return result.toString();
//    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree = new HashMap<Character, Integer>();

        if (words == null || words.length == 0) return "";
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
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
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Stack<Character> postorder = new Stack<>();
        HashSet<Character> visited = new HashSet<>();

        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (!visited.contains(c)) {
                    DFS(graph, c, visited, postorder);
                }

            }
        }
        StringBuilder result = new StringBuilder();
        while (!postorder.isEmpty()) {
            result.append(postorder.pop());
        }

        return result.toString();
    }

    private void DFS(Map<Character, Set<Character>> graph, Character c, HashSet<Character> visited, Stack<Character> postorder) {
        visited.add(c);
        for (Character next : graph.get(c)) {
            if (!visited.contains(next)) {
                DFS(graph, next, visited, postorder);
            }
        }

        postorder.push(c);
    }

}
