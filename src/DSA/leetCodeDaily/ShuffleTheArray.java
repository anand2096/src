package DSA.leetCodeDaily;

public class ShuffleTheArray {

    public static void main(String[] args) {
        int nums []= {2,5,1,3,4,7}; int  n = 3;
       int ans[]= new ShuffleTheArray().shuffle(nums,n);
       for(int i=0;i<ans.length;i++)
        System.out.print(ans[i] +" ");
    }
    public int[] shuffle(int[] nums, int n) {

        int i=1;
        int j=n;
        while(j<nums.length) {
            int temp = nums[j];
            int t = j;
            while (t > i) {
                nums[t] = nums[t - 1];
                t--;
            }
            nums[i] = temp;
            i = i + 2;
            j = j + 1;
        }

 return  nums;
    }
}
