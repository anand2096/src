package DSA.leetCodeDaily;

public class QuickSort {

    public static void main(String[] args) {
        int nums[]={5,4,3,2,1};
        int ans[]=new QuickSort().sortArray(nums);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int []nums,int low,int high){
        if(low<high){
            int pi=partition(nums,low,high);
            quickSort(nums,low,pi-1);
            quickSort(nums,pi+1,high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot=nums[high];
        int i=(low-1);
        for(int j=low;j<=high;j++){
            if(nums[j]<pivot){
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i+1,high);
        return i+1;


    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
