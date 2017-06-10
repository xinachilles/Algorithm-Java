/**
 * Created by xhu on 9/26/16.
 */
public class WordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0 || word1 == null || word2 == null) {
            return -1;
        }

        int indexofWord1 = -1;
        int indexofWord2 = -1;
        int previous = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                previous = indexofWord1;
                indexofWord1 = i;
            }

            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    indexofWord2 = previous;
                } else {
                    indexofWord2 = i;
                }
            }


            if (indexofWord1 >= 0 && indexofWord2 >= 0) {
                min = Math.min(min, Math.abs(indexofWord1 - indexofWord2));
            }

        }
        return min;
    }

}
