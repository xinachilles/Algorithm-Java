public class StringCompression2 {
    public int compress2(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int result = 0;
        int count = 1;
        int index = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];
                result++;

                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray())
                        chars[index++] = c;
                    result++;
                }

                count = 1;
            }
        }

        chars[index++] = chars[chars.length - 1];
        result++;

        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[index++] = c;
                result++;
            }
        }
        return result;
    }
}
