package LLD;




class ListNode1 {
    public int val;
    public ListNode1 next;
    ListNode1(int x) { val = x; next = null; }
}

public class TestLL {

    public static void main(String[] args) {
        int arr[]={82,};
        ListNode1 head=createLinkedlist(arr);
        ListNode1 ans=new TestLL().solve(head,2,3);
        print(ans);
    }

    public ListNode1 solve(ListNode1 head, int b, int c) {
        ListNode1 ans=head;

        int k=1;
        while(head!=null){

            while(head!=null && k<b){
                head=head.next;
                k++;
            }
            int d=1;
            while(head!=null  && d<=c){
                if(head.next!=null)
                head.next=head.next.next;
                d++;
            }
            k=1;
            head=head.next;

        }
        return ans;

    }
    public int size(ListNode1 head){
        ListNode1 temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    private static ListNode1 createLinkedlist(int[] arr) {
        ListNode1 head=new ListNode1(0);
        ListNode1 start=head;
        for(int i=0;i<arr.length;i++){
            ListNode1 newNode=new ListNode1(arr[i]);
            head.next=newNode;
            head=head.next;
        }

        return start.next;

    }
    public static void print(ListNode1 head){
        ListNode1 temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("");
    }
    public ListNode1 reverse(ListNode1 head){
        ListNode1 h2=null;
        ListNode1 temp=head;
        while(temp!=null){
            ListNode1 t=temp;
            temp=temp.next;
            t.next=h2;
            h2=t;
        }
        return h2;
    }
    public ListNode1 middle(ListNode1 head){

        ListNode1 slow=head;
        ListNode1 fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
