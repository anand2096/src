package DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSum2 {

    public static void main(String[] args) {
        int arr[]={3,4,5};
        System.out.println(new SubsetSum2().subsetSum(arr));

    }
    public List<List<Integer>> subsetSum(int arr[]){
        List<List<Integer>>subsetSum=new ArrayList<>();
        Arrays.sort(arr);
        getAllSubset(0,arr,new ArrayList<>(),subsetSum);
        return subsetSum;


    }

    private void getAllSubset(int index,int[] arr,List<Integer>currSubset, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(currSubset));
        for(int i=index;i<arr.length;i++){
            if(i>index&&arr[i]==arr[i-1])
                continue;
            currSubset.add(arr[i]);
            getAllSubset(i+1,arr,currSubset,ans);
            currSubset.remove(currSubset.size()-1);
        }


    }


}
