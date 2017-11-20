package FBOA;

import java.util.Iterator;
import java.util.TreeSet;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        TreeSet<Character> set = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!set.contains(letter)) {

                set.add(letter);
            }
        }
        StringBuilder output = new StringBuilder();
        Iterator<Character> itr = set.iterator();
        while (itr.hasNext()) {

            output.append(itr.next());
        }


        return output.toString();


    }
}
