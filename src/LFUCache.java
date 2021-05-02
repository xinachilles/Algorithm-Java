import sun.tools.jconsole.inspector.XNodeInfo;

import java.util.*;

/**
 * Created by xhu on 3/19/17.
 */
public class LFUCache {

class Node{
    LinkedHashSet<Integer> keys;
    int frequency;// the freq in the list;
    Node pre;
    Node next;
    public  Node(int frequency){
        this.frequency = frequency;
        keys = new LinkedHashSet<>();
    }
}
    Map<Integer, Integer> maps; // key to value
    Map<Integer,Node> keyTonode; // key to node
    int capacity;
    Node head;


    public LFUCache(int capacity) {
        maps = new HashMap<>();
        keyTonode = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1);
    }

    public int get(int key) {
        int value = -1;
        if(maps.containsKey(key)){
            value= maps.get(key);
            increaseFreq(key);

        }
        return value;
    }

    public void put(int key, int value) {

        if(maps.containsKey(key)){
            increaseFreq(key);
            maps.put(key,value);
        }else{
            if(maps.keySet().size() ==capacity){
               removeLessFreqUsed();
            }
            maps.put(key,value);
            insert(key);
        }

    }

    private void removeLessFreqUsed(){
        if(head.next!=null && head.next.keys.size()>0){
            int key = 0;
            for(int k: head.next.keys){
                key = k;
                break;
            }

            head.next.keys.remove(key);
            maps.remove(key);
            keyTonode.remove(key);
            if(head.next.keys.size()==0){
                deleteNode(head.next);
            }
        }

    }
    private  void insert(int key){
        if(head.next!=null && head.frequency == 1){
            head.keys.add(key);
            keyTonode.put(key,head.next);
        }else{
            Node n = new Node(1);
            n.keys.add(key);
            n.next = head.next;
            head.next = n;
            n.pre = head;
            if(n.next!=null) {
                n.next.pre = n;
            }
            keyTonode.put(key,n);
        }
    }
    // increase the key's frequency
    private void increaseFreq(int key){

        Node n = keyTonode.get(key);
        // remove the key from current node
        n.keys.remove(key);
        // if next node is null or next node's frequency != current node +1
        if(n.next == null|| n.frequency+1<n.next.frequency){
            Node next = new Node(n.frequency+1);
            next.keys.add(key);
            keyTonode.put(key,next);
            n.next = next;
            next.pre = n;

        }else if(n.frequency+1 == n.next.frequency){
            n.next.keys.add(key);
             keyTonode.put(key, n.next);
        }


        if(n.keys.size() ==0){
           deleteNode(n);
        }

    }

    private void deleteNode(Node n){
        // only will delete the node when the node.keys.size == 0
        Node pre = n.pre;
        Node next = n.next;

        pre.next = next;
        if(next !=null) {
            next.pre = pre;
        }
    }




}
