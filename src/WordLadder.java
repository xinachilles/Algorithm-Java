import java.util.*;

/**
 * Created by xhu on 1/4/17.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);

        int step = 1;
        while (!beginSet.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                if (endSet.contains(word)) {
                    return step;
                }

                for (int j = 0; j < word.length(); j++) {
                    for (char a = 'a'; a <= 'z'; a++) {
                        if (a == word.charAt(j)) {
                            continue;
                        }
                        String new_word =word.substring(0, j) + a + word.substring(j + 1, word.length());
                        if(wordList.contains(new_word)){
                            temp.add(new_word);
                            wordList.remove(new_word);
                        }

                    }
                }
            }
            step++;
            if(endSet.size()> temp.size()) {
                beginSet = endSet;
                endSet = temp;
            }else {
                beginSet = temp;
            }
        }
        return  -1;
    }
    }





