//package DSA.journey.gcd;
//
//public class NumberOfSubarraysWithGCDEqualToK {
//        int ans=0;
//    public static void main(String[] args) {
//        int arr[]={9,3,1,2,6,3};
//        int k=3;
//        System.out.println(new NumberOfSubarraysWithGCDEqualToK().subarrayGCD(arr,k));
//    }
//
//    public int subarrayGCD(int[] nums, int k) {
//        int ans=0;
//        rec(0,nums,k,nums[0]);
//        return ans;
//    }
//    public void rec(int index,int [] nums,int k,int currGcd){
//
//        if(index>=nums.length)return;
//
//
//        int newGcd=gcd(currGcd,nums[index]);
//        if(newGcd==k){
//                        ans++;
//        }
//        for(int i=index+1;i<nums.length;i++){
//            rec(i,nums,k,newGcd);
//            rec(i,nums,k,currGcd);
//        }
//
//
//
//    }
//
//    public int gcd(int a,int b ){
//
//        if(a==0){
//            return b;
//        }
//        return gcd(b%a,a);
//    }
//}
