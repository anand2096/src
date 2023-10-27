package DSA.journey.LinkedLists;

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {

        ListNode f=new ListNode(1);
        f.next=new ListNode(1);
        f.next.next=new ListNode(1);
        f.next.next.next=new ListNode(3);
        f.next.next.next.next=new ListNode(4);
        f.next.next.next.next.next=new ListNode(4);
        f.next.next.next.next.next.next=new ListNode(5);
        ListNode head=new RemoveDuplicatesFromSortedList2().deleteDuplicates(f);
        print(head);
    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            int val=temp.val;
            boolean flag=false;
            while(temp.next!=null && temp.next.val==val){
                temp.next=temp.next.next;
                flag=true;
            }
            if(flag){
                if(prev!=null)
                prev.next=temp.next;
                prev=prev;
                temp=temp.next;
                if(prev==null)
                head=temp;
            }else{
                prev=temp;
                temp=temp.next;
            }
        }
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
