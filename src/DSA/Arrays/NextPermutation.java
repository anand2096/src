package DSA.Arrays;

import DSA.Recursion.AllPermutationsLessSpace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {


    static List<List<Integer>> ts=new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,3,5,2,1,3,1};
        int a[]=new NextPermutation().nextPermutation(nums);

        System.out.println(ts);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public int[] nextPermutation(int[] nums){
        if(nums.length==1)return nums;
        int breakpoint=-1;
        int n=nums.length;
        int i=n-2;
        while(i>=0 &&nums[i]>nums[i+1]){
                i--;
        }
        if(i>=0){
            int j=n-1;
            while(nums[i]>nums[j]){
                j--;
            }

            swap(i,j,nums);
        }
        reverse(nums,i+1,n-1);

        return nums;
    }

    private void reverse(int[] nums, int i, int j) {
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }

    public int[] nextPermutationTLE(int[] nums) {
        int j;
        for( j=1;j<nums.length;j++){
            if(nums[j]>nums[j-1]){
                break;
            }
        }
        if(j==nums.length){
            Arrays.sort(nums);
            return nums;
        }
        rec(0,nums);
        List<Integer> ans=ts.get(1);
        int []a=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            a[i]=ans.get(i);
        }
        return a;

    }
    public void rec(int index,int[] nums) {

        if(index==nums.length ){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                temp.add(nums[j]);
            }
            ts.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(index,i,nums);
            rec(index+1,nums);
            swap(index,i,nums);
        }


    }
    private void swap(int i, int j, int[] nums) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
