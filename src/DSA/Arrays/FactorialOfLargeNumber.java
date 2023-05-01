package DSA.Arrays;

import java.util.Scanner;

public class FactorialOfLargeNumber {


    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);

        System.out.println("Enter your no ....");
        int n=kb.nextInt();
        LinkedListNode node=new LinkedListNode(1);

        for(int i=2;i<=n;i++)
        CalculateFactOfBigNumber(node,i);

        new FactorialOfLargeNumber().display(node);



    }

    private static void CalculateFactOfBigNumber(LinkedListNode node, int i) {
        LinkedListNode temp=node;
        LinkedListNode prev=node;
        int c=0;
        while(temp!=null){
            int data=temp.val*i+c;
            temp.val=data%10;
            c=data/10;
            prev=temp;
            temp=temp.next;

        }

        while(c!=0){


            prev.next=new LinkedListNode(c%10);
            c/=10;
            prev=prev.next;
        }






    }
    void display(LinkedListNode h)
    {
        // Using the tail recursion

        // handling the base case
        if (h == null)
        {
            return;
        }
        display(h.next);

        // recursively printing the
        // linked list in the reverse order
        System.out.print(h.val);
    }


}


// instantiating this class
// will create a node of the linked list



class LinkedListNode
{
    int val;
    LinkedListNode next;

    // constructor of the class LinkedListNode


    LinkedListNode(int num)
    {
        // initializing the fields
        this.val = num;
        this.next = null;
    }

}
