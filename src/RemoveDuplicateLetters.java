import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        int[]counts = new int[26];
        for(Character c: s.toCharArray()){
            counts[c-'a']++;
        }

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            while(!stack.isEmpty()
                    && (int)(c-'a')< (int)(stack.peek()-'a')
                    && counts[stack.peek()-'a'] >0){

                Character s1 = stack.pop();
                used[s1-'a'] = true;
                counts[s1-'a']++;

            }

            if(used[c-'a']== false){
                stack.push(c);
                used[c-'a'] = true;
                counts[c-'a']++;
            }
        }

        String result = "";
        while(!stack.isEmpty()){
            result=stack.pop()+result;
        }

        return result;



    }
}
