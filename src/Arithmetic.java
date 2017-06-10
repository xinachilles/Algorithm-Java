/**
 * Created by xhu on 12/17/16.
 */
public class Arithmetic {
    int number = 0;
    public int numberOfArithmeticSlice(int[] A)
    {
        if (A == null || A.length == 0)
        {
            return 0;
        }

        numberOfArithmeticSliceHelper(A, 0, -1, 0, 0);
        return number;
    }

    private void numberOfArithmeticSliceHelper(int[] A, int index, int previous, int diff, int count)
    {
        if (index == A.length)
        {
            if (count >= 3)
            {
                number++;
            }

            return;
        }

        for (int i = index; i < A.length; i++)
        {

            if (previous == -1 && index + 1 < A.length)
            {
                diff = A[index + 1] - A[index];
            }


            numberOfArithmeticSliceHelper(A, index + 1, A[i], diff, A[i] == previous + diff ? count + 1 : count);
        }
    }
}
