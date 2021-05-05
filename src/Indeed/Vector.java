package Indeed;

public class Vector {
    class Node {
        int val;
        Node next;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index =index;
        }
    }
    private  Node head;
    private int size =0;

    public Vector(int size) {
        this.size = size;
    }

    public void set(int index, int value){

            if (index >= this.size) {
              //  throw new IndexOutOfRangeError(
              //          `Index out of range: ${index} of ${this.length}`
  //  )
            }
            Node current  = this.head;
            Node newNode = new Node(value,index);
            if (current ==null) {

                this.head = newNode;
                return;
            }

            while (current !=null && current.next!=null &&  current.next.index < index) {
                current = current.next;
            }

            if (current.next != null) {
                if (current.next.index == index) {
                    current.next.val = value;
                } else {
                    Node next = current.next;
                    newNode.next = next;
                    current.next = newNode;
                }
            } else {
                current.next = newNode;
            }
        }
    public int get(int index){

            if (index >= this.size) {
               // throw new IndexOutOfRangeError(
                 //       `Index out of range: ${index} of ${this.length}`
    //)
            }
            Node current  = this.head;
            while (current !=null && current.index != index) {
                current = current.next;
            }
            return current!=null ? current.val : 0;
        }
    @Override
    public String toString() {
        Node current = this.head;
        int index = 0;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (current != null) {
            if (current.index == index) {
                result.append(String.valueOf(current));
            } else {
               result.append("0.0");
            }
            index++;
            current = current.next;
            if (current != null) {
                result.append(",");
            }
        }
       result.append("]");
        return result.toString();
    }





}
