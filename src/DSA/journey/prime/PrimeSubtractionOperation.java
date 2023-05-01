package DSA.journey.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeSubtractionOperation {

    public boolean primeSubOperation(int[] nums) {
        int n=nums.length;
        int max=1005;
//        for(int i=0;i<nums.length;i++){
//            max=Math.max(nums[i],max);
//        }
        int []primeArr=new int[n];
        boolean prime []= new boolean[max+1];
        for(int i=0;i<prime.length;i++){
            prime[i]=true;
        }
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=Math.sqrt(max);i++){
            for(int j=i*i;j<=max;j+=i){
                if(prime[j]) {
                    prime[j] = false;
                }
            }
        }
        List<Integer> listPrime=new ArrayList<>();
        for(int i=2;i<prime.length;i++){
            if(prime[i])
            {
                listPrime.add(i);
            }
        }
        int new_nums[]=new int[n];
        new_nums[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]<new_nums[i+1]){
                new_nums[i]=nums[i];
                continue;
            }
            for(int j=0;j<listPrime.size();j++){
                if(listPrime.get(j)>=nums[i]){
                    new_nums[i]=nums[i];
                    break;
                }
                if(nums[i]- listPrime.get(j)<new_nums[i+1]){
                    new_nums[i]=nums[i]-listPrime.get(j);
                    break;
                }

            }
        }
        for(int k=1;k<n;k++){
            if(new_nums[k]<=new_nums[k-1])return false;
        }
        return true;

    }

//    public boolean rec( int index,int nums[],int [] prime){
//        if(index>nums.length){
//            for(int i=1;i<nums.length;i++){
//
//                if(nums[i]<=nums[i-1]){
//                    return false;
//                }
//            }
//            return true;
//
//        }
//        else {
//            int temp = nums[index];
//            if(prime[index]!=-1) {
//                nums[index] = nums[index] - prime[index];
//                if (rec(index + 1, nums, prime))
//                    return true;
//                nums[index] = temp;
//            }
//            if (rec(index + 1, nums, prime))
//                return true;
//
//        }
//
//        return false;
//    }
}
