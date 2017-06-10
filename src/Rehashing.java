/**
 * Created by xhu on 4/9/17.
 */
public class Rehashing {

    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return null;
        }

        int size = hashTable.length;

        int newSize = size * 2;
        ListNode[] rehashTable = new ListNode[size];

        for (int i = 0; i < hashTable.length; i++) {
            ListNode current = hashTable[i];
            while (current != null) {
                int index = (hashTable[i].val % newSize + newSize) % newSize;
                if (index != i) {
                    if (rehashTable[index] == null) {
                        rehashTable[index] = new ListNode(current.val);
                    } else {
                        ListNode temp = rehashTable[index];
                        while (temp.next != null) {
                            temp = temp.next;
                        }

                        temp.next = new ListNode(current.val);
                    }
                }

                current = current.next;
            }
        }

        return rehashTable;
    }


}
