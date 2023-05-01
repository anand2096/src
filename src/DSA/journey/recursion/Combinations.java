package DSA.journey.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        // 1 2 3 4
        int a=5;
        int b=3;
        int ans[][]=new Combinations().combine(a,b);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] combine(int a, int b) {
        int nums[]=new int[a];
        for(int i=0;i<a;i++){
            nums[i]=i+1;
        }
        List<List<Integer>> ans=new ArrayList<>();
        rec(0,nums,b,ans,new ArrayList<Integer>());
        int res[][]=new int[ans.size()][b];
        for(int i=0;i<ans.size();i++){
            int temp[]=new int[b];
            for(int j=0;j<temp.length;j++){
                temp[j]=ans.get(i).get(j);
            }
            res[i]=temp;
        }
 //       System.out.println(ans);


        return res;
    }

    private void rec(int index,int[] nums, int b, List<List<Integer>> ans, ArrayList<Integer> curr) {
        if(curr.size()==b){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(index==nums.length){
            return;
        }

        else{
            curr.add(nums[index]);
            rec(index+1,nums,b,ans,curr);
            curr.remove(curr.size()-1);
            rec(index+1,nums,b,ans,curr);
        }




    }

}
