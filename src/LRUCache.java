import sun.tools.jconsole.inspector.XNodeInfo;

import java.util.HashMap;

class LRUCache {
    class ListNode{
        int value;
        int key;
        ListNode next;
        ListNode previous;

        public ListNode(int key,int value){
            this.value = value;
            this.key = key;
        }
    }
    int capacity;
    int size;
    ListNode head;
    ListNode tail;
    HashMap<Integer,ListNode> maps;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        size  = 0;
        head = new ListNode(Integer.MAX_VALUE,Integer.MAX_VALUE);
        tail = new ListNode(Integer.MAX_VALUE,Integer.MAX_VALUE);
        head.next = tail;
        tail.previous = head;
        maps = new HashMap<>();

    }

    public int get(int key) {
        if(!maps.containsKey(key)){
            return -1;
        }

        int value = maps.get(key).value;
        moveToHead(maps.get(key));
        return value;
    }

    public void put(int key, int value) {
        if(maps.containsKey(key)){
            maps.get(key).value = value;
            moveToHead(maps.get(key));

        }


        size++;
        if(size> capacity){
            int removeKey = removeTail();
            maps.remove(removeKey);

        }

        ListNode node = new ListNode(key,value);
        maps.put(key,node);
        addToHead(node);

    }

    private int removeTail(){
        ListNode remove = tail.previous;
        tail.previous = remove.previous;
        remove.previous.next = tail;

        return remove.key;
    }
    private void addToHead(ListNode node){
        ListNode next = head.next;
        head.next = node;
        node.previous = head;

        node.next = next;
        next.previous = node;
    }

    private void moveToHead(ListNode node){
        ListNode next = node.next;
        ListNode previous  = node.previous;

        next.previous = previous;
        previous.next = next;

        addToHead(node);
    }
}