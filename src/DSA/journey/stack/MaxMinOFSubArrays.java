package DSA.journey.stack;

import java.util.Stack;

public class MaxMinOFSubArrays {

    public static void main(String[] args) {
    int arr[]={3,1,2,4};  System.out.println(new MaxMinOFSubArrays().solve(arr));

    }

//
//    733529849
//    Your function returned the following:
//            438562581

    public int solve(int[] nums) {
        int mod=(int)Math.pow(10,9)+7;
        int n=nums.length;

        //Nearest greater in left
        int ngl[]=nearestGreaterOnLeft(nums);

        //Nearest greater in right
        int ngr[]=nearestGreaterOnRight(nums);

        // Nearest Smaller in left,
        int nsl[]=nearestSmallerOnLeft(nums);

        // Nearest smallest in right
        int nsr[]=nearestSmallerOnRight(nums);


        long maxSum=0;
        for(int i=0;i<n;i++){

            long mul=((long) (i - ngl[i]) *(ngr[i]-i) * nums[i]);
            maxSum=(maxSum%mod + mul %mod)%mod;



        }
        long minSum=0;
        for(int i=0;i<n;i++){
            long mul=((long) (i - nsl[i]) *(nsr[i]-i) *nums[i]);
            minSum=(minSum%mod + mul %mod)%mod;

        }

        return (int)(maxSum-minSum+mod)%mod;

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

    // nearestSmallerOnRight
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

    //nearestGreaterOnLeft
    public int[] nearestGreaterOnLeft(int []nums){
        int n=nums.length;
        int []ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        ans[0]=-1;
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
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

    //nearestGreaterOnRight
    public int[] nearestGreaterOnRight(int []nums){
        int n=nums.length;
        int []ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        ans[n-1]=n;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
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
