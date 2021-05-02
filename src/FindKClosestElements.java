import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return result;
        }
        List<Integer> nums = new ArrayList<>();
        for(int a:arr){
            nums.add(a);
        }

        if(arr[0]>=x){
            return nums.subList(0,k);
        }else if(arr[arr.length-1]<=x){
            return nums.subList( arr.length-k ,arr.length-1);
        }else{
            int index = binarySearch(arr, x);
            int hi = Math.min(index+k-1, arr.length-1);
            int low = Math.max(index-k-1, 0);

            while(hi-low+1>k){
                if(hi >arr.length-1){
                    low++;
                }else if(low<0){
                    hi--;
                }else if (x-arr[low]<=arr[hi]-x){
                    hi--;
                }else{
                    low++;
                }
            }

            return nums.subList(low,hi+1);
        }
    }
    // find the smallest number greater or eaul to k
    private int binarySearch(int[] arr, int k){
        int start = 0;
        int end = arr.length-1;

        while(start+1<end){
            int mid = start+(end-start)/2;
            if(arr[mid] == k){
                return mid;
            }else if(arr[mid]<k){
                start  = mid+1;
            }else{
                end = mid-1;
            }
        }

        if(arr[start]>=k){
            return start;
        }

        return end;
    }
}
