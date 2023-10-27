package DSA.journey.LinkedLists;

import jdk.nashorn.internal.ir.SplitReturn;

public class PartitionList {
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
            int arr[]={192,856,647,251,498,749,252,577,322,794,490,278,754,505,688,418,486,3,700,680,707,892,37,666,9,858,802,82,441,500,64,373,174,779,346,803,760,48,783,654,731,391,733,480,5,144,919,291,180,50,326,90,437,502,527,648,361,828,729,546,934,69,209,187,365,329,276,86,348,986,344,183,495};
            ListNode head=createLinkedlist(arr);
            int k=40;
            ListNode ans=new PartitionList().partition(head,k);
            print(ans);
        }
        public ListNode partition(ListNode head, int k) {
        ListNode h=new ListNode(0);
        h.next=head;
            ListNode prev = h;
            ListNode h1 = head;
            ListNode temp = head;
            while (temp != null && temp.val < k) {
                prev = temp;
                temp = temp.next;
            }
            ListNode fix = temp;
            ListNode gPrev = temp;
            if(temp==null)return  head;
            temp = temp.next;
            while (temp != null) {
                if (temp.val < k) {
                    ListNode t = temp;
                    gPrev.next = temp.next;
                    prev.next = t;
                    t.next = fix;
                    prev = prev.next;
                    temp = temp.next;

                } else {
                    gPrev = temp;
                    temp = temp.next;
                }


            }
            return h.next;
        }


    }



