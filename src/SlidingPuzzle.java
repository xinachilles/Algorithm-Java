import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        if(board == null || board.length == 0){
            return 0;
        }
        int rows = board.length;
        int cols = board[0].length;
        String start = new String();
        // build the start point
        for(int i  =0;i<rows;i++){
            for(int j  = 0; j<cols; j++){
                start+=(String.valueOf(board[i][j]));
            }
        }

        String goal = "123450";
        if(start.equals(goal)) return 0;

        HashSet<String> visited = new HashSet<>();

        Queue<String> visiting = new LinkedList<>();
        visiting.offer(start);

        int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};

        int step = 0;
        while(!visiting.isEmpty()){
            int size = visiting.size();
            for(int i = 0;i<size;i++){
                String s =  visiting.poll();
                if(s.equals(goal)){
                    return step;
                }
                visited.add(s);
                int indexOfZero = s.indexOf("0");
                int y  = indexOfZero/cols;
                int x = indexOfZero%cols;
                for(int k = 0; k<4;k++){
                    int dx = x+moves[k][0];
                    int dy = y+moves[k][1];

                    if(dx>=0&&dx<cols&&dy>=0&&dy<rows){
                        int p = dy*cols+dx;
                        StringBuilder next = new StringBuilder(s);
                        next.setCharAt(indexOfZero,s.charAt(p));
                        next.setCharAt(p,'0');
                        if(!visited.contains(next.toString())){
                            visiting.offer(next.toString());
                        }
                    }

                }

            }
            step++;
        }
         return -1;
    }
}
