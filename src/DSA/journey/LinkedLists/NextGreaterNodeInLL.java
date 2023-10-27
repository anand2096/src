package DSA.journey.LinkedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLL {
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
        int arr[]={2,1,5};
        ListNode head= createLinkedlist(arr);
        int[] ans=new NextGreaterNodeInLL().nextLargerNodes(head);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode reverse=reverse(head);
        List<Integer> ans=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        ListNode temp=reverse;
        while(temp!=null){
            if(stack.isEmpty()){
                ans.add(0);
                stack.add(temp.val);
                temp=temp.next;
            }
            else{
                if(stack.peek()>=temp.val){
                    ans.add(stack.peek());
                    stack.add(temp.val);
                    temp=temp.next;
                }
                else
                {
                    while(!stack.isEmpty() && stack.peek()<temp.val){
                        stack.pop();
                    }
                    if(!stack.isEmpty()){
                        ans.add(stack.peek());
                        stack.add(temp.val);
                        temp=temp.next;
                    }
                    else{
                        ans.add(0);
                        stack.add(temp.val);
                        temp=temp.next;
                    }
                }
            }
        }
        int j=0;
        int arr[]=new int[ans.size()];
        for(int i=ans.size()-1;i>=0;i--){
            arr[j]=ans.get(i);
            j++;
        }

        return arr;
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
}
