import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result  = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i<A.length && j<B.length){
            if(hasIntersect(A[i],B[j])){
                result.add(Merge(A[i],B[j]));
                i++;
                j++;
            }else if(A[i][1] < B[j][1]){
                i++;
            }else {
                j++;
            }
        }


      while(i<A.length){
        result.add(A[i]);
        i++;
    }

      while(j<B.length){
        result.add(B[j]);
        j++;
    }
      int[][] C = new int[result.size()][];

      return result.toArray(C);

    }
    private boolean hasIntersect(int[]a, int[] b){
           return Math.min(a[0],b[0])<= Math.max(a[1],b[1]);
    }
    private int[]  Merge(int[]a, int b[]){
         return new int[]{ Math.min(a[0],b[0]), Math.max(a[1],b[1])};
    }

}
