import java.util.*;

/**
 * Created by xhu on 1/4/17.
 */
public class WordLadder {



    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        Set<String> dict = new HashSet<>(wordList);
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        startSet.add(beginWord);
        endSet.add(endWord);

        dict.remove(beginWord);
        dict.remove(endWord);

        return BFS(2, dict, startSet, endSet);


    }

    private int BFS(int step, Set<String> wordList, Set<String> startSet, Set<String> endSet) {

        Set<String> nextStep = new HashSet<>();
        for (String word : startSet) {

            List<String> next = GenerateNext(word, wordList);
            for (String n : next) {
                if (endSet.contains(n)) {
                    return step;
                }

                nextStep.add(n);
            }

        }

        if (nextStep.size() == 0) return 0;

        if (nextStep.size() <= endSet.size()) {
            return BFS(step + 1, wordList, nextStep, endSet);
        } else {
            return BFS(step + 1, wordList, endSet, nextStep);
        }

    }

    private List<String> GenerateNext(String word, Set<String> wordList) {
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }

                String newWord = replace(word, i, c);
                if (wordList.contains(newWord)) {
                    wordList.remove(newWord);
                    result.add(newWord);
                }


            }
        }
        return result;
    }


    private String replace(String word, int index, char c) {
        char[] temp = word.toCharArray();
        temp[index] = c;
        return String.valueOf(temp);

    }
    }



