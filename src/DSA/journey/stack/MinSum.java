package DSA.journey.stack;

import java.util.Stack;
public class MinSum {

    public static void main(String[] args) {
        int nums[]={71,55,82,55};
        System.out.println(new MinSum().sumSubarrayMins(nums));
    }

    public int sumSubarrayMins(int[] arr) {

        //get nearest smaller array on left

        int []nsl=nearestSmallerOnLeft(arr);
        //get nearest smaller array on right
        int []nsr=nearestSmallerOnRight(arr);

        int mod=(int)Math.pow(10,9)+7;
        long minSum=0;
        for(int i=0;i<arr.length;i++){
            long mul=((long) (i - nsl[i]) *(nsr[i]-i) *arr[i]);
            minSum=(minSum + mul );

        }

        return (int)minSum%mod;
    }
    //nearest smaller on left
    public int[] nearestSmallerOnLeft(int []nums){
        int n=nums.length;
        int []ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        ans[0]=-1;
        stack.push(0);
        for(int i=1;i<n;i++){

            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i] ){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=stack.peek();
            }
            stack.push(i);
        }
        return ans;

    }
    public int[] nearestSmallerOnRight(int []nums){
        int n=nums.length;
        int []ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        ans[n-1]=n;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){

            while(!stack.isEmpty()&& nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=n;
            }
            else{
                ans[i]=stack.peek();
            }
            stack.push(i);

        }
        return ans;

    }


}
