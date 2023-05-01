package DSA.Arrays;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[]={11,13,21,3};
        Stack<Integer>stack=new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i< arr.length;i++){
            int next=arr[i];

            while(!stack.isEmpty()&&stack.peek()<next){
                int ele=stack.pop();
                System.out.println("Greater element for "+ele+" is "+next);
            }
//            if(stack.peek()==-1){
//                System.out.println("Greater element for "+next+" is"+"-1");
//            }
            stack.push(next);
        }
        while(!stack.isEmpty()){
            System.out.println("Greater element for "+stack.pop()+" is"+"-1");
        }

    }
}
