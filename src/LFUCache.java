import java.util.*;

/**
 * Created by xhu on 3/19/17.
 */
public class LFUCache {



    public class ListNode{
        int count;
        LinkedHashSet<Integer> keys;
        ListNode next;
        ListNode pre;

        public ListNode(int count){
                this.count  =count;
                keys = new LinkedHashSet<>();


        }
    }

    Map<Integer,Integer> keysMap;
    Map<Integer,ListNode> nodeMap;
    ListNode head;

    int capacity;

    public LFUCache(int capacity) {
        keysMap = new HashMap<>();
        nodeMap = new HashMap<>();

        this.capacity = capacity;

        head = new ListNode(-1);




    }

    public int get(int key) {

        if(keysMap.containsKey(key)){
            // increase the frequency of this key
            increaseCount(key,nodeMap.get(key));
            return keysMap.get(key);

        }

        return -1;

    }

    public void put(int key, int value) {
        if(keysMap.containsKey(key)){
            // increase the frequency of this key
            keysMap.put(key,value);
            increaseCount(key,nodeMap.get(key));
            return;

        }

        keysMap.put(key,value);
        insertNode(key);
        nodeMap.put(key,head.next);

        if(keysMap.size()> capacity){
            removeTheOld();

        }

    }

    private void insertNode(int key){
        if(head.next!=null && head.next.count ==1){
            head.next.keys.add(key);
            return;
        }

        ListNode temp  = new ListNode(1);
        temp.keys.add(key);
        temp.next = head.next;
        head.next = temp;
        if(temp.next!=null) temp.next.pre = temp;
        temp.pre = head;




    }
    private void removeTheOld(){
        ListNode node = head.next;

        if(node == null){
            return;
        }

        int key = 0;

        for(int k :node.keys){
            key = k;
            break;
        }
        keysMap.remove(key);
        node.keys.remove(key);

        if(node.keys.size() == 0){
            removeNode(node);
        }

        nodeMap.remove(key);

    }


    private void removeNode(ListNode node ){
        if(node == null){
            return;
        }

        ListNode pre = node.pre;
        ListNode next = node.next;

        if(pre!=null) pre.next = next;
        if(next!=null) next.pre = pre;




    }


    private void increaseCount(int key,ListNode node){
        node.keys.remove( key);


        if(node.next == null){
            node.next = new ListNode(node.count+1);
            node.next.keys.add(key);
            node.next.pre = node;

        }else if(node.next.count == node.count+1){
            node.next.keys.add(key);
        }else{
            ListNode temp = new ListNode(node.count+1);
            temp.keys.add(key);

            node.next = temp.next;
            node.next.pre = temp;
            temp.pre = node;
            node.next = temp;

        }

        nodeMap.put(key,node.next);
        if(node.keys.size() == 0){
            removeNode(node);
        }


    }
}
