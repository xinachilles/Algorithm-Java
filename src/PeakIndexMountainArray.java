public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }

        int start = 0;
        int end = A.length-1;

        while(start+1<end){
            int mid = start+(end-start)/2;

            if(isPeak(A,mid)){
                return mid;
            }else if( mid+1<A.length && A[mid] <A[mid+1]){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(isPeak(A,end)){
            return end;
        }

        if(isPeak(A,start)){
            return start;
        }

        return -1;
    }

    private boolean isPeak(int[]A, int i){
        if(i<=0|| i>=A.length-1){
            return false;
        }

        if(A[i] >A[i-1] && A[i]>A[i+1]){
            return true;
        }

        return false;

    }
}
