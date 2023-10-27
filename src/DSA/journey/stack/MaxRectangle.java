package DSA.journey.stack;

import java.util.Stack;
public class MaxRectangle {

    public static void main(String[] args) {
        int [][]mat={{0, 0, 1},{0, 1, 1},{1, 1, 1}};
        System.out.println(new MaxRectangle().solve(mat));
    }
    public int solve(int[][] mat) {

        int n=mat.length;
        int m=mat[0].length;
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){

                if(mat[i][j]!=0){
                    mat[i][j]=mat[i-1][j]+mat[i][j];
                }
                else{
                    mat[i][j]=0;
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int k=0;k<n;k++){
            ans=Math.max(ans,areaOfHistogram(mat[k]));
        }
        return ans;


    }
    private int areaOfHistogram(int [] nums){
        int n=nums.length;
        int []nsl=nearestSmallerOnLeft(nums);
        int []nsr=nearestSmallerOnRight(nums);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            max=Math.max(max, (nsr[i]-nsl[i]-1) * nums[i]);
        }
        return max;

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



}
