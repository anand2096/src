package DSA.journey.LinkedLists;

public class OddEvenLinkedLis {

    public static void main(String[] args) {
        int arr[]={1,2};
        ListNode head= createLinkedlist(arr);
        ListNode ans=new OddEvenLinkedLis().oddEvenList(head);
        print(ans);
    }
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
    public ListNode oddEvenList(ListNode head) {


        ListNode odd=head;
        ListNode h1=odd;
        ListNode even=new ListNode(0);
        ListNode h2=even;
        ListNode prev=odd;
        while(odd!=null && odd.next!=null){
            even.next=odd.next;
            if(odd.next!=null)
            odd.next=odd.next.next;
            prev=odd;
            odd=odd.next;
            even=even.next;
        }
        even.next=null;
        while(prev.next!=null){
            prev=prev.next;
        }
        prev.next=h2.next;

        return h1;
    }
}
