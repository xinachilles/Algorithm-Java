package Google;

//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=770274&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    /*there is an image filled with 0s and 1s. There is at most one rectangle in this image filled with 0s,
    find the rectangle. Output could be the coordinates of top-left and bottom-right elements of the rectangle,
    or top-left element, width and height.
 把10秒内的数据合成一个   * */

    public static List<int[]> findOneRectangle(int[][] board){
        List<int[]> result= new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // go through the board and find first 0 itme and it is the start point of rectangle
                // then scan the board begin with this start point from left to right and from top to bottom
                // to find a all 0 recetangle
                if (board[i][j] == 0) {
                    result.add(new int[]{i,j});

                    int height = 1, width = 1;
                    while (i + height < board.length && board[i + height][j] == 0) {
                        height++;
                    }
                    while (j + width < board[0].length && board[i][j + width] == 0) {
                        width++;
                    }
                    result.add(new int[]{i+height-1,j+width-1});
                }
                if (result.size() != 0) {
                    return result;
                }
            }
        }
        return result;
    }
    /*
    for the same image, it is filled with 0s and 1s. It may have multiple rectangles filled with 0s.
    The rectangles are separated by 1s. Find all the rectangles.
*/
    public static List<List<int[]>> findMutilpeRectangle(int[][] board){
        List<List<int[]>> result= new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    List<int[]> rectangle = new ArrayList<>();
                    rectangle.add(new int[]{i,j});

                    int height = 1, width = 1;
                    while (i + height < board.length && board[i + height][j] == 0) {
                        height++;
                    }
                    while (j + width < board[0].length && board[i][j + width] == 0) {
                        width++;
                    }
                    rectangle.add(new int[]{i+height-1,j+width-1});
                    result.add(new ArrayList(rectangle));
                    // mark the rectangle to 1
                    for (int h = 0; h < height; h++) {
                        for (int w = 0; w < width; w++) {
                            board[i + h][j + w] = 1;
                        }
                    }
                }
                /*
                if (result.size() != 0) {
                    break;
                }

                 */
            }
        }
        return result;
    }

    /*the image has random shapes filled with 0s, separated by 1s. Find all the shapes. Each shape is represented by coordinates of all the elements inside.
     */
    public static List<List<int[]>> findMultipleShapes(int[][] board) {
        if (board==null || board.length ==0 || board[0].length == 0) {
            return null;
        }
        List<List<int[]>> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // first go through the board find the first 0 element and call floodFillDFS function to search its
                // neighbor ( his left, right top and bottom) and find all 0 element
                if (board[i][j] == 0) {
                    List<int[]> temp = new ArrayList<>();
                    floodFillDFS(i, j, board,temp);
                    result.add(new ArrayList<>(temp));
                }
            }
        }
        return result;
    }

    private static void floodFillDFS(int x, int y, int[][] board, List<int[]>temp) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 1) {
            return;
        }
        board[x][y] = 1;
        temp.add(new int[]{x, y});
        floodFillDFS(x + 1, y,board,temp);
        floodFillDFS(x - 1, y,board,temp);
        floodFillDFS(x, y - 1,board,temp);
        floodFillDFS(x, y + 1,board,temp);
    };

    public static void main(String[] args){
      /*
       int[][] image1 = {
               {1, 0, 1, 1, 1, 1, 1},
               {1, 0, 0, 1, 0, 1, 1},
               {0, 1, 1, 0, 0, 0, 1},
               {1, 0, 1, 1, 0, 1, 1},
               {1, 0, 1, 0, 1, 1, 1},
               {1, 0, 0, 0, 0, 1, 1},
               {1, 1, 1, 0, 0, 1, 1},
               {0, 1, 0, 1, 1, 1, 0},
       };
*/
        int[][] image1 = {
                {1,1,1,1,1,1},
                {0,0,1,0,1,1},
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,1,1}
        };
        List<List<int[]>> result = findMutilpeRectangle(image1);
        for(List<int[]> r : result){
            for(int[] r1 : r) {
                System.out.printf("%d,%d", r1[0], r1[1]);
                System.out.print(" ");
            }
            System.out.println("");
        }





    }
}

