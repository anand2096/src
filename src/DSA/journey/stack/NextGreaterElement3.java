package DSA.journey.stack;

public class NextGreaterElement3 {
//https://leetcode.com/problems/next-greater-element-iii/description/
    public static void main(String[] args) {

        int n=12222333;
        System.out.println(new NextGreaterElement3().nextGreaterElement(n));


    }
    public int nextGreaterElement(int n) {
        String s=String.valueOf(n);
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            nums[i]=s.charAt(i)-'0';

        }
        int []next=nextPermutation(nums);
        int nextNo=0;
        for(int i=0;i<next.length;i++){
            nextNo=nextNo*10+next[i];
        }
        if(nextNo>n)return nextNo;
        return -1;

    }
    public int[] nextPermutation(int[] nums){
        if(nums.length==1)return nums;
        int n=nums.length;
        int i=n-2;
        while(i>=0 &&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=n-1;
            while(nums[i]>=nums[j]){
                j--;
            }

            swap(i,j,nums);
        }
        reverse(nums,i+1,n-1);

        return nums;
    }
    private void reverse(int[] nums, int i, int j) {
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    private void swap(int i, int j, int[] nums) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }



}
