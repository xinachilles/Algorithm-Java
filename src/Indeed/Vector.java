package Indeed;

import java.util.ArrayList;
import java.util.List;

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
    public Vector add(Vector v2){
        if (this.size != v2.size) {
        //    throw new Error('length mismatch');
        }
       Vector result = new Vector(this.size);
        for (int i = 0; i < this.size; i++) {
            result.set(i, this.get(i) + v2.get(i));
        }

        return result;
    }
    public int dot(Vector v2) {
        if (this.size != v2.size) {
           // throw new Error('length mismatch');
        }
        int result = 0;
        for (int i = 0; i < this.size; i++) {
            result += this.get(i) * v2.get(i);
        }
        return result;
    };
    public double  norm() {
        int sum = 0;
        for (int i = 0; i < this.size; i++) {
            int val = this.get(i);
            sum += val * val;
        }
        return Math.sqrt(sum);
    }
    public double SparseVectorCos(Vector v2) {
        return this.dot(v2) / (this.norm() * v2.norm());
    }





}
