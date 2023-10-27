package DSA.journey.slidingWindow;

public class MakeSumDivisibleByP {

    public static void main(String[] args) {
        int []nums =
                {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        int p=26;
        System.out.println(new MakeSumDivisibleByP().minSubarray(nums,p));
    }
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % p == 0) return 0;
        long diff = (sum - p)%p;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int s = 0;
        while (j < n) {
            s = s + nums[j];
            if (s < diff) {
                j++;
            } else if (s == diff) {
                min = Math.min(min, j - i + 1);
                j++;
            } else {
                while (i<n&& s > diff) {
                    s = s - nums[i];
                    i++;
                    if (s == diff) {
                        min = Math.min(min, j - i + 1);
                    }

                }
                j++;
            }
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }

}
