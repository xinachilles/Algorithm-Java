import java.util.ArrayList;
import java.util.List;

public class WordSearchII2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0)
        {
            return result;
        }

        int row = board.length;
        int col = board[0].length;

        for(int k =0; k<words.length; k++){
            for (int i = 0; i < row; i++)
            {
                for(int j = 0; j<col; j++){

                    if(words[k].charAt(0) == board[i][j]){
                        if( findWordsHelper(board,words[k],i, j,0)){
                            result.add(words[k]);
                        }
                    }
                }
            }
        }

        return result;

    }

    private boolean findWordsHelper(char[][] board, String word, int row, int col, int index)
    {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
        {
            return false;
        }

        if(index == word.length()){
            return true;
        }



        if(board[row][col] != word.charAt(index)){
            return false;
        }

        board[row][col] = '.';

        boolean result =  findWordsHelper(board, word, row + 1, col, index+1)||
                findWordsHelper(board, word, row -1 , col, index+1)||
                findWordsHelper(board, word, row, col+1,  index+1) ||
                findWordsHelper(board, word, row, col -1, index+1);

        board[row][col] = word.charAt(index);
        return result;
    }
}
