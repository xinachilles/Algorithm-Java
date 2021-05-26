package Indeed;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (existHelper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }


        return false;
    }

    private boolean existHelper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return false;
        }


        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] = '#';
        boolean result = (existHelper(board, word, i + 1, j, index + 1)
                || existHelper(board, word, i - 1, j, index + 1)
                || existHelper(board, word, i, j + 1, index + 1)
                || existHelper(board, word, i, j - 1, index + 1));
        board[i][j] = word.charAt(index);
        return result;

    }
}
