import java.util.*;

/**
 * Created by xhu on 10/13/16.
 */
public class WordLadderII {
    private  int level = 0;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> wordMap = new HashMap<>();
        List<List<String>> reuslt = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return reuslt;
        }

       // BFS(beginWord, endWord, wordMap, wordList);


        List<String> solution = new ArrayList<>();
        solution.add(0, endWord);
        DFS(endWord, beginWord, wordMap, reuslt, solution,level);
        return reuslt;
    }

    private void BFS(String beginWord, String endWord, Map<String, Set<String>> wordMap, List<String> wordList) {
        Queue<String> toVisit = new LinkedList<>();
        toVisit.offer(beginWord);
        Set<String> visted = new HashSet<>();
        wordMap.put(endWord, new HashSet<>());


        int step = 0;
        boolean find = false;

        while (!toVisit.isEmpty() && ! find) {

            int size = toVisit.size();
            level++;
            for (int i = 0; i < size; i++) {

                String currentWord = toVisit.poll();
                visted.add(currentWord);
                for (int j = 0; j < currentWord.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] temp = currentWord.toCharArray();
                        if (temp[j] == c) {
                            continue;
                        }
                        temp[j] = c;
                        String newWord = new String(temp);

                        if (newWord.equals(endWord)) {
                            find = true;

                        }

                        if (newWord.equals(endWord) || wordList.contains(newWord) && !visted.contains(newWord)) {

                            if (!wordMap.containsKey(newWord)) {
                               // wordMap.put(newWord, new ArrayList<String>());
                            }

                            if (!wordMap.get(newWord).contains(currentWord)) {
                                wordMap.get(newWord).add(currentWord);
                            }


                            toVisit.offer(newWord);
                        }


                    }
                }


            }


        }
    }

    private void DFS(String currentWord, String
            beginWord, Map<String, List<String>> wordMap, List<List<String>> reuslt, List<String> solution,int level) {
        if (currentWord.equals(beginWord) && level == 0) {

            reuslt.add(new ArrayList<>(solution));

            return;
        }

        if (!wordMap.containsKey(currentWord) || wordMap.get(currentWord) == null) {

            return;
        }


        for (String n : wordMap.get(currentWord)) {
            solution.add(0, n);
            DFS(n, beginWord, wordMap, reuslt, solution,level-1);
            solution.remove(0);
        }


    }
}
