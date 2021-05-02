import java.util.LinkedList;
import java.util.Queue;

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {

        String result = "";
        int sourceRow = 0;
        int sourceCol = 0;
        for (char t : target.toCharArray()) {
            int postion = t - 'a';
            int targetRow = postion / 5;
            int targetCol = postion % 5;

            // U, L, D R
            if (targetRow > sourceRow) {
                result = result + helper(targetRow - sourceRow, "U");
            }
            if (targetCol > sourceCol) {
                result = result + helper(targetCol - sourceCol, "L");
            }
            if (targetRow < sourceRow) {
                result = result + helper(sourceRow - targetRow, "D");
            }
            if (targetCol < sourceCol) {
                result = result + helper(sourceCol - targetCol, "R");
            }

            result = result + "!";
            sourceRow = targetRow;
            sourceCol = targetCol;

        }
         return result;
    }


   private String helper(int count, String op){
       String result = "";
        for(int i =0; i<count;i++){
           result = result+op;
       }
        return result;
   }
}
