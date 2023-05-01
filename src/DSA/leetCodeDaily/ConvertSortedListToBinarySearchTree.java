package DSA.leetCodeDaily;
//
//
//   class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//   class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {

    }
   public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode res = new TreeNode(slow.next.val);

        ListNode rightHalf = slow.next.next;
        slow.next = null;
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(rightHalf);
        return res;
    }
}
