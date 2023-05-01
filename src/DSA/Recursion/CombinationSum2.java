package DSA.Recursion;

import javax.naming.ldap.LdapName;
import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int arr[] = {10,1,2,7,6,1,5};

        int target = 8;



//        int arr[]={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//        int target =30;
        System.out.println(new CombinationSum2().combinationSum2(arr, target));

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        getAllCombination(0, target, candidates, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    public void getAllCombination(int index, int target, int[] candidates, List<Integer> combination,  List<List<Integer>> ans) {

            if(target==0){
                ans.add(new ArrayList<>(combination));
                return;
            }

        for(int ind=index;ind< candidates.length;ind++){
            if(ind>index&&candidates[ind]==candidates[ind-1]) {
                continue;
            }

                if (candidates[ind] <= target) {
                    combination.add(candidates[ind]);
                    getAllCombination(ind+1, target - candidates[ind], candidates, combination, ans);
                    combination.remove(combination.size() - 1);
                }

        }


    }

    public void getAllCombinationTLESoln(int index, int target, int[] candidates, List<Integer> combination,  Set<List<Integer>> ans) {
        //    Input: candidates = [2,3,6,7], target = 7
        if(index==candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(combination));

            }
            return;
        }

        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            getAllCombinationTLESoln(index+1, target - candidates[index], candidates, combination, ans);
            combination.remove(combination.size() - 1);
        }

        getAllCombinationTLESoln(index + 1, target, candidates, combination, ans);

    }

}
