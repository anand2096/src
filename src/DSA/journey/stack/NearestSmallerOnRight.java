package DSA.journey.stack;

import java.util.Stack;

public class NearestSmallerOnRight {
    public static void main(String[] args) {
        int arr[]={4,6,10,11,7,8,3,5};
        int ans[]=new NearestSmallerOnRight().nearestSmallerOnLeft(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }


    public int [] nearestSmallerOnLeft(int [] arr){

        int ans[]=new int[arr.length];
        int n=arr.length;
        ans[n-1]=-1;
        Stack<Integer>stack=new Stack<>();
        stack.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}
