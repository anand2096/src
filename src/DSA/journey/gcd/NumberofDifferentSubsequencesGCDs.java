package DSA.journey.gcd;

import java.util.HashSet;
import java.util.Set;

public class NumberofDifferentSubsequencesGCDs {
    Set<Integer> set=new HashSet<>();
    public static void main(String[] args) {
       int [] nums = {19,3,9};
        System.out.println(new NumberofDifferentSubsequencesGCDs().countDifferentSubsequenceGCDs(nums));
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
       int ans=0;
       boolean [] a=new boolean[200002];
       for(int num:nums){
           a[num]=true;
       }

       for(int i=1;i<=200000;i++){
           if(a[i]){
               ans++;
           }
           else{
               int ok=-1;
               for(int j=i+i;j<=200000;j+=i){
                   if(a[j]){
                       if(ok==-1)
                           ok=j;
                       else
                            ok=gcd(ok,j);

                   }
               }
               if(ok==i) ans++;
           }
       }


        return ans;
    }
    public void rec(int index,int [] nums,Set<Integer> set,int currGcd){

        if(index>=nums.length)
        { int t=currGcd;
            set.add(t);
            return;
        }

      //  for(int i=index+1;i<nums.length;i++){

                int newGcd = gcd(currGcd, nums[index]);
                rec(index + 1, nums, set, newGcd);
                if(index+1<nums.length)
                rec(index + 1, nums, set, nums[index+1]);

       // }

    }

    public int gcd(int a,int b ){

        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
}
