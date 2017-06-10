import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 9/18/16.
 */
public class FourSum {
    // 4 sum
// A: the output can be duplicated, the input contain duplicated number? the input is sorted?

    /*public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // not for this: the simplest method is use 4 for loops but we can use one hashtable to replace one for loop. so we can get more fast code but the prices you pay is the more memory space
        // 1. sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //calculated the sum of first 2
                int firstTwo = nums[i] + nums[j];
                // since the array is sorted, we can use two point,one in the beginning and another one in the end. base on the total number, the move the beginning or ending point.
                int start = j + 1;
                int end = nums.length - 1;

                while (start < end) {
                    List<Integer> solution = new ArrayList<Integer>();
                    int sum = firstTwo + nums[start] + nums[end];
                    if (sum == target) {
                        solution.add(i);
                        solution.add(j);
                        solution.add(start);
                        solution.add(end);
                        if (!result.contains(solution)) {
                            result.add(solution);
                        }
                        end--;
                        start++;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }*/

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            int first = nums[i];
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j <= nums.length - 3; j++) {
                int second = nums[j];
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int start = j + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[start] + nums[end] + first + second;
                    if (sum == 0) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(first);
                        solution.add(second);
                        solution.add(nums[i]);
                        solution.add(nums[j]);

                        result.add(solution);


                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }

                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }

                        start++;
                        end--;
                    } else if (sum < 0) {
                        start++;
                    } else {
                        end--;
                    }

                }

            }
        }

        return result;
    }

}
