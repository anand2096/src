package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LargestSumOfAverages {

    double ans=Double.MIN_VALUE;
    public static void main(String[] args) {
        int []nums = {4,1,7,5,6,2,3};
        int k=4;
        System.out.println(new LargestSumOfAverages().largestSumOfAverages(nums,k));
    }

    public double largestSumOfAverages(int[] nums, int k) {

        List<List<Integer>> list=new ArrayList<>();
        for(int i=1;i<=k;i++){
            list.add(new ArrayList<>());
        }

        possibleSubarrays(0,nums.length-1,nums,list);

        return ans;
    }

    public void possibleSubarrays(int index,int n,int [] nums,List<List<Integer>> list){

        if(index>n){
           // System.out.println(list);
            double tavg=0;
            for(int i=0;i<list.size();i++){
                List<Integer> temp=list.get(i);
                int sum=0;
                for(int j=0;j<temp.size();j++){
                    sum=sum+temp.get(j);
                }
                if(sum>0) {
                    double avg = (double) sum / temp.size();
                    tavg = tavg + avg;
                }
            }

                System.out.println(tavg);
                System.out.println(list);

            ans=Math.max(ans,tavg);

            return;
        }

        for(int i=0;i<list.size();i++){
            list.get(i).add(nums[index]);
            possibleSubarrays(index+1,n,nums,list);
            list.get(i).remove(list.get(i).size()-1);

        }


    }
}
//4 1 7 5 6 2 3