/**
 * Created by xhu on 7/2/17.
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }




        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);

        TreeNode right = sortedListToBST(mid.next);
        mid.next = null;
        TreeNode left = sortedListToBST(head);

        root.left  = left;
        root.right = right;

        return root;

    }

    private ListNode findMid(ListNode root){
        ListNode slow = root;
        ListNode fast = root.next;

        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }
}
