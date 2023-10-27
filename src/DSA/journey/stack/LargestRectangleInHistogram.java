package DSA.journey.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
            int arr[]={6,57,59,57,35,36,88,28,47,77,20,97,80,90,5,49,47};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(arr));

    }
    public int largestRectangleArea(int[] nums) {


        //get nearest smaller on left for every index
        int [] nsl=nearestSmallerOnLeft(nums);

        //get nearest smaller on right for every index

        int [] nsr=nearestSmallerOnRight(nums);

        //do(r-l-1)*nums[i] that is widhth*heigh

                 for(int i=0;i<nsl.length;i++){
                     System.out.print(nsl[i]+" ");
                 }
         System.out.println("");
                 for(int i=0;i<nsl.length;i++){
                     System.out.print(nsr[i]+" ");
                 }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){

            max=Math.max(max,((nsr[i]-nsl[i])-1) * (nums[i]));

        }

        return max;

    }



    public int[] nearestSmallerOnLeft(int [] nums){
        int n=nums.length;
        int ans[]=new int[n];
        ans[0]=-1;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){

            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
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



    public int[] nearestSmallerOnRight(int [] nums){

        int n=nums.length;
        int ans[]=new int[n];
        ans[n-1]=n;
        Stack<Integer> stack=new Stack<>();
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){

            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
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
