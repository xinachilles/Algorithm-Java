package WePay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraySummnation {
    public static boolean arraySum(List<Integer> inputs, List<Integer> test ){
        if(inputs == null || test == null){
            return false;
        }
        HashSet<Integer> set = new HashSet<>(test);
        for(int number1: inputs){
            for(int number2:test){
                if(set.contains(number1+number2)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{9,6,12};
        Integer[] tests = new Integer[]{1,2,3};
        boolean result = arraySum(Arrays.asList(input),Arrays.asList(tests));
        System.out.println(result);
    }
}
