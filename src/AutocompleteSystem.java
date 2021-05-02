import java.util.*;

public class AutocompleteSystem {
    // we build a trie
    // the node should have children node
    // the node also has a map of sentence to count
    class Pair {
        String sentence;
        int count;
        public Pair(String s, int c) {
            this.sentence = s; this.count = c;
        }
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;

        public  TrieNode(){
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }

    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void add(String s,int count){
            root = add(root,s,count,0);
        }

        private TrieNode add(TrieNode root, String s, int count,int index){
            if(root == null){
                root = new TrieNode();
            }

            if(index == s.length()){
                root.isWord = true;
                return root;
            }

            TrieNode result = add(root.children.get(s.charAt(index)),s, count,index+1);
            root.counts.put(s, root.counts.getOrDefault(s,0)+count);
            root.children.put(s.charAt(index),result);
            return root;

        }

        public TrieNode search(TrieNode root, String s){
           return search( root,s, 0);

        }

        private TrieNode search(TrieNode root, String s,int index){
            if(root == null){
                return root;
            }
            if(index == s.length()){
                return root;
            }
            return search(root.children.get(s.charAt(index)),s,index+1);
        }


    }
    Trie trie;
    String prefix;
    TrieNode curr;
    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        prefix = "";
        curr = trie.root;

        for (int i = 0; i < sentences.length; i++) {
            trie.add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#'){
            trie.add(prefix,1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix = prefix+c;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.sentence.compareTo(b.sentence) : b.count - a.count));


        List<String> res = new ArrayList<String>();
        TrieNode node = trie.search(curr, String.valueOf(c));
        if(node  == null) return new ArrayList<>();

        for (String s : node.counts.keySet()) {
            pq.add(new Pair(s, node.counts.get(s)));
        }
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().sentence);
        }
        return res;

    }


}
