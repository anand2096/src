package DSA.journey.Array1d_1march;

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {
        int [] A = {1, 2, 3, 4, -10};
        System.out.println(new MaxSumContiguousSubarray().maxSubArray(A));

    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {

        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            sum=sum+A[i];
            ans=Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
}
