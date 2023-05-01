package DSA.SeachingAndSorting;

public class MinimumSwapsToSort {
    public static void main(String[] args) {


            int arr[]={7 ,16 ,14 ,17 ,6 ,9 ,5 ,3 ,18};
        System.out.println(MinimumSwapsToSort.minSwaps(arr));
    }
    //Function to find the minimum number of swaps required to sort the array.
    public static int minSwaps(int nums[])
    {
        // Code here
        int cnt=0;
        for(int i=0;i<nums.length;i++){

            int  min=nums[nums.length-1];
            int minIndex=nums.length-1;
            int j=nums.length-2;
            while(i<j){
                if(nums[j]<min)
                { min=nums[j];
                    minIndex=j;
                }

                j--;
            }
            if(nums[i]>nums[minIndex]){
                int temp=nums[i];
                nums[i]=nums[minIndex];
                nums[minIndex]=temp;
                cnt++;
            }
        }
        return cnt;
    }
}
