package IndeedOnsite;

import java.util.ArrayList;
import java.util.List;

class TrieNode{
    boolean hasWord;
    TrieNode[] children;

    public TrieNode(){
        this.hasWord = false;
        this.children = new TrieNode[26];
    }
    public void insert(String word, int index){
        if (index == word.length()){
            hasWord = true;
            return;
        }
        //这里居然忘了写 -'a' 太不应该了
        int pos = word.charAt(index)-'a';
        if (children[pos] == null){
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index+1);
    }
    public TrieNode find(String prefix, int index){
        if (index == prefix.length()){
            return this;
        }
        int pos = prefix.charAt(index)-'a';
        if (children[pos] == null){
            return null;
        }
        return children[pos].find(prefix, index+1);
    }
}
//就是trie和DFS的结合，感觉写的很好。
public class AutoComplete {
    TrieNode root;
    public AutoComplete(List<String> words){
        this.root = new TrieNode();
        for (String word: words) {
            root.insert(word, 0);
        }
    }
    public List<String> find(String prefix){
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        // return the last node of prefix
        TrieNode pRoot = cur.find(prefix, 0);
        helper(res, pRoot, prefix);
        return res;
    }
    public void helper(List<String> result, TrieNode root, String prefix){
        if (root == null){
            return;
        }
        if (root.hasWord){
            result.add(prefix);
        }


        for (int i = 0; i < 26; i++){
            char c = (char)('a'+i);
            helper(result, root.children[i], prefix + c);
        }
    }
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("ab");
        words.add("a");
        words.add("de");
        words.add("abde");

        AutoComplete test = new AutoComplete(words);
        String prefix = "ab";
        List<String> res = test.find(prefix);
        for(String r: res) {
            System.out.println(r);
        }
    }
}
