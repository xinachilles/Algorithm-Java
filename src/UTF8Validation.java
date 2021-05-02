public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        //how many number we need to check
        int left = 0;
        for (int d : data) {
            if (left == 0) {
                if ((d >> 3) == 0b11110) left = 3; // 11110xxx
                else if ((d >> 4) == 0b1110) left = 2; // 1110xxxx
                else if ((d >> 5) == 0b110) left = 1; // 110xxxxx
                else if ((d >> 7) == 0b0) left = 0; // 0xxxxxxx
                else return false;
            } else {
                if ((d >> 6) != 0b10) return false;
                --left;
            }
        }
        return left == 0;
    }
}
