import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
public class LRUCache {

    public class ListNode {
        ListNode next;
        ListNode pre;
        int value;
        int key;

        public ListNode(int key,int value) {
            this.value = value;
            this.key = key;
        }


    }

    private Map<Integer, ListNode> space;
    private int maxCapcity;


    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {

        this.maxCapcity = capacity;
        space = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);

        head.next = tail;
        tail.pre = head;




    }

    public int get(int key) {
        if (!space.containsKey(key)) {
            return -1;
        }

        ListNode node = space.get(key);
        moveNodeToTail(node);
        return space.get(key).value;

    }

    public void put(int key, int value) {
        if (space.containsKey(key)) {
            space.get(key).value = value;
            moveNodeToTail(space.get(key));
            return;

        }

        ListNode insert = new ListNode(key,value);
        space.put(key, insert);
        moveNodeToTail(insert);

        if (space.size() > maxCapcity) {

            space.remove(head.next.key);
            removeHeader();

        }


    }

    private void removeHeader() {
        head.next = head.next.next;
        head.next.pre = head;
    }



    private void moveNodeToTail(ListNode node) {


        ListNode pre = node.pre;
        ListNode next = node.next;

        if (pre != null) pre.next = next;
        if (next != null) next.pre = pre;



        node.pre = tail.pre;
        node.pre.next = node;

        node.next = tail;
        tail.pre  = node;




    }
}*/
