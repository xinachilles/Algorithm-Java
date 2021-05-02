package MOA;

public class MaximumPossibleValue {
    public int MaximumPossibleValue(int N) {
        // write your code here
        if (N == 0) {
            return 50;
        }

        StringBuilder sb = new StringBuilder();
        String num = String.valueOf(N);
        // 标记5是否被插入过
        boolean inserted = false;
        if (num.charAt(0) != '-') {
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch < '5' && !inserted) {
                    sb.append(5);
                    // 标记已经插入
                    inserted = true;
                }
                sb.append(ch);
            }

            // 没插入就插在末尾
            if (!inserted) {
                sb.append(5);
            }
        } else {
            num = num.substring(1);
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch > '5' && !inserted) {
                    sb.append(5);
                    inserted = true;
                }
                sb.append(ch);
            }

            if (!inserted) {
                sb.append(5);
            }

            sb.insert(0, '-');
        }

        return Integer.parseInt(sb.toString());
    }
}
