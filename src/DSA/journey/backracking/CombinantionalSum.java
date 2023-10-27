package DSA.journey.backracking;

import DSA.CommonFun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class CombinantionalSum {
    public static void main(String[] args) {

        int arr[]={8,10,6,11,1,16,8};
        System.out.println(new CombinantionalSum().combinationSum(CommonFun.createInput(arr),28));
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer>nums, int k) {
        Collections.sort(nums);
        HashSet<ArrayList<Integer>> ans=new HashSet<>();
        rec(0,k,nums,new ArrayList<Integer>(),ans);

        ArrayList<ArrayList<Integer>> fans=new ArrayList<>();
        for(ArrayList<Integer>a:ans){
            fans.add(a);
        }
        Collections.sort(fans, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
        return fans;

    }

    public void rec(int index,int target,ArrayList<Integer>nums,ArrayList<Integer> curr,HashSet<ArrayList<Integer>>ans){

        if(index>=nums.size()){
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if(nums.get(index)<=target){
            curr.add(nums.get(index));
            rec(index,target-nums.get(index),nums,curr,ans);
            curr.remove(curr.size()-1);
        }
        rec(index+1,target,nums,curr,ans);
    }

}
