package WePay;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SldingBlock {
    public static int slidingPuzzle(int[][] board) {
        if(board == null || board.length == 0){
            return 0;
        }
        int rows = board.length;
        int cols = board[0].length;
        String start = "";
        // build the start point
        for(int i  =0;i<rows;i++){
            for(int j  = 0; j<cols; j++){
                start+=(char)(board[i][j]+'a');

            }
        }
        System.out.println(start);

        String goal = "";
        for(int i = 0; i<rows*cols;i++){
            goal+=(char)(i+'a');

        }

        System.out.println(goal);
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
                int indexOfA = s.indexOf("a");
                int y  = indexOfA/cols;
                int x = indexOfA%cols;
                for(int k = 0; k<4;k++){
                    int dx = x+moves[k][0];
                    int dy = y+moves[k][1];

                    if(dx>=0&&dx<cols&&dy>=0&&dy<rows){
                        int p = dy*cols+dx;
                        StringBuilder next = new StringBuilder(s);
                        next.setCharAt(indexOfA,s.charAt(p));
                        next.setCharAt(p,'a');
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

    public static void main(String[] args) {
        int[][]board = new int[][]{{1,6,3},{8,7,2},{4,0,5}};
        int result = slidingPuzzle(board);
        System.out.println(result);
    }
}
