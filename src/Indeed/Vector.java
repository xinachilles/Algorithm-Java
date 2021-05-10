package Indeed;

import java.util.ArrayList;
import java.util.List;

public class Vector {
    class IndexOutOfRangeError extends Exception{
        public IndexOutOfRangeError(String errorMessage){
            super(errorMessage);
        }
    }
    class Node {
        double val;
        Node next;
        int index;

        public Node(double val, int index) {
            this.val = val;
            this.index =index;
        }
    }
    private  Node head;
    private int size =0;

    public Vector(int size) {
        this.size = size;
    }

    public void set(int index, double value) throws IndexOutOfRangeError {

            if (index >= this.size) {
                throw new IndexOutOfRangeError("Index out of range:"+ String.valueOf(index)+"of"+String.valueOf(this.size));
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
    public double get(int index) throws IndexOutOfRangeError {

            if (index >= this.size) {
                throw new IndexOutOfRangeError("Index out of range:" + String.valueOf(index) + "of" + String.valueOf(this.size));

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
        for(int i = 0; i<this.size;i++) {
                if (current ==null || i != current.index) {
                    result.append("0" );
                } else if (i == current.index) {
                    result.append(String.valueOf(current.val));
                    current = current.next;
                }

            if(i!=this.size-1){
                result.append(",");
            }
        }


        result.append("]");
        return result.toString();
    }
    public Vector add(Vector v2) throws IndexOutOfRangeError {
        if (this.size != v2.size) {
        //    throw new Error('length mismatch');
        }
       Vector result = new Vector(this.size);
        for (int i = 0; i < this.size; i++) {
            result.set(i, this.get(i) + v2.get(i));
        }

        return result;
    }
    public int dot(Vector v2) throws IndexOutOfRangeError {
        if (this.size != v2.size) {
           // throw new Error('length mismatch');
        }
        int result = 0;
        for (int i = 0; i < this.size; i++) {
            result += this.get(i) * v2.get(i);
        }
        return result;
    };
    public double  norm() throws IndexOutOfRangeError {
        int sum = 0;
        for (int i = 0; i < this.size; i++) {
            double val = this.get(i);
            sum += val * val;
        }
        return Math.sqrt(sum);
    }
    public double cos(Vector v2) throws IndexOutOfRangeError {
        return this.dot(v2) / (this.norm() * v2.norm());

    }

    public static void main(String[] args) throws IndexOutOfRangeError {
        Vector v = new Vector(100);
        v.set(0,1.0);
        v.set(3,2.0);
        v.set(80,-4.5);

        System.out.println(v.get(80));
        System.out.println(v.get(50));
       // System.out.println(v.get(101));
        System.out.println(v.toString());

        Vector v1 = new Vector(5);
        v1.set(0,4.0);
        v1.set(1, 5.0);

        Vector v2 = new Vector(5);
        v2.set(1, 2.0);
        v2.set(3, 3.0);

        Vector v3 = new Vector(2);
        System.out.println(v1.add(v2));//should print [4.0, 7.0, 0.0, 3.0, 0.0]
       // System.out.println(v1.add(v3)); //error -- vector lengths don’t match

        System.out.println(v1.dot(v2)); //should print 10
       // System.out.println(v1.dot(v3));//error -- vector lengths don’t match
        System.out.println(v1.cos(v2));//should print 0.433
        /*
        print v1.cos(v3) //error -- vector lengths don’t match


        Formulae:
        Addition
        a.add(b) = [a[0]+b[0], a[1]+b[1], a[2]+b[2], ...]
        Dot product
        a.dot(b) = a[0]*b[0] + a[1]*b[1] + a[2]*b[2] + ...

        Cosine
        a.cos(b) = a.dot(b) / (norm(a) * norm(b))
        */

    }



}
