package DSA.journey.LinkedLists;

public class KthNodeFromMiddle {
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
        int arr[]={725 , 479 , 359 , 963 , 465 , 706 , 146 , 282 , 828 , 962};
        ListNode head= createLinkedlist(arr);
        int ans=new KthNodeFromMiddle().solve(head,2);
        System.out.println(ans);
    }
    public int solve(ListNode head, int B) {

        ListNode mid=middle(head);
        mid.next=null;
        ListNode h2=reverse(head);
        while(h2!=null && B>0){
            h2=h2.next;
            B--;
        }
        if(h2==null)return -1;
        return h2.val;
    }
    public ListNode reverse(ListNode root){
        ListNode h1=root;
        ListNode h2=null;
        while(h1!=null){
            ListNode temp=h1;
            h1=h1.next;
            temp.next=h2;
            h2=temp;
        }
        return h2;
    }
    public ListNode middle(ListNode root){
        ListNode slow=root;
        ListNode fast=root;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
