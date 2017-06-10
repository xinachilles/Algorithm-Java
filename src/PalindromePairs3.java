import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 9/26/16.
 */

class Tire{
    Character val;
    Tire[] next = new Tire[26];// assume the word only contains the small letter
    List<Integer> index; // if this node is the last character of the word, index should be the word index
    List<Integer> list; //  in the word, from 0 to current character -1 is palindrome, add the word index to the list

    public Tire(Character val){
        this.val = val;
        index = new ArrayList<>();
        list = new ArrayList<>();
    }

}
public class PalindromePairs3 {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Tire root = new Tire('\0');
        for (int i = 0; i < words.length; i++) {

            AddTire(root, words[i], i, words.length-1);
        }

        for (int i = 0; i < words.length; i++) {
            Search(root,words[i],i,ans);
        }

        return ans;
    }

    private Tire AddTire(Tire root, String word, int index, int i){
        if(i<0){
            return null;
        }

        if(root ==null){
            root = new Tire(word.charAt(i));
        }

        if (i == 0){
            root.index.add(index);

        }

        if(isPalidrom(word.substring(0,i))){
            root.list.add(index);
        }
        root.next[word.charAt(i)-'a'] = AddTire(root.next[word.charAt(i) -'a'],word,index, i-1);

        return root;
    }

    private void Search(Tire root, String word, int index,List<List<Integer>>result){
        List<Integer> temp = new ArrayList<Integer>();
        for(int i  =0; i<word.length(); i++){
            root =root.next[word.charAt(i)-'a'];

            if(root == null){
                return;
            }

            for(int in : root.index){
                if(in != index){
                    temp.add(in);
                }
            }
        }


            for(int i : root.list){
                if(!temp.contains(i) && i!=index){
                    temp.add(i);
                }
            }


        for(int i: temp){
            Integer[] pairs = new Integer[2];
            pairs[0] = i;
            pairs[1] = index;

            result.add(Arrays.asList(pairs));
        }

    }

    private boolean isPalidrom(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;

    }
}
