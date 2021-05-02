public class RLEIterator {
    int[] A;
    int index;
    public RLEIterator(int[] A) {
        this.A= A;
        index =0;
    }

    public int next(int n) {
        while (index<A.length && n-A[index]>=0){
             n = n-A[index];
             index = index+2;
        }
        if(index>=A.length){
            return -1;
        }

        A[index] =A[index] % n;
        return A[index+1];
    }
}
