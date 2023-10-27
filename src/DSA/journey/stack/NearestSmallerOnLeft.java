package DSA.journey.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerOnLeft {

    public static void main(String[] args) {
        int arr[]={4,6,10,11,7,8,3,5};
        List<Integer> ans=new NearestSmallerOnLeft().leftSmaller(arr);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

     List<Integer> leftSmaller( int a[])
    {   if(a.length==0)return new ArrayList<>();
        //code here
        Stack<Integer> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        ans.add(-1);
        stack.push(a[0]);
        for(int i=1;i<a.length;i++){

            while(!stack.isEmpty() && stack.peek()>= a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(-1);
            }
            else{
                ans.add(stack.peek());

            }
            stack.push(a[i]);
        }
        return ans;
    }
}
