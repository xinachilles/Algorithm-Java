package Indeed;

import java.util.HashSet;
import java.util.Set;

public class Matrix {
    /*
     * 给一个N*N的矩阵，判定是否是有效的矩阵。有效矩阵的定义是每一行或者每一列的数字都必须正好是1到N的数。输出一个bool。
     * */
  public static boolean isValidMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            int rowMin = Integer.MAX_VALUE, rowMax = Integer.MIN_VALUE;
            int colMin = rowMin, colMax = rowMax;
            for (int j = 0; j < n; j++) {
                if (!rowSet.contains(matrix[i][j])) {
                    rowSet.add(matrix[i][j]);
                    rowMin = Math.min(rowMin, matrix[i][j]);
                    rowMax = Math.max(rowMax, matrix[i][j]);
                } else {
                    return false;
                }
                if (!colSet.contains(matrix[j][i])) {
                    colSet.add(matrix[j][i]);
                    colMin = Math.min(colMin, matrix[j][i]);
                    colMax = Math.max(colMax, matrix[j][i]);
                } else {
                    return false;
                }
            }
            if (rowMin != 1 || colMin != 1 || rowMax != n || colMax != n) {
                return false;
            }
        }
        return true;
    }

    /*
    * """
/*A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid
* and has to color it according to some instructions.
* Specifically, each cell can be either black or white, which we will represent as 0 for black and 1 for white.

+------------+
| 1  1  1  1 |
| 0  1  1  1 |
| 0  1  0  0 |
| 1  1  0  1 |
| 0  0  1  1 |
+------------+

For each row and column, the instructions give the lengths of contiguous runs of black (0) cells.
* For example, the instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells,
* followed later by another run of one black cell, and the rest of the row filled with white cells.

These are valid solutions: [ 1, 0, 0, 1, 0 ] and [ 0, 0, 1, 1, 0 ] and also [ 0, 0, 1, 0, 1 ]
This is not valid: [ 1, 0, 1, 0, 0 ] since the runs are not in the correct order.
This is not valid: [ 1, 0, 0, 0, 1 ] since the two runs of 0s are not separated by 1s.

Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.

Example instructions #1

matrix1 = [[1,1,1,1],
           [0,1,1,1],
           [0,1,0,0],
           [1,1,0,1],
           [0,0,1,1]]
rows1_1    =  [], [1], [1,2], [1], [2]
columns1_1 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_1, columns1_1) => True

Example solution matrix:
matrix1 ->
                                   row
                +------------+     instructions
                | 1  1  1  1 | <-- []
                | 0  1  1  1 | <-- [1]
                | 0  1  0  0 | <-- [1,2]
                | 1  1  0  1 | <-- [1]
                | 0  0  1  1 | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
  column       [2,1] | [2] |
  instructions      [1]   [1]


Example instructions #2

(same matrix as above)
rows1_2    =  [], [], [1], [1], [1,1]
columns1_2 =  [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False

The second and third rows and the first column do not match their respective instructions.


"""

    * */
/*
    matrix1 =[[1,1,1,1],
            [0,1,1,1],
            [0,1,0,0],
            [1,1,0,1],
            [0,0,1,1]]
    rows1_1    =  [], [1], [1,2], [1], [2]
    columns1_1 =  [2,1], [1], [2], [1]
*/
    public static boolean visValidNonogram(int[][] matrix, int[][] rows, int[][] cols) {
        if (matrix == null || rows == null || cols == null) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || n != rows.length || m != cols.length) {
            return false;
        }
        return isNonogramRowsValid(matrix, rows, n, m) && isNonogramColsValid(matrix, cols, n, m);

    }

    private static boolean isNonogramRowsValid(int[][] matrix, int[][] rowInstructions, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            int rowIndex = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // if there is no instruction for current row, return false
                    if (rowInstructions[i] == null || rowInstructions[i].length == 0) {
                        return false;
                    }
                    // rows[1,2], first find a single item of 1 back cell-- 0 cell
                    for (int k = 0; k < rowInstructions[i][rowIndex]; k++) {
                        if (j + k >= cols || matrix[i][j + k] != 0) {
                            return false;
                        }
                    }
                    // move next col to find another black (0) cell
                    //if(rowIndex == rowInstructions[i].length-1){
                    //  break;
                    // }
                    j += rowInstructions[i][rowIndex++];
                }
            }
            // reach at the end of row but still have instructions, ended early than expected,return false
            if (rowIndex != rowInstructions[i].length) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNonogramColsValid(int[][] matrix, int[][] colInstructions, int rows, int cols) {
        for (int j = 0; j < cols; j++) {
            int colIndex = 0;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] == 0) {
                    // if there is no instruction for current col, return false
                    if (colInstructions[j].length == 0) {
                        return false;
                    }
                    // cols[1,2], first find a single item of 1 back cell-- 0 cell in current col
                    for (int k = 0; k < colInstructions[j][colIndex]; k++) {
                        if (i + k >= rows || matrix[i + k][j] != 0) {
                            return false;
                        }
                    }
                    // if(colIndex == colInstructions[j].length-1){
                    //   break;
                    // }

                    // move next row to find another black (0) cell in current col
                    i += colInstructions[j][colIndex++];
                }
            }
            // ended early than expected
            if (colIndex != colInstructions[j].length) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1000,2,0},{-1000,2,3},{1,2,3}};
        boolean result1 = isValidMatrix(matrix);



        /*
        Example instructions #1
        */
        int[][] matrix1 = new int[][]{{1, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 0, 0}, {1, 1, 0, 1}, {0, 0, 1, 1}};
        //int[][] matrix2 =  new int[][] { {1, 1},{0, 0},{0, 0 },{1, 0 }};
        int[][] matrix3 = new int[][]{{1, 1}, {0, 0}, {0, 0}, {1, 0}};
        //int[][] rowInstruction = new int[][]{{}, {1}, {1,2}, {1}, {2}};
        //int [][] colInstruction = new int[][]{ {2,1}, {1}, {2}, {1}};
        //int[][] rowInstruction = new int[][]{ {}, {2}, {2}, {1}};
        //int[][] colInstruction = new int[][] {{1, 1}, {3}};
        int[][] rowInstruction = new int[][]{{}, {2}, {2}, {1}};
        int[][] colInstruction = new int[][]{{1, 1}, {3}};
        boolean result2 = visValidNonogram(matrix3, rowInstruction, colInstruction);
        System.out.println(result1);




    }
}
