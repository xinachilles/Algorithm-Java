import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

   private class Pair implements Comparable<Pair> {
        String word1;
        String word2;

        public Pair(String word1, String word2) {
            this.word1 = word1;
            this.word2 = word2;
        }

        public int compareTo(Pair other) {
            if (word1.equals(other.word1) && word2.equals(other.word2)) {
                return 0;
            }

            if (word1.equals(other.word2) && word2.equals(other.word1)) {
                return 0;
            }

            return -1;
        }
    }

    public class WordDistance {

        Map<String, List<Integer>> wordMap;
        Map<Pair, Integer> shortestMap;

        public WordDistance(String[] words) {
            wordMap = new HashMap<>();
            shortestMap = new HashMap<>();
            for(int i = 0;i<words.length;i++){

                if(!wordMap.containsKey(words[i])){
                    wordMap.put(words[i],new ArrayList<Integer>());
                }

                wordMap.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            Pair p = new Pair(word1,word2);
            if(shortestMap.containsKey(p)){
                return shortestMap.get(p);
            }

            if(!wordMap.containsKey(word1) || !wordMap.containsKey(word2)){
                return -1;
            }
            int min = Integer.MAX_VALUE;
            List<Integer> list1 = wordMap.get(word1);
            List<Integer> list2 = wordMap.get(word2);

            int i = 0, j = 0;
            while(i<list1.size() && j< list2.size()){
                if(list1.get(i) != list2.get(j)){
                    min = Math.min(min, Math.abs( list1.get(i)- list2.get(j) ));
                }

                if(list1.get(i) < list2.get(j) ){
                    i++;
                }else{
                    j++;
                }


            }

            shortestMap.put(p,min);

            return min;
        }
    }
}
