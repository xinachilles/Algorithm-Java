public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode tail = head;
        for(int i = 0; i<k-1 &&tail!=null;i++){
            tail = tail.next;
        }
        ListNode newHead = reverseKGroup(tail.next,k);
        ListNode pre = null;
        ListNode copyHead= head;
        while (head !=null && head !=tail){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        copyHead.next = newHead;

        return head;
    }
}
