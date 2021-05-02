public class StringEncode {
    public String encode(String input) {
        // Write your solution here
        if (input == null) {
            return input;
        }

        //find out how many space
        int number = 0;
        String target = "20%";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                number++;
                i++;
            }
        }



        int fast = input.length() - 1;


        // extend the s
        for (int i = 0; i < number * (target.length()-1) ; i++) {
            input = input + " ";
        }

        StringBuilder buffer = new StringBuilder(input);

        int slow = input.length() - 1;

        for (; fast >= 0;fast--) {
            if (Character.isWhitespace(buffer.charAt(fast) )) {

                for(int i = target.length()-1; i>=0;i--){
                    buffer.setCharAt(slow--,target.charAt(i));
                }


            } else {
                buffer.setCharAt(slow--,input.charAt(fast));

            }
        }

        return buffer.substring(slow + 1, input.length());
    }
}
