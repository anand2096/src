package DSA.journey.slidingWindow;

public class SubArrayWithSumK {

    public static void main(String[] args) {
    int arr[]={84,-37,32,40,95};
    int k=167;
        System.out.println(new SubArrayWithSumK().subarraySum(arr,k));
    }

    public int subarraySum(int[] nums, int k) {
        int i=0;
        int j=0;
        int n=nums.length;
        if(n==1){
            if(nums[0]==k)return 1;
            else return 0;
        }
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(j<=n){
            if(j<n)
                sum=sum+nums[j];
            if(j<n&&sum<k){
                j++;
            }
            else{
                if(sum==k){
                    ans=Math.min(ans,j-i);
                    j++;
                }
                else{
                    while(i<n-1){
                        sum=sum-nums[i];
                        if(sum==k){
                            ans=Math.min(ans,j-i);
                        }
                        i++;
                    }
                    j++;
                }

            }
        }
        if(nums[n-1]==k)ans=Math.min(ans,j-i);;
        return ans;

    }
}
