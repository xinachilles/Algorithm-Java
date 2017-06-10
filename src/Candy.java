/**
 * Created by xhu on 4/28/17.
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] left = new int[ratings.length];
        left[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int[] right = new int[ratings.length];
        int[] result = new int[ratings.length];
        right[ratings.length - 1] = 1;

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }

            result[i] = Math.max(right[i], left[i]);
        }

        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count = count + Math.max(right[i], left[i]);
        }

        return count;


    }
}
