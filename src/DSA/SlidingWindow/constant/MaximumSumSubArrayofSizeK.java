package DSA.SlidingWindow.constant;

public class MaximumSumSubArrayofSizeK {

    public static void main(String[] args) {
        int arr[]={2,5,1,8,2,9,1};
        System.out.println(new MaximumSumSubArrayofSizeK().maximumSumSubArray(arr,3));

    }

    public int maximumSumSubArray(int arr[],int k){
        int sum=0;
        int maxSum=0;
        for(int i=0;i<k;i++)
            sum=sum+arr[i];
        maxSum=sum;

        for(int i=k;i<arr.length;i++){
            sum=sum-arr[i-k];
            sum=sum+arr[i];
            if(sum>maxSum)maxSum=sum;
        }
     return maxSum;






    }
}
