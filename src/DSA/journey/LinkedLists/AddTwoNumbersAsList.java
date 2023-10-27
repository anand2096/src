package DSA.journey.LinkedLists;

public class AddTwoNumbersAsList {

    public static void main(String[] args) {
        ListNode h1=new ListNode(0);
//        h1.next=new ListNode(9);
//        h1.next.next=new ListNode(1);
//        h1.next.next.next=new ListNode(4);
//        h1.next.next.next.next=new ListNode(5);
//        h1.next.next.next.next.next=new ListNode(6);
//        h1.next.next.next.next.next.next=new ListNode(7);
        ListNode h2=new ListNode(1);
        h2.next=new ListNode(0);
        h2.next.next=new ListNode(1);
//        h2.next.next.next=new ListNode(4);
//        h2.next.next.next.next=new ListNode(5);
//        h2.next.next.next.next.next=new ListNode(6);
//        h2.next.next.next.next.next.next=new ListNode(7);

        ListNode ans=new AddTwoNumbersAsList().addTwoNumbers(h1,h2);
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

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode head=new ListNode(0);
        ListNode start=head;
        int carry=0;
        while(head1!=null && head2!=null){
            int sum=head1.val+head2.val+carry;
            int number=sum%10;
            carry=sum/10;
            ListNode newNode=new ListNode(number);
            head.next=newNode;
            head=head.next;
            head1=head1.next;
            head2=head2.next;
        }
        while(head1!=null){
            int sum=head1.val+carry;
            int number=sum%10;
            carry=sum/10;
            ListNode newNode=new ListNode(number);
            head.next=newNode;
            head=head.next;
            head1=head1.next;
        }
        while(head2!=null){
            int sum=head2.val+carry;
            int number=sum%10;
            carry=sum/10;
            ListNode newNode=new ListNode(number);
            head.next=newNode;
            head=head.next;
            head2=head2.next;

        }
        while(carry>0){
            int mod=carry%10;
            ListNode newNode=new ListNode(mod);
            head.next=newNode;
            head=head.next;
            carry=carry/10;

        }
        return start.next;

    }
}
