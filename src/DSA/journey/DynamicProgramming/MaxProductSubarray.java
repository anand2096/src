package DSA.journey.DynamicProgramming;

public class MaxProductSubarray {

    public static void main(String[] args) {

    }

  //  0,0,0,-3,-2,0,1,0,0,0,0,0,-2,0,0,0,3,3,0,0,0,0,3,0


    public int maxProduct(final int[] nums) {

        int pos=0;
        int neg=0;
        int zero=0;
        int product=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)pos++;
            else if(nums[i]<0)neg++;
            else if(nums[i]==0)zero++;
            product*=nums[i];
            max=Math.max(max,product);
            if(product<=0){
                product=1;
            }

        }
        if(pos==0){
            return 0;
        }
        return max;
    }
}
