package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(new Permutations().permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans =new ArrayList<>();;
        boolean []frequencies=new boolean[nums.length];

        getAllPermutations(nums,new ArrayList<>(),frequencies,ans);
        return  ans;


    }
    public void getAllPermutations(int[] nums,List<Integer> curPermutation,boolean[] frequencies,List<List<Integer>> ans){

        if(curPermutation.size()==nums.length){
            ans.add(new ArrayList<>(curPermutation));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!frequencies[i]){
                frequencies[i]=true;
                curPermutation.add(nums[i]);
                getAllPermutations(nums,curPermutation,frequencies,ans);
                frequencies[i]=false;
                curPermutation.remove(curPermutation.size()-1);
            }
        }

    }
}
