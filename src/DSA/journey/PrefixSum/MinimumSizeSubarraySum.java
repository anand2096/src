package DSA.journey.PrefixSum;


//https://leetcode.com/problems/minimum-size-subarray-sum/description/

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 15;
        int[] nums = {1,2,3,4,5};

        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen( target,nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum = sum + nums[j];
            j++;
            while(sum>=target){
                ans = Math.min(ans, j - i );
                sum=sum-nums[i];
                i--;
            }
            }
        if (ans == Integer.MAX_VALUE)
            return 0;
        else return ans;
    }

}
