public class StringCompression {


    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int count = 0;
        int newIndex = 0;


        for (int i = 0; i < chars.length; i++) {
            count++;
            if (chars[i] != chars[i + 1] || i == chars.length-1) {//We have found a difference or we are at the end of array

                chars[newIndex] = chars[i]; //Update the character at start pointer
                if(count > 0) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[++newIndex] = c;
                    }
                }


                count = 0;
            }
        }



        return newIndex;

    }
}
