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
        // begin with the start point and call helper function recesively to search his neighbor ( left, right top and bottom)
        // continue search if his neighbor is 0
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
        if(board[r][c] == -1 ){
            return;
        }
        board[r][c] =-1;
        helper(board, rows,cols,r+1,c);
        helper(board, rows,cols,r-1,c);
        helper(board, rows,cols,r,c+1);
        helper(board, rows,cols,r,c-1);
    }

    //

    public static List<List<int[]>> findAllTreasures(int[][] board, int[] start, int[] end) {
        if(board == null || board.length ==0){
            return null;
        }


        int numberofTreasure = 0;
        // first find how many treasure in the board
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j] == 1){
                    numberofTreasure++;
                }
            }
        }
        List<List<int[]>> result = new ArrayList<>();
        // start at the start point and call the DFS function
        // if his beighbor is 0 or 1, continue search
        // if reach the desition and find we can take all the treasure, update result
        DFS(board,end,start,numberofTreasure,new ArrayList<>(),result);

        return result;


    }
    private static void DFS( int[][]board, int[] destination,int []current,int totalTreasure,List<int[]>path, List<List<int[]>> solution
    ) {
        int r = current[0];
        int c = current[1];

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        if (board[r][c] == -1 || board[r][c] == 2) {
            return;
        }
        int temp = board[r][c];
        board[r][c] = 2;
        path.add(current);
        if (r == destination[0] && c == destination[1]) {
            // if destination has treasure
            if (totalTreasure-temp == 0) {
                // find the shortest path
                if (solution.size() > 0 && solution.get(0).size() > path.size()) {
                    solution.clear();
                }

                if(solution.size()==0 || solution.get(0).size()== path.size()) {
                    solution.add(new ArrayList<>(path));
                }
            }
            board[r][c] = temp;
            path.remove(path.size() - 1);
            return;

        }

        DFS(board, destination, new int[]{r+1,c},temp==1?totalTreasure-1:totalTreasure, path,solution);
        DFS(board, destination, new int[]{r-1,c},temp==1?totalTreasure-1:totalTreasure, path,solution);
        DFS(board, destination,new int[]{r,c-1}, temp==1?totalTreasure-1:totalTreasure, path,solution);
        DFS(board, destination, new int[]{r,c+1},temp==1?totalTreasure-1:totalTreasure, path,solution);
        board[r][c] = temp;
        path.remove(path.size()-1);
    }
    public static void main(String[] args){
        int[][]board = new int[][]{ {1,  0,  0, 0, 0},
                {0, -1, -1, 0, 0},
                {0, -1,  0, 1, 0},
                {-1,  0,  0, 0, 0},
                {0,  1, -1, 0, 0},
                {0,  0,  0, 0, 0 },};
        int[] start = new int[]{0,0};
        int[] end = new int[]{4,1};
        List<List<int[]>> result = findAllTreasures(board,start, end);
        for(List<int[]> path: result){
            for(int[] p : path){
                System.out.printf("%d,%d",p[0],p[1]);
                System.out.print("|");
            }
            System.out.println(" ");


        }

    }

}
