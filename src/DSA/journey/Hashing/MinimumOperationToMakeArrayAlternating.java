package DSA.journey.Hashing;

import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;this.second=second;
    }
}

public class MinimumOperationToMakeArrayAlternating {
    public static void main(String[] args) {

    }
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> even=new HashMap<>();
        Map<Integer,Integer> odd=new HashMap<>();
        for(int i=0;i<nums.length;i++){

            if(i%2==0){
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            }
            else{
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
            }
        }
        List<Pair> l1=new ArrayList<>();
        List<Pair> l2=new ArrayList<>();
        even.forEach((i, j) -> {
            l1.add(new Pair(j,i));

        });
        odd.forEach((i, j) -> {
            l2.add(new Pair(j,i));

        });

        Collections.sort(l1,(i1,i2)->i2.first-i1.first);
        Collections.sort(l2,(i1,i2)->i2.first-i1.first);

        if(l1.get(0).second!=l2.get(0).second){
            return ((n+1)/2 - l1.get(0).first+(n/2)-l2.get(0).first);
        }
        else{
            int ans=n;
            if(l1.size()==1 && l2.size()==1){
                return ans-Math.max(l1.get(0).first,l2.get(0).first);
            }
            else if(l1.size()==1){
                return ans-l1.get(0).first-l2.get(1).first;
            }
            else if(l2.size()==1){
                return ans-l2.get(0).first-l1.get(1).first;
            }
            else{
                return ans-Math.max(l1.get(0).first+l2.get(1).first,l1.get(1).first+l2.get(0).first);
            }

        }


    }

}
