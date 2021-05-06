package Indeed;

import java.sql.Array;
import java.util.*;

public class Treasure {
    /*
    *
    * 第一问就是给一个i和j，找出身边四个方向里为0的所有格子。
    * */

    public List<int[]> findLegalMoves(int[][]board, int row, int col){
        int[][]moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int rows=board.length;
        int cols = board[0].length;

        List<int[]> result = new ArrayList<>();
        for(int i = 0; i<moves.length;i++){
            int r1 = row+moves[i][0];
            int c1 = col+moves[i][1];
            if(r1>=0 && r1<rows && c1>=0 && c1<cols && board[r1][c1] ==0){
                result.add(new int[]{r1,c1});
            }
        }
        return result;
    }
    /*
    给一个二维matrix，-1代表墙，0代表路。问给定一个起点坐标为0，是否能到达所有的0
    */
    public static boolean findLegalMoves2(int[][]board, int r, int c){
        if(board == null || board.length ==0){
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        helper(board,rows, cols,r, c);
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols;j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;

    }

    private static void helper(int[][]board, int rows, int cols,int r, int c){
        if(r<0 || r>=rows || c<0 || c>=cols){
            return;
        }
        if(board[r][c] == -1){
            return;
        }
        board[r][c] =-1;
        helper(board, rows,cols,r+1,c);
        helper(board, rows,cols,r-1,c);
        helper(board, rows,cols,r,c+1);
        helper(board, rows,cols,r,c-1);
    }

    public static List<List<int[]>> findAllTreasures(int[][] board, int[] start, int[] end) {
        if(board == null || board.length ==0){
            return null;
        }


        int numberofTreasure = 0;
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j] == 1){
                    numberofTreasure++;
                }
            }
        }

        Queue<int[]> visiting = new LinkedList<>();
        // current {r, c, current treasure}
        Map<int[],List<int[]>> track = new HashMap<>();
        int[][]moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        visiting.offer(new int[]{ start[0],start[1], board[start[0]][start[1]]});
        while (!visiting.isEmpty()){
            int size=  visiting.size();
            for(int i = 0; i<size;i++){
                int[] current = visiting.poll();
                if(current[0] == end[0] && current[1] == end[1]){
                    if(current[2] == numberofTreasure){
                        continue;
                    }
                }else{
                    for(int j = 0;j<moves.length;j++){
                        int r1 = moves[j][0]+current[0];
                        int c1 = moves[j][1]+current[1];
                        if(r1>=0 && r1<board.length && c1>=0 && c1<board[0].length && board[r1][c1]!=-1){
                            int number = board[r1][c1]==1?current[2]+1:current[2];
                            board[r1][c1] = -1;
                            int[] next = new int[]{r1,c1,number};
                            if(r1 ==end[0] && c1 == end[1]){
                                if(number == numberofTreasure ){
                                    track.computeIfAbsent(next,a->new ArrayList<>()).add(current);
                                }
                            }else{
                                track.computeIfAbsent(next,a->new ArrayList<>()).add(current);
                                visiting.offer(next);
                            }


                        }
                    }
                }
            }
        }
        List<List<int[]>> result = new ArrayList<>();
        DFS(track,start,end,new ArrayList<int[]>(),result);
        return result;


    }
    private static void DFS( Map<int[],List<int[]>> track, int[] destination, int []current,List<int[]>path, List<List<int[]>> solution){
        if(current[0] == destination[0] && current[1] == destination[1]){
            solution.add(new ArrayList<>(path));
            return;
        }
        if(!track.containsKey(current)) return;
        for(int[]c : track.get(current)){
            path.add(c);
            DFS(track,destination,c,path,solution);
            path.remove(path.size()-1);
        }

    }
    public static void main(String[] args){
        int[][]board = new int[][]{ {1,  0,  0, 0, 0},
                {0, -1, -1, 0, 0},
                {0, -1,  0, 1, 0},
                {-1,  0,  0, 0, 0},
                {0,  1, -1, 0, 0},
                {0,  0,  0, 0, 0 },};
        int[] start = new int[]{5,2};
        int[] end = new int[]{2,0};
        List<List<int[]>> result = findAllTreasures(board,start, end);
        for(List<int[]> path: result){
            for(int[] p : path){
                System.out.printf("%d,%d",p[0],p[1]);
                System.out.print(",");
            }


        }

    }

}
