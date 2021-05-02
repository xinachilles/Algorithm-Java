import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class test100 {
    static int shortestWordEditPath(String source, String target, String[] words) {
        // your code goes here
        if(source == null || target == null){
            return -1;
        }

        if(source.equals(target)){
            return 0;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>();
        visited.add(source);

        for(int i = 0; i<words.length;i++){
            dict.add(words[i]);
        }

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i<size;i++){
                String n = queue.poll();
                if(n.equals(target)){
                    return step;
                }
                for(int j = 0; j<n.length();j++){
                    for(char a = 'a'; a<='z';a++){
                        if(a == n.charAt(j)){
                            continue;
                        }

                        String newWord = n.substring(0,i)+a+n.substring(i+1,n.length());
                        if(!visited.contains(newWord)&& dict.contains(newWord)){
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }

}
