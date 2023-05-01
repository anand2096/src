package DSA.leetCodeDaily;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}

public class LinkedListCycleII {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
            if(fast==slow) {
                slow=head;
                while (slow!=fast){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;

            }
        }
        return null;
    }
}
