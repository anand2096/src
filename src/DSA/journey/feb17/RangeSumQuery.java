package DSA.journey.feb17;

import java.util.ArrayList;

public class RangeSumQuery {

    public static void main(String[] args) {

    }
    public ArrayList<Long> rangeSum(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> q) {
        ArrayList<Long> ans=new ArrayList();
        long [] prefixArray=new long[list.size()];
        prefixArray[0]=list.get(0);
        for(int i=1;i<list.size();i++){
            prefixArray[i]=prefixArray[i-1]+list.get(i);
        }
        for(ArrayList<Integer> query:q){
            int low=query.get(0);
            int high=query.get(1);
            if(low==0){
                ans.add(prefixArray[high]);
            }
            else
            {ans.add(prefixArray[high]-prefixArray[low-1]);
            }

        }
        return ans;
    }
}
