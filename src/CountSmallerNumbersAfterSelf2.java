import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfterSelf2 {
    class Number{
        int index;
        int value;

        public Number(int value, int index){
            this.index = index;
            this.value = value;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Number> numList = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            numList.add(new Number(nums[i],i));
        }
        int[] smaller = new int[nums.length];
        mergeSort(numList,smaller);
        List<Integer> result = new ArrayList<>();
        for(int s:smaller){
            result.add(s);
        }
        return result;

    }

    private List<Number> mergeSort(List<Number> array, int[]smaller){
        if(array.size()<=1){
            return array;
        }
        int mid = array.size()/2;
        List<Number> left = mergeSort(array.subList(0,mid),smaller);
        List<Number> right = mergeSort(array.subList(mid,array.size()),smaller);
        return merge(left,right,smaller);
    }

    private List<Number> merge(List<Number>left, List<Number>right, int[] smaller){
        List<Number> result = new ArrayList<>();
        int l = 0;
        int r =0;
        while (l<left.size() || r<right.size()){
            if(r>=right.size() || left.get(l).value<=right.get(r).value ) {
                result.add(left.get(l));
                smaller[left.get(l).index] += r; // left and right are sorted and right[ 0-r-1] <left[l]
                l++;
            }else{
                result.add(right.get(r));
                r++;
            }
        }
        return result;

    }


}
