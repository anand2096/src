package DSA.leetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int nums[] = {4, 5, 0, -2, -3, 1}, k = 5;
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(nums, k));

    }

    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;int rem=0;int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
                sum=sum+nums[i];
                rem=sum%k;
                if(rem<0)rem=rem+k;
                if(map.containsKey(rem)){
                    {
                        ans=ans+map.get(rem);
                        map.put(rem,map.get(rem)+1);
                    }
                }
                else{
                    map.put(rem,1);
                }
        }
        return ans;
    }


    public int subarraysDivByK2(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        sum = nums[0];
        if (sum % k == 0) max++;
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum % k == 0) {
                max++;
            }
            int t = 0;
            int temp = sum;
            while (t < i) {
                temp = temp - nums[t];
                if (temp % k == 0) {
                    max++;
                }
                t++;
            }
        }

        return max;
    }
}
