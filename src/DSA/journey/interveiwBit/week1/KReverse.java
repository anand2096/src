//package DSA.journey.interveiwBit.week1;
///**
// * Definition for singly-linked list.
// * class ListNode {
// *     public int val;
// *     public ListNode next;
// *     ListNode(int x) { val = x; next = null; }
// * }
// */
//public class KReverse {
//
//    public ListNode reverseList(ListNode head, int k) {
//        ListNode dummy=new ListNode(0);
//        ListNode ans=new ListNode(0);
//        ans.next=head;
//        dummy.next=head;
//        int size=size(head);
//        int count=0;
//        while(count<=size/k){
//            ListNode start=dummy.next;
//            ListNode end=start;
//            for(int i=1;i<k;i++){
//                end=end.next;
//            }
//            ListNode temp=end.next;
//            end.next=null;
//            ListNode reverse=reverse(start);
//            dummy.next=end;
//            start.next=temp;
//            dummy=start;
//            count++;
//
//        }
//        return ans.next;
//    }
//
//    public ListNode reverse(ListNode head){
//        ListNode h1=head;
//        ListNode h2=null;
//        while(h1!=null){
//            ListNode temp=h1.next;
//            h1=h1.next;
//            temp.next=h2;
//            h2=temp;
//        }
//        return h2;
//    }
//    public int size(ListNode head){
//        ListNode h1=head;
//        int count=0;
//        while(h1!=null){
//            h1=h1.next;
//            count++;
//        }
//        return count;
//    }
//}
