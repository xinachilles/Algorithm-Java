/**
 * Created by xhu on 6/3/17.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        int carray = 0;

        while(l1!=null || l2!=null){
            int sum = 0;
            if(l1 == null){
                sum = carray + l2.val;
                carray = sum%10;
                sum = sum/10;

                current.next  = new ListNode(sum);

            }else if(l2 == null){
                sum = carray + l1.val;
                carray = sum%10;
                sum = sum/10;

                current.next  = new ListNode(sum);
            }else{
                sum = carray + l1.val+l2.val;
                carray = sum %10;
                sum = sum/10;

                current.next = new ListNode(sum);
            }

            current = current.next;
        }

        if(carray !=0){
            current.next = new ListNode(carray);
        }

        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }

        ListNode current =  head;
        ListNode pre = null;
        while(current !=null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }
}
