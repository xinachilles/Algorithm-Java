import java.util.HashMap;
import java.util.Stack;

public class Excel {
    Formula[][] Formulas;

    class Formula {
        Formula(HashMap<String, Integer> c, int v) {
            val = v;
            cells = c;
        }

        //Formula, which contains two elements. First, the value of the cell
        //and a HashMap, cells.It is a list of cells on which the current cell's value is dependent.
        //This cells hashmap stores the data in the form (cellName, count).
        //cellname is the cell name the current cell depent on
        //count refers to the number of times the current cell directly or indirectly comes in the current cell's formulas.
        // e.g. C1 = C2 + C3 + C2 In this case, the frequency of C3 is 1 and that of C2 is 2.
        //--< c2,2>, <c3,1> so the value of c1 = c2's value *2+c1'value *1
        HashMap<String, Integer> cells;

        int val;
    }

    Stack<int[]> stack = new Stack<>();

    public Excel(int H, char W) {
        Formulas = new Formula[H][(W - 'A') + 1];
    }

    public int get(int r, char c) {
        if (Formulas[r - 1][c - 'A'] == null)
            return 0;
        return Formulas[r - 1][c - 'A'].val;
    }

    //For setting the value of the cell corresponding to the given row and column,
    // 1. we can simply change the value , val, in the Formulas array at the indices corresponding to the current cell.
    // 2. Further, if any new formula is applied to a particular cell, we need to remove the previously applied formulas on the same cell.
    // This is because two formulas can't be used to determine the value of a cell simultaneously.
    // Now, setting a cell to a particular value can also be seen as a formula e.g. C1 = 2. Thus, we remove all the cells in the Formulas for the current cell.
    // 3.Further, when the current cell's value is changed, all the other cells which are dependent on it also need to be evaluated in the correct order.
    // Thus, we make use of Topological Sorting starting with the current cell. We make use of a function topologicalSort(r, c) for this purpose.
    public void set(int r, char c, int v) {
        Formulas[r - 1][c - 'A'] = new Formula(new HashMap<String, Integer>(), v);
        topologicalSort(r - 1, c - 'A');
        execute_stack();
    }

    // To implement this function, firstly, we need to expand the given numbers to obtain all the cells which need to be added in the current formula.
    // We obtain them, by making use of a convert function, which extracts all these cells by doing appropriate expansions based on : values.
    // We put all these cells in the cells associated with the current cell's Formulas.
    // We also need to set the current cell's value to a new value based on the current formula added.
    // For this, we make use of calculate_sum function as discussed above. We also need to do the topological sorting and evaluate all the cells dependent on the current cell. This is done in the same manner as in the set function discussed above. We also need to return the value to which the current cell has been set.

    public int sum(int r, char c, String[] strs) {
        HashMap<String, Integer> cells = convert(strs);
        int summ = calculate_sum(r - 1, c - 'A', cells);
        set(r, c, summ);
        Formulas[r - 1][c - 'A'] = new Formula(cells, summ);
        return summ;
    }

    // In every call to this function, we traverse over all the cells in the Formulas array and further apply topological sorting to all the cells which are dependent on the current cell(row=r, column=c).
    // 1. To find these cells, we can check the cells in the Formulas associated with each cell and check if the current cell lies in it.
    // After applying Topological sorting to all these dependent cells, we put the current cell onto a stack.
    //  After doing the topological sorting, the cells on the stacks lie in the order in which their values should be evaluated given the current dependency chain
    //  based on the formulas applied.
    //  Thus, we pick up these cells one by one, and evaluate their values. To do the evaluation, we make use of
    public void topologicalSort(int r, int c) {
        for (int i = 0; i < Formulas.length; i++)
            for (int j = 0; j < Formulas[0].length; j++)
                if (Formulas[i][j] != null && Formulas[i][j].cells.containsKey("" + (char) ('A' + c) + (r + 1))) {
                    topologicalSort(i, j);
                }
        stack.push(new int[]{r, c});
    }

    public void execute_stack() {
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int r = top[0];
            int c = top[1];
            if (Formulas[r][c].cells.size() > 0) {
                int sum = calculate_sum(r, c, Formulas[r][c].cells);
                Formulas[r][c] = new Formula(Formulas[r][c].cells, sum);
            }

        }
    }

    public HashMap<String, Integer> convert(String[] strs) {
        HashMap<String, Integer> res = new HashMap<>();
        for (String st : strs) {
            if (st.indexOf(":") < 0)
                res.put(st, res.getOrDefault(st, 0) + 1);
            else {
                String[] cells = st.split(":");
                int si = Integer.parseInt(cells[0].substring(1)), ei = Integer.parseInt(cells[1].substring(1));
                char sj = cells[0].charAt(0), ej = cells[1].charAt(0);
                for (int i = si; i <= ei; i++) {
                    for (char j = sj; j <= ej; j++) {
                        res.put("" + j + i, res.getOrDefault("" + j + i, 0) + 1);
                    }
                }
            }
        }
        return res;
    }
    // In this function, we traverse over all the cells in the Formulas of the current cell(row=r, column=c), and keep on adding their values.
    // We keep on doing so till all the cells in the stack have been evaluated.
    public int calculate_sum(int r, int c, HashMap<String, Integer> cells) {
        int sum = 0;
        for (String s : cells.keySet()) {
            int x = Integer.parseInt(s.substring(1)) - 1, y = s.charAt(0) - 'A';
            sum += (Formulas[x][y] != null ? Formulas[x][y].val : 0) * cells.get(s);
        }
        //Formulas[r][c] = new Formula(cells, sum);
        return sum;
    }
}