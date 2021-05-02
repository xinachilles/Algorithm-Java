package MOA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CountHoursVariations {
    public static int possibleHoursVariations(int A, int B, int C, int D) {
        int[] arr = new int[] { A, B, C, D };
        HashMap<Integer, HashSet<Integer>> savedHours = new HashMap<Integer, HashSet<Integer>>();
        Arrays.sort(arr);
        int count = 0;

        if (arr[0] > 2 || arr[0] == 2 && arr[1] > 4) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                boolean[] taken = new boolean[4];
                boolean first = true;
                taken[i] = true;
                taken[j] = true;
                int firstDigitOfMins = 0, secondDigitOfMins = 0;

                for (int k = 0; k < 4; k++) {
                    if (!taken[k]) {
                        if (first) {
                            firstDigitOfMins = arr[k];
                            first = false;
                        } else {
                            secondDigitOfMins = arr[k];
                        }
                        taken[k] = true;
                    }
                }
                int minutes = 10 * firstDigitOfMins + secondDigitOfMins;
                int minutesReverse = 10 * secondDigitOfMins + firstDigitOfMins;
                int hours = 10 * arr[i] + arr[j];

                if (hours < 24 && minutes < 60 || hours == 24 && minutes == 0) {
                    if (savedHours.get(hours) == null) {
                        savedHours.put(hours, new HashSet<Integer>() {
                            {
                                add(minutes);
                            }
                        });

                        count++;
                    }
                }
                if(hours<24&&minutesReverse<60|| hours == 24 && minutesReverse == 0) {
                    if (!savedHours.get(hours).contains(minutesReverse)
                            && savedHours.get(hours).contains(minutes)) {
                        count++;
                        savedHours.get(hours).add(minutesReverse);
                    }
                }
            }
        }
        return count;
    }
}
