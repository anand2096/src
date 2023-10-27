package DSA.journey.LinkedLists;

public class Merge2SortedList {
    public static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ListNode h1=new ListNode(5);
        h1.next=new ListNode(5);
        h1.next.next=new ListNode(5);
        h1.next.next.next=new ListNode(5);
        h1.next.next.next.next=new ListNode(5);
        h1.next.next.next.next.next=new ListNode(6);
        h1.next.next.next.next.next.next=new ListNode(7);
        ListNode h2=new ListNode(4);
        h2.next=new ListNode(4);
        h2.next.next=new ListNode(4);
        h2.next.next.next=new ListNode(4);
        h2.next.next.next.next=new ListNode(5);
        h2.next.next.next.next.next=new ListNode(6);
        h2.next.next.next.next.next.next=new ListNode(7);

        ListNode ans=new Merge2SortedList().mergeTwoLists(h1,h2);
        print(ans);
    }
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1==null)return h2;
        if(h2==null)return h1;
        ListNode h3=null;

        if(h1.val<h2.val){
            h3=h1;
            h1=h1.next;
        }else{
            h3=h2;
            h2=h2.next;
        }
        ListNode t=new ListNode(1);
        t.next=h3;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                h3.next=h1;
                h1=h1.next;
                h3=h3.next;
            }
            else{
                h3.next=h2;
                h2=h2.next;
                h3=h3.next;
            }
        }
        if(h1==null){
            h3.next=h2;
        }
        if(h2==null){
            h3.next=h1;
        }

        return t.next;

    }
}
