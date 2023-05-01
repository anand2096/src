package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSUm {

//    Input: candidates = [2,3,6,7], target = 7
//    Output: [[2,2,3],[7]]

    public static void main(String[] args) {
        int arr[] = {2, 3, 6, 7};
        int target = 7;

        System.out.println(new CombinationSUm().combinationSum(arr, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllCombination(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    public void getAllCombination(int index, int target, int[] candidates, List<Integer> combination, List<List<Integer>> ans) {
        //    Input: candidates = [2,3,6,7], target = 7
     if(index==candidates.length) {
         if (target == 0) {
             ans.add(new ArrayList<>(combination));

         }
         return;
     }

        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            getAllCombination(index, target - candidates[index], candidates, combination, ans);
            combination.remove(combination.size() - 1);
        }

        getAllCombination(index + 1, target, candidates, combination, ans);

    }


//    public void combinationSum(int ind,int target,int arr[],int n,List<Integer> al, List<List<Integer>> ans){
//
//        if(ind==n){
//            if(target==0) {
//                ans.add(new ArrayList<>(al));//not a constant operation takes linear time
//
//            }
//            return;
//        }
//        if(arr[ind]<=target) {
//            al.add(arr[ind]);
//            combinationSum(ind, target - arr[ind], arr, n, al, ans);
//            al.remove(al.size()-1);
//        }
//
//        combinationSum(ind+1,target,arr,n,al,ans);
//       // System.out.println(al);
//
//    }


}
