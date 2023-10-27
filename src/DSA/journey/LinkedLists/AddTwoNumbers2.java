package DSA.journey.LinkedLists;

public class AddTwoNumbers2 {

    public static void main(String[] args) {
        //3, 9,9,9, 9,9,9, 9,9,9

       //  1,1,1 ,1,1,1 ,1,1,1 ,1,1
        // 1,1,1, 1,1,1, 1,1,1 ,1,1
        ListNode h1=new ListNode(1);
        h1.next=new ListNode(2);
        h1.next.next=new ListNode(3);
      //  h1.next.next.next=new ListNode(1);
//        h1.next.next.next.next=new ListNode(1);
//        h1.next.next.next.next.next=new ListNode(1);
//        h1.next.next.next.next.next.next=new ListNode(1);
//        h1.next.next.next.next.next.next.next=new ListNode(1);
//        h1.next.next.next.next.next.next.next.next=new ListNode(1);
//        h1.next.next.next.next.next.next.next.next.next=new ListNode(1);
//        h1.next.next.next.next.next.next.next.next.next.next=new ListNode(1);


        ListNode h2=new ListNode(8);
        h2.next=new ListNode(7);
        h2.next.next=new ListNode(7);
//        h2.next.next.next=new ListNode(1);
//        h2.next.next.next.next=new ListNode(1);
//        h2.next.next.next.next.next=new ListNode(1);
//        h2.next.next.next.next.next.next=new ListNode(1);
//        h2.next.next.next.next.next.next.next=new ListNode(1);
//        h2.next.next.next.next.next.next.next.next=new ListNode(1);
//        h2.next.next.next.next.next.next.next.next.next=new ListNode(1);
//        h2.next.next.next.next.next.next.next.next.next.next=new ListNode(1);


//        h2.next=new ListNode(0);
//        h2.next.next=new ListNode(1);
//        h2.next.next.next=new ListNode(4);
//        h2.next.next.next.next=new ListNode(5);
//        h2.next.next.next.next.next=new ListNode(6);
//        h2.next.next.next.next.next.next=new ListNode(7);

        ListNode ans=new AddTwoNumbers2().addTwoNumbers(h1,h2);
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

    //    int size1=size(head1);
        //System.out.println(size1);
    //    int size2=size(head2);
        //  System.out.println(size2);
        long firstNumber=getNumber(head1);
        /// System.out.println(firstNumber);
        long secondNumner=getNumber(head2);
        // System.out.println(secondNumner);
        long finalNumber=firstNumber+secondNumner;
        // System.out.println(finalNumber);

        ListNode head=null;
        ListNode start=head;

        while(finalNumber>0){
            long val=finalNumber%10;
            ListNode newNode=new ListNode((int)val);
            ListNode temp=head;
            head=newNode;
            newNode.next=temp;
            finalNumber=finalNumber/10;


        }
//        if(finalNumber==0){
//            ListNode newNode=new ListNode((int) finalNumber);
//            ListNode temp=head;
//            head=newNode;
//            newNode.next=temp;
//        }

        int finalSize=size(head);
        if(finalSize>1){
            while(head.val==0){
                head=head.next;
            }
        }
        return head;


    }


    public int getNumber(ListNode head){
        ListNode temp=head;
        int number=0;
        while(temp!=null){
            int val=temp.val;
            number=number*10+val;
            temp=temp.next;
        }
        return number;

    }
    public long getNumber1(ListNode head, int size){
        ListNode temp=head;
        long number=0;
        int power=size-1;
        while(temp!=null){

            int val=temp.val;
            number=number+ (long) val *(int)Math.pow(10,power);
            temp=temp.next;
            power=power-1;

        }
        return number;

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

}
