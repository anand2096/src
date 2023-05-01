package DSA.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int arr[]={3,1,2};
        System.out.println(new SubsetSum().subsetSum(arr));

    }
    public List<Integer> subsetSum(int arr[]){
        List<Integer>subsetSum=new ArrayList<>();
        getAllSubset(0,arr,0,subsetSum);
        Collections.sort(subsetSum);
        return subsetSum;


    }

    private void getAllSubset(int index,int[] arr,int sum, List<Integer> subsetSum) {

        if(index==arr.length){
            subsetSum.add(sum);
        return;
        }
        //pick the element
        getAllSubset(index+1,arr,sum+arr[index],subsetSum);

        //do-not pick the element
        getAllSubset(index+1,arr,sum,subsetSum);

    }
}
