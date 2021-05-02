package MOA;

public class FairIndex {


    public int fairIndex(int a[], int b[]) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];
        }
        int count = 0;
        int tempA = a[0];
        int tempB = b[0];
        for (int i = 1; i < a.length; i++) {
            if (i != 1 && tempA == tempB && 2 * tempA == sumA && 2 * tempB == sumB) {
                count++;
            }
            tempA += a[i];
            tempB += b[i];
        }
        return count;
    }
}
