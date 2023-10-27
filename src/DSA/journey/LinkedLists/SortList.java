package DSA.journey.LinkedLists;

import java.util.List;

public class SortList {
    public static void main(String[] args) {
        ListNode h1=new ListNode(3);
        h1.next=new ListNode(4);
        h1.next.next=new ListNode(2);
        h1.next.next.next=new ListNode(8);
//        h1.next.next.next.next=new ListNode(5);
//        h1.next.next.next.next.next=new ListNode(6);
//        h1.next.next.next.next.next.next=new ListNode(7);
        ListNode ans=new SortList().sortList(h1);
        print(ans);
    }
    public static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("");
    }
    public ListNode sortList(ListNode head) {
        return merge(head);
    }
    public ListNode merge(ListNode head){
        if(head==null)return head;
        if(head.next==null)return head;

        ListNode c=middleNode(head);
        ListNode h2=c.next;
        c.next=null;
        head=merge(head);
        h2=merge(h2);
        return mergeTwoLists(head,h2);


    }
    public ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
        ListNode head=new ListNode(1);
        head.next=h3;
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

        return head.next;

    }
}
