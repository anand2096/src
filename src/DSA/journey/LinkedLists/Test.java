package DSA.journey.LinkedLists;

public class Test {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int k=1;
        ListNode head=createLinkedlist(arr);
        ListNode ans=new Test().reverseList(head,k);
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
    public ListNode reverseList(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        ListNode ans=new ListNode(0);
        ans.next=head;
        dummy.next=head;
        int size=size(head);
        int count=0;
        while(count<size/k){
            ListNode start=dummy.next;
            ListNode end=start;
            for(int i=1;i<k;i++){
                end=end.next;
            }
            ListNode temp=end.next;
            end.next=null;
            ListNode reverse=reverse(start);
            dummy.next=end;
            start.next=temp;
            dummy=start;
            if(count==0){
                ans.next=reverse;
            }
            count++;

        }
        return ans.next;
    }

    public ListNode reverse(ListNode head){
        ListNode h1=head;
        ListNode h2=null;
        while(h1!=null){
            ListNode temp=h1;
            h1=h1.next;
            temp.next=h2;
            h2=temp;
        }
        return h2;
    }
    public int size(ListNode head){
        ListNode h1=head;
        int count=0;
        while(h1!=null){
            h1=h1.next;
            count++;
        }
        return count;
    }
}
