package Indeed;

import org.hamcrest.core.Is;

import java.util.HashMap;
import java.util.Map;

public class Tile {
    public static boolean IsCompleteHead(String tile){
        Map<Character,Integer> counts = new HashMap<>();
        for(char c: tile.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }
        for(char key: counts.keySet()){
            if(counts.get(key)<2){
                return false;
            }else if(counts.get(key)>2){
                if((counts.get(key)-2)%3 !=0 && counts.get(key)%3!=0){
                    return false;
                }
            }
        }
        return true;
    }
    public static int disappear(int[][] grid, int r, int c){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return helper(grid,visited,r,c,grid[r][c]);
    }
    private static int helper(int[][]grid, boolean[][] visited, int r,int c,int value ){
        if(r<0||r>=grid.length || c<0|| c>=grid[0].length || visited[r][c] || grid[r][c] !=value){
            return 0;
        }
        visited[r][c] = true;
        return 1+helper(grid,visited,r+1,c,value)+helper(grid,visited,r-1,c,value)+helper(grid,visited,r,c-1,value)+
                helper(grid,visited,r,c+1,value);
    }

    /*3. 第一题的follow-up。
A run is a series of three consecutive tiles, like 123, 678, or 456. 0 counts as the lowest tile, so 012 is a valid run, but 890 is not. A complete hand now consists of a pair, and any number (including zero) of triples and/or three-tile runs. Write a function that returns whether or not a hand is complete under these new rules.

    * */
    public static void main(String[] args) {
        /*
        System.out.println(IsCompleteHead("11122"));
        System.out.println(IsCompleteHead("12121"));
        System.out.println(IsCompleteHead("11111555"));
        System.out.println(IsCompleteHead("123456"));

         */
        int[][]grid = new int[][]{{4,4,4,4},
                {3,6,6,4},
                {5,5,5,5},
                {1,0,0,0}};
        System.out.println(disappear(grid,0,0));
        System.out.println(disappear(grid,2,1));
        System.out.println(disappear(grid,3,1));


    }
}
