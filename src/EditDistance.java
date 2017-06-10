/**
 * Created by xhu on 10/23/16.
 */
public class EditDistance {
    public int minDistiance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        int[][] dy = new int[word1.length() + 1][word2.length() + 1];
        // dy[i][j] means the min distance change from word1(0..i) to word2(0..j)

        for (int i = 0; i < word1.length(); i++) {
            dy[i + 1][0] = dy[i][0] + 1;
        }

        for (int j = 0; j < word2.length(); j++) {
            dy[0][j + 1] = dy[0][j] + 1;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dy[i + 1][j + 1] = dy[i][j];
                } else {
                    int insert = dy[i][j - 1] + 1;
                    int delete = dy[i - 1][j] + 1;
                    int replace = dy[i - 1][j - 1] + 1;

                    dy[i + 1][j + 1] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }

        return dy[word1.length()][word2.length()];
    }

}
