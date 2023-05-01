package DSA.journey.feb18;

import DSA.CommonFun;

import java.util.ArrayList;

public class SubarrayWithGivenSumAndLength {

    public static void main(String[] args) {
        int [] A = {4, 2, 2, 5, 1};
       int B = 4;
        int C = 6;
        System.out.println(new SubarrayWithGivenSumAndLength().solve(CommonFun.createInput(A),B,C));

    }

    public int solve(ArrayList<Integer> list, int k, int target) {
        int ans=0;
        int i=0;
        int j=0;
        int sum=0;
        while(j<list.size()){
            if(j-i+1<k){
                sum=sum+list.get(j);
                j++;
            }
            else if(j-i+1==k){
                sum=sum+list.get(j);
                if(sum==target)
                    return 1;
                else{
                    sum=sum-list.get(i);
                    i++;
                    j++;

                }
            }

        }
        return ans;

    }
}
