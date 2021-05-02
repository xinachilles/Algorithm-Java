import org.omg.PortableServer.ServantActivatorHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamChecker {
    class TrieNode{
        TrieNode[] neighor;
        boolean isWord;

        public TrieNode(){
            neighor = new TrieNode[26];
            isWord = false;

        }
    }

    class Trie{
        TrieNode root;

        public void Insert(String word){
            root = Insert(root,word,word.length()-1);
        }

        private TrieNode Insert(TrieNode node, String word, int index){
            if(node == null){
                node = new TrieNode();
            }
            if(index <0){
                node.isWord = true;
                return node;
            }

            char w = word.charAt(index);
            node.neighor[w-'a'] =   Insert(node.neighor[w-'a'],word,index-1);
            return node;
        }
        public boolean Search(String word ){
            TrieNode result = Search(root,word,0);
            if(result == null){
                return false;
            }else{
                return result.isWord;
            }
        }

        private TrieNode Search(TrieNode node, String word, int index){
            if(node == null){
                return node;
            }

            if(index == word.length()){
                return node;
            }
            if(node.isWord){
                return node;
            }
            return  Search(node.neighor[word.charAt(index)-'a'],word,index+1);
        }


    }
    Trie trie;
    StringBuilder stream;
    int max;
    public StreamChecker(String[] words) {
        trie = new Trie();
        stream = new StringBuilder();
        for(String s: words){
            trie.Insert(s);
            max = Math.max(max,s.length());
        }
    }

    public boolean query(char letter) {
        stream.insert(0,letter);;
        if(stream.length()>max){
            stream.deleteCharAt(0);
        }
        return trie.Search(stream.toString());
    }
}

