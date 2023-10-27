package DSA.journey.LinkedLists;

import static DSA.journey.LinkedLists.AddTwoNumbers2.print;

public class RemoveNthNodeFromLinkedList {
    public static void main(String[] args) {
        ListNode h2=new ListNode(1);
        h2.next=new ListNode(2);
        h2.next.next=new ListNode(3);
        h2.next.next.next=new ListNode(4);
        h2.next.next.next.next=new ListNode(5);
        //h2.next.next.next.next.next=new ListNode(1);
        System.out.println(new RemoveNthNodeFromLinkedList().removeNthFromEnd(h2,2));
        print(h2);
    }

    public ListNode removeNthFromEnd(ListNode head, int pos) {
        int size=size(head);
        if(pos>=size){
            return head=head.next;
        }
        else{
            ListNode temp=head;
            for(int i=1;i<size-pos;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        return head;

    }

    public int size(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
}
