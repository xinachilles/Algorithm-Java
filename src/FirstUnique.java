import java.util.HashMap;
import java.util.Map;

class FirstUnique {
    class Node{
        int value;
        Node next;
        Node previous;

        public Node(int value){
            this.value = value;

        }
    }

    Map<Integer, Integer> maps;
    Map<Integer,Node> valueToNode;

    Node head;
    Node tail;

    public FirstUnique(int[] nums) {
        head= new Node(Integer.MAX_VALUE);
        tail = new Node(Integer.MAX_VALUE);

        head.next = tail;
        tail.previous = head;

        maps = new HashMap<>();
        valueToNode = new HashMap<>();

        for(int i:nums){
            maps.put(i,maps.getOrDefault(i,0)+1);
        }

        for(int i:nums){
            if(maps.get(i) ==1){
                addToList(i);
            }
        }
    }

    private void addToList(int value){
        Node node = new Node(value);

        Node previous = tail.previous;

        tail.previous = node;
        node.next = tail;

        previous.next = node;
        node.previous = previous;

        valueToNode.put(value,node);
    }

    private void removeToList(int value){
        Node node = valueToNode.get(value);
        Node next = node.next;
        Node previous = node.previous;

        next.previous = previous;
        previous.next = next;

        valueToNode.remove(value);

    }

    public int showFirstUnique() {
        if(head.next !=tail){
            return head.next.value;
        }else{
            return -1;
        }
    }



    public void add(int value) {
        maps.put(value,maps.getOrDefault(value,0)+1);
        if(maps.get(value)>1 && valueToNode.containsKey(value)){
            removeToList(value);
        }else if(maps.get(value)==1 && !valueToNode.containsKey(value)) {
            addToList(value);
        }
    }
}