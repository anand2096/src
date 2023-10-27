package DSA.journey.stack;

import java.util.Stack;

public class NearestGreaterOnLeft {
    public static void main(String[] args) {
        int arr[]={9,7,3,5,4,2,6,1,8};
        int ans[]=new NearestGreaterOnLeft().nearestGreaterOnLeft(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public int [] nearestGreaterOnLeft(int arr[]){
        int ans[]=new int[arr.length];
        int n=arr.length;
        ans[0]=-1;
        Stack<Integer> stack=new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && stack.peek()<= arr[i]){
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
