package DSA.leetCodeDaily;

public class BinarySearch {


    public static void main(String[] args) {
        int arr[]={-1,0,3,5,9,12};
        int k=2;
        System.out.println(new BinarySearch().search(arr,k));
    }

    public int search(int[] nums, int target) {
        return bSearch(nums,0,nums.length-1,target);
    }
    public int bSearch(int nums[], int s,int e ,int k){
        if(e>=s) {
            int mid = (s + e) / 2;

            if (nums[mid] == k) {
                return mid;
            } else if (nums[mid] < k) {

                int ans = bSearch(nums, mid + 1, e, k);
                if (ans != -1) return ans;

            } else if (nums[mid] > k) {
                int ans = bSearch(nums, s, mid - 1, k);
                if (ans != -1) return ans;
            }
        }

        return -1;
    }

}
