package DSA.journey.feb18;

import DSA.CommonFun;

import java.util.ArrayList;

public class SubarrayWithLeastAvg {
    public static void main(String[] args) {
        int [] A = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        int B = 9;
        System.out.println(new SubarrayWithLeastAvg().solve(CommonFun.createInput(A),B));

    }
    public int solve(ArrayList<Integer> list, int k) {
        int i=0;
        int j=0;
        float ans=Float.MAX_VALUE;
        int ansIndex=-1;
        float sum=0;
        while(j<list.size()){

            if(j-i+1<k){
                sum=sum+list.get(j);
                j++;
            }
            else if(j-i+1==k){
                sum=sum+list.get(j);
                float tempAvg=(sum/k);
                if(tempAvg<ans){
                    ans=tempAvg;
                    ansIndex=i;
                }
                sum=sum-list.get(i);
                i++;
                j++;
            }
        }
        return ansIndex;
    }
}
