package DSA.sorting;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {0,1,1};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            int remSum=0-nums[i];
            while(j<k){
                if(nums[j]+nums[k]==remSum){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    set.add(temp);
                    j++;
                    k--;
                }
                else if(nums[j]+nums[k]<remSum){
                    j++;
                }
                else{
                    k--;
                }

            }
        }


        List<List<Integer>> ans = new ArrayList<>(set);


        return ans;

    }
}
