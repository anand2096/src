package DSA.journey.LinkedLists;


  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
public class ReverserLinkList2 {
    public static void main(String[] args) {

        ListNode f=new ListNode(1);
        f.next=new ListNode(2);
        f.next.next=new ListNode(3);
        f.next.next.next=new ListNode(4);
        f.next.next.next.next=new ListNode(5);
        ListNode head=new ReverserLinkList2().reverseBetween(f,1,5);
        print(head);
    }
    public ListNode reverseBetween(ListNode head, int B, int C) {
        int bCopy=B;
        ListNode temp=head;
        ListNode prev=head;
        for(int i=1;i<B;i++){
            prev=temp;
            temp=temp.next;
        }
        ListNode backNode=temp;
        ListNode h2=null;
        while(temp!=null && B<=C ){
            ListNode t=temp;
            temp=temp.next;
            t.next=h2;
            h2=t;
            B++;

        }
        backNode.next=temp;
        if(bCopy==1)return  h2;
        prev.next=h2;
        return head;
    }

    public static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("");
    }
}
