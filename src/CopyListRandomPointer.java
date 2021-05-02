public class CopyListRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node current = head;
        // insert the new node next to the origianl node
        while(current !=null){
            Node next = current.next;
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current =next;
        }
        // copy the ramdom
        current = head;
        while (current!=null){
            Node next = current.next.next;
            if(current.random !=null){
                current.next.random = current.random.next;
            }
            current = next;
        }

        //split the list
        Node dummy = new Node(-1);
        Node currentNew = dummy;
        current = head;

        while (current!=null){
            currentNew.next = current.next;
            current.next = current.next.next;

            current = current.next;
            currentNew = currentNew.next;
        }

        return dummy.next;
    }
}
