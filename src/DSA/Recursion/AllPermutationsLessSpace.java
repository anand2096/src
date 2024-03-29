package DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//TC -> n!*n;
public class AllPermutationsLessSpace {

    static List<List<Integer>> ts=new ArrayList<>();

    List<Integer> test= Arrays.asList(1,3,2);

    public static void main(String[] args) {
        int [] nums = {235745376,19645448,157163584,471490752,117872688,589363440,294681720,147340860,442022580,73670430,12278405,110505645,773539515,257846505};


        new AllPermutationsLessSpace().rec(0,nums);
        System.out.println(ts);
     //   System.out.println(ts);
    }

    public void rec(int index,int[] nums) {

        if(index==nums.length){
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


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
     getAllPermutationsTLE(0,nums,ans);
        return ans;


    }

    public void getAllPermutationsTLE(int index,int[] nums,List<List<Integer>> ans) {

        if(index==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++){
            //swap
            swap(i,index,nums);
            getAllPermutationsTLE(index+1,nums,ans);
            //swap back for next recursion
            swap(i,index,nums);
        }

    }

    private void swap(int i, int j, int[] nums) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}