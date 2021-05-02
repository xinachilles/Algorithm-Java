import java.util.ArrayList;
import java.util.List;

public class IntersectionThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result  = new ArrayList<Integer>();
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        while(index1<arr1.length && index2<arr2.length && index3<arr3.length){
            if(arr1[index1] == arr2[index2] && arr2[index2] == arr3[index3]){
                result.add(arr1[index1]);
            }else if (arr1[index1] <= arr2[index2] && arr1[index1]<= arr3[index3]){
                index1++;
            }else if(arr2[index1] <= arr1[index2] && arr2[index1]<= arr3[index3]){
                index2++;
            }else {
                index3++;
            }
        }

        return result;
    }
}
