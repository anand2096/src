package DSA.leetCodeDaily;

public class NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {
       int [] nums = {1,3,0,0,2,0,0,0};
        System.out.println( new NumberOfZeroFilledSubarrays().zeroFilledSubarray(nums));
    }

    public long zeroFilledSubarray(int[] nums) {
        int i=0;
        int n=nums.length;
        long ans=0;
        while(i<n){
            if(nums[i]==0){
                long cnt=1;
                int j=i+1;
                while(j<n&&nums[j]==0){
                    cnt++;
                    j++;
                }
                i=j;
                ans=ans+((cnt*(cnt+1))/2);
            }
            else{
                i++;
            }

        }

        return ans;
    }
}
