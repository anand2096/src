package DSA.journey.queue;

import DSA.journey.slidingWindow.SubArrayWithSumK;

public class SubarrayWithSumK {

    public static void main(String[] args) {


        int arr[]={-28,81,-20,28,-29};
        int k=89;
        System.out.println(new SubarrayWithSumK().shortestSubarray(arr,k));
    }

    public int shortestSubarray(int[] nums, int k) {

        int sum=0;
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(j<n){

            if(sum<k){
                sum=sum+nums[j];
                j++;
            }
            else{
                ans=Math.min(ans,j-i);
                while(i<n&& sum>=k){
                    ans=Math.min(ans,j-i);
                    sum=sum-nums[i];
                    i++;
                }


            }

        }
        while(i<n){
            if(sum>=k)
            ans=Math.min(ans,j-i);
            sum=sum-nums[i];
            i++;
        }
        if(ans==Integer.MAX_VALUE)
            return -1;
        return ans;

    }
}
