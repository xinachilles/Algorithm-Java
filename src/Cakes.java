public class Cakes {
    boolean BuyCake(int target) {
        boolean[] buf = new boolean[target + 1];
        buf[0] = true;
        for (int i = 1; i <= target; i++) {
            if ((i - 6 >= 0 && buf[i - 6]) || (i - 9 >= 0 && buf[i - 9]) || (i - 20 >= 0 && buf[i - 20]))
                buf[i] = true;
        }
        return buf[target];
    }
}
