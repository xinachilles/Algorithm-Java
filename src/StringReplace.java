public class StringReplace {

    public String replace(String input, String source, String target) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return input;
        }

        if(source.length()>=target.length()){
            return replaceWithShort(input,source,target);
        }else{
            return replaceWithLonger(input,source,target);
        }
    }

    public String replaceWithLonger(String input, String source, String target) {
        if (input == null) {
            return null;
        }

        //find how many pattern in the s
        int number = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == source.charAt(0) && i + source.length() <= input.length() && input.substring(i, i + source.length()).equals(source)) {
                number++;
                i = i+source.length()-1;
            }
        }

        int length = number * (target.length() - source.length()) + input.length();
        int fast = input.length() - 1;


        // extend the s
            for (int i = 0; i < number * (target.length() - source.length()); i++) {
                input = input + " ";
            }

        StringBuilder buffer = new StringBuilder(input);

        int slow = input.length() - 1;

        for (; fast >= 0;) {
            if (buffer.charAt(fast) == source.charAt(source.length() - 1) && fast - source.length() + 1 >= 0 && buffer.substring(fast - source.length() + 1, fast + 1).equals(source)) {

                for(int i = target.length()-1; i>=0;i--){
                    buffer.setCharAt(slow--,target.charAt(i));
                }
                fast = fast - source.length();

            } else {
                buffer.setCharAt(slow--,input.charAt(fast--));

            }
        }

        return buffer.substring(slow + 1, input.length());
    }

    public String replaceWithShort(String input, String source, String target) {
        // Write your solution here
        int slow = 0;
        int fast = 0;
        StringBuilder buffer = new StringBuilder(input);

        for(; fast<input.length();){
            if(buffer.charAt(fast) == source.charAt(0) && fast+source.length() <= input.length() && buffer.substring(fast,fast+source.length()).equals(source)){

                for(int i = 0; i<target.length();i++){
                    buffer.setCharAt(slow++,target.charAt(i));

                }

                fast = fast+source.length();
            }else{
                buffer.setCharAt(slow++,input.charAt(fast++));
            }
        }

        return buffer.substring(0,slow);
    }


}