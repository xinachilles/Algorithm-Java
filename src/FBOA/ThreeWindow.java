package FBOA;

/**
 * Created by xhu on 7/10/17.
 */
public class ThreeWindow {
    public int find(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] left = new int[arr.length];
        int lSum = 0;

        for (int i = 0; i < arr.length; i++) {
            lSum += arr[i];
            if (i < k) {
                left[i] = 0;
            } else {

                lSum -= arr[i - k];
                if (i == 0) {
                    left[0] = lSum;
                } else {
                    arr[i] = Math.max(left[i - 1], lSum);
                }

            }

            int[] right = new int[arr.length];
            int rSum = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                rSum += arr[i];
                if (arr.length - j + 1 < k) {
                    right[j] = 0;
                } else {
                    rSum -= arr[j + k];
                    if (j == arr.length - 1) {
                        right[j] = arr[arr.length - 1];
                    } else {
                        right[j] = Math.max(right[j + 1], rSum);
                    }
                }
            }

            // for(int )

        }

        return 0;
    }
}
