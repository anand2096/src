package DSA.leetCodeDaily;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
       int[] nums = {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        //boolean vis[]=new boolean[nums.length];
        int n=nums.length;
        int sum=0; int max= Integer.MIN_VALUE; int maxElement=Integer.MIN_VALUE;
        int ans=0;
        sum=nums[0];
        max=nums[0];
       // vis[0]=true;
        int last=0;
        if(sum<0) {sum=0;max=0;}
        int i=1;
        for(int t=0;t<n;t++){

            while( last!=2){
                if((i%n)==n-2) last++;
                sum=sum+nums[i%n];
                max=Math.max(sum,max);
                maxElement=Math.max(maxElement,nums[i%n]);
                if(sum<0) sum=0;
                i++;
            }

        }


        if(sum==0) ans=maxElement;
        else ans=max;
        return ans;
    }
}
