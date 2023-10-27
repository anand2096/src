package DSA.journey.LinkedLists;

public class ReoderList {

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        ListNode head=createLinkedlist(arr);

       ListNode ans=new ReoderList().reorderList(head);
       print(ans);
    }

    public ListNode reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        int size=size(head);
        if(size<=2){
            return head;
        }

        while(fast.next!=null &&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode middle=slow;
        ListNode secondHalfNode=middle.next;
        slow.next=null;
        ListNode h2=reverse(secondHalfNode);
        ListNode h1=head;
        ListNode h3=new ListNode(0);
        ListNode ans=h3;
        while(h1!=null && h2!=null){
            h3.next=h1;
            h1=h1.next;
            h3=h3.next;
            h3.next=h2;
            h2=h2.next;
            h3=h3.next;


        }
        if(h1!=null){
            h3.next=h1;
        }
        if(h2!=null){
            h3.next=h2;
        }
        return ans.next;


    }


    public int size(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
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
    public ListNode reorderList2(ListNode head) {
        int size=size(head);
        ListNode slow=head;
        ListNode prev=head;
        ListNode fast=head;
        while(fast!=null &&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode middle=slow;
        ListNode reverseMiddle=reverse(middle);
        prev.next=reverseMiddle;
        ListNode temp=head;
        int c=0;
        while(c<(size/2)-1 &&temp.next!=null &&reverseMiddle!=null){
            c++;
            ListNode t=temp;
            ListNode tnext=temp.next;
            ListNode r=reverseMiddle;
            prev.next=reverseMiddle.next;
            t.next=reverseMiddle;
            reverseMiddle.next=tnext;
            temp=temp.next.next;
            reverseMiddle=prev.next;

        }
        return head;

    }
    public ListNode reverse(ListNode node){
        ListNode h2=null;
        ListNode h1=node;
        while (h1!=null){
            ListNode temp=h1;
            h1=h1.next;
            temp.next=h2;
            h2=temp;
        }
       return  h2;
    }




    public ListNode middle(ListNode head){

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }




    public ListNode reorderListW(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        ListNode sLast=head;
        while(slow!=null && slow.next!=null && slow.next!=fast){

            ListNode prev=fast;
            while(fast.next!=null && fast.next.next!=null){
                prev=prev.next;
                fast=fast.next.next;

            }
            if(fast.next!=null){
                fast=fast.next;
            }

            while(prev.next!=fast){
                prev=prev.next;
            }

            ListNode temp=slow.next;
            slow.next=fast;
            fast.next=temp;
            prev.next=null;
            sLast=slow;
            slow=slow.next;
            if(slow!=null){
                sLast=slow;
                slow=slow.next;
            }


        }

        while(fast!=null){
            sLast.next=fast;
            sLast=sLast.next;
            fast=fast.next;

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
