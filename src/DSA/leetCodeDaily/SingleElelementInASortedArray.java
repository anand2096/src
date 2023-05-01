package DSA.leetCodeDaily;

public class SingleElelementInASortedArray {

    public static void main(String[] args) {
        int []nums = {3,3,7,7,10,11,11};
        System.out.println(new SingleElelementInASortedArray().BinarySearchSingleNonDuplicate(nums));
    }

    public int BinarySearchSingleNonDuplicate(int[] nums) {
        int high=nums.length-1;
        int low=0;
        int mid;
        if(high==0)return nums[0];
        else if(nums[0]!=nums[1]) return nums[0];
        else if(nums[high]!=nums[high-1]) return nums[high];
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            if(((mid%2)==0 && nums[mid]==nums[mid+1])||((mid%2)==1) && nums[mid]==nums[mid-1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
    return -1;

    }
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int i=0;
        int j=nums.length-1;
        int ans=-1;
        while(i<=j){

            if(nums[i]!=nums[i+1]) {
                ans=nums[i];
                break;
            }
            if(nums[j-1]!=nums[j]){
                ans=nums[j];
                break;
            }
            i=i+2;
            j=j-2;
        }

        return ans;



    }
}
