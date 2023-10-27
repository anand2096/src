package DSA.journey.backracking;

import java.util.Arrays;

public class SumPair {


    int ans;
    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        ans=0;

        if(rec(0,nums,0,k,nums.length))return 1;
        return 0;


    }

    public boolean rec(int index,int []nums,int currSum,int k,int n){
        if(index>=n){
            if(currSum==k)return true;
            return false;
        }


        if(rec(index+1,nums,currSum+(nums[index]*nums[index+1]),k,n))return true;
        if(rec(index+1,nums,currSum,k,n)) return true;
        return false;

    }
}
