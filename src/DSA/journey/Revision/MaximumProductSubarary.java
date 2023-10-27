package DSA.journey.Revision;

public class MaximumProductSubarary {
    public static void main(String[] args) {
        int no[]={-5,0,2};
        System.out.println(new MaximumProductSubarary().maxProduct(no));
    }
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        if(nums.length==1)return nums[0];
        int product=1;
        int countNegative=0;
        int zero=0;
        int pos=0;
        int prefix[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)pos++;
            if(nums[i]==0)zero++;
            if(nums[i]<0)countNegative++;
        }
        if(countNegative%2==0){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    product=1;
                }
                else{
                    product=product*nums[i];
                    ans=Math.max(ans,product);
                }
            }
            if(ans<0)return 0;
            return ans;
        }
        if(pos==0 &zero>0)return 0;
        int n=nums.length;
        int i=0;
        int firstNeg=-1;
        int lastNeg=-1;
        while(i<n){
            if(nums[i]<0){
                firstNeg=i;
                break;
            }
            i++;
        }
        int t=n-1;
        while(t>=0){
            if(nums[t]<0){
                lastNeg=t;
                break;
            }
            t--;

        }
        int productLeft=1;
        int productRight=1;
        for(int k=0;k<firstNeg;k++){
            productLeft*=nums[k];
        }
        for(int j=nums.length-1;j>lastNeg;j--){

            productRight*=nums[j];
        }
        if(productLeft<productRight)return productRight;
        return productLeft;
    }
}
