package DSA.journey.Hashing;

import DSA.journey.BitManipulation.SUBARRAYOR;

import java.util.*;

public class SumOfDistances {

    public static void main(String[] args) {
       int [] nums = {1,3,1,1,2};
        long ans[]=new SumOfDistances().distance(nums);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public long[] distance(int[] nums) {
        long ans[]=new long[nums.length];
        int an=0;
        Map<Long, List<Long>> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey((long)nums[i])){
                List<Long> t=map.get((long)nums[i]);
                t.add((long) i);
                map.put((long) nums[i],t);

            }
            else{
                List<Long> temp=new ArrayList<>();
                temp.add((long) i);
                map.put((long)nums[i],temp);
            }
        }
        for(Map.Entry<Long, List<Long>> entry:map.entrySet()) {
            List<Long> list = entry.getValue();
                long sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum = sum + list.get(i);
                }
                long currSum = 0L;
                long restSum = 0L;
                for (int i = 0; i < list.size(); i++) {
                    restSum = sum - currSum - list.get(i);
                    long left = (list.get(i) * i) - currSum;
                    long right = restSum - (list.get(i) * (list.size() - i - 1));
                    ans[Math.toIntExact(list.get(i))] = left + right;
                  //  an++;
                    currSum += list.get(i);
                }
            }

        return ans;
    }

}
