import com.sun.org.apache.xerces.internal.xs.ItemPSVI;


public class StringReplaceFB {

    // in-place replace all %20 in a string to "a space"
    //abc%20def - > abc def
    //abc%20%20%2 ->abc  %2
    public String replace(String s, String original, String replaceBy) {

        //1. if replaceBy.length <= original.length, no need increase the size
        // two point, the slow point is buffer the result , so all the letter left the slow point is the result
        // fast point, index to scan the whole string
        char[] temp = new char[s.length()];
        if (original.length() >= replaceBy.length()) {


            int slow = 0;
            for (int fast = 0; fast < s.length(); fast++) {
                // if find original string, copy the "replaceby" start with slow
                if (s.charAt(fast) == original.charAt(0)
                        && fast + original.length() <= s.length()
                ) {
                    int i = fast;
                    for (; i < fast + original.length(); i++) {
                        if (s.charAt(i) != original.charAt(i - fast)) {
                            break;
                        }
                    }
                    // find the orignal
                    if (i == fast + original.length()) {
                        fast = i - 1;
                        i = 0;
                        for (; i < replaceBy.length(); i++) {
                            temp[slow++] = replaceBy.charAt(i);
                        }
                    }

                } else {
                    temp[slow++] = s.charAt(fast);
                }
            }
        } else {

            // 2. if orginal < replaceby
            // scan the s from left to right to find out how many original in the s  == n
            // extent the s.length to s.length  + n*(replaceby - original)
            // put the slow at the end of new string
            //
            int number = 0;
            // howm many original string in the s
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == original.charAt(0) && i + original.length() <= s.length()) {
                    int j = i;
                    for (; j - i < original.length(); j++) {
                        if (s.charAt(j) != original.charAt(j - i)) {
                            break;
                        }
                    }

                    if (j - i == original.length()) {
                        number++;
                        i = j - 1;
                    }

                }
            }

            temp = new char[number * (replaceBy.length() - original.length()) + s.length()];
            int slow = temp.length - 1;
            for (int fast = s.length() - 1; fast >= 0; fast--) {
                if (s.charAt(fast) == original.charAt(original.length() - 1)
                        && fast - original.length() >= 0
                ) {
                    int i = fast;
                    for (; i - fast + original.length() - 1 >= 0; i--) {
                        if (s.charAt(i) != original.charAt(i - fast + original.length() - 1)) {
                            break;
                        }
                    }
                    // find the orignal
                    if (i == fast - original.length()) {
                        fast = i + 1;
                        i = replaceBy.length() - 1;
                        for (; i >= 0; i--) {
                            temp[slow--] = replaceBy.charAt(i);
                        }
                    }

                } else {
                    temp[slow--] = s.charAt(fast);
                }
            }

        }

        return new String(temp);
    }


}
