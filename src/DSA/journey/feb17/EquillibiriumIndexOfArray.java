package DSA.journey.feb17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquillibiriumIndexOfArray {
    public static void main(String[] args) {
        List<Integer> al= Arrays.asList(-7, 1, 5, 2, -4, 3, 0);
                                    //  -7, 6, 11,13, 9, 12,12
        System.out.println(new EquillibiriumIndexOfArray().solve(al));
    }
    public int solve(List<Integer> list) {

        int []prefixSumArr=new int[list.size()];
        prefixSumArr[0]=list.get(0);
        for(int i=1;i<list.size();i++){
            prefixSumArr[i]=prefixSumArr[i-1]+list.get(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            int sSum;
            int eSum;
            if(i==0){
                sSum=0;
            }
            else{
                sSum=prefixSumArr[i-1];
            }
            if(i==list.size()-1){
                eSum=0;
            }
            else{
                eSum=prefixSumArr[list.size()-1]-prefixSumArr[i];
            }
            if(sSum==eSum) {
                if(i<ans){
                    ans=i;
                }
            }
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}
