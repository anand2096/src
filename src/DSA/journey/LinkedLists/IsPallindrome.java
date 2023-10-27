package DSA.journey.LinkedLists;

public class IsPallindrome {
    private static ListNode createLinkedlist(int[] arr) {
        ListNode head=new ListNode(0);
        ListNode start=head;
        for(int i=0;i<arr.length;i++){
            ListNode newNode=new ListNode(arr[i]);
            head.next=newNode;
            head=head.next;
        }

        return start.next;

    }
    public static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int arr[]={1,2,2,1,3};
        ListNode head= createLinkedlist(arr);
        boolean ans=new IsPallindrome().isPalindrome(head);
        System.out.println(ans);
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        ListNode next=head.next;
        if(next.next==null){
            if(head.val==head.next.val)return true;
            return false;
        }
        ListNode ans=head;

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode middle=slow;
        ListNode reversedHead=reverse(middle);
        prev.next=null;
        print(head);
        ListNode rCopy=reversedHead;

        while(head!=null){
            if(head.val!=reversedHead.val){
                return false;
            }
            head=head.next;
            reversedHead=reversedHead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode h2=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode t=temp;
            temp=temp.next;
            t.next=h2;
            h2=t;
        }
        return h2;
    }
    public ListNode middle(ListNode head){

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
