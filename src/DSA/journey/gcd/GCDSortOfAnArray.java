package DSA.journey.gcd;

public class GCDSortOfAnArray {

    public static void main(String[] args) {
    int nums []  = {7,21,3};
        System.out.println(new GCDSortOfAnArray().gcdSort(nums));

    }

    public boolean gcdSort(int[] nums) {
        boolean visited[]=new boolean[nums.length];
        return rec(0,nums,visited);
    }

    public boolean rec(int index, int [] nums, boolean visited[]){

        if(index>=nums.length){
            for(int j=1;j<nums.length;j++){
                if(nums[j]<nums[j-1])
                {return false;

                }
            }
            return true;
        }
        for(int i=0;i<nums.length;i++){
                if (  gcd(nums[index], nums[i]) > 1) {
                    if(!visited[i] && !visited[index]) {
                        swap(nums, index, i+1);
                        visited[index]=true;
                        rec(i + 1, nums, visited);
                        swap(nums, index, i+1);
                        visited[index]=false;
                    }
                } else {
                    rec(i, nums,visited);
                }

        }

        return false;


    }


    public int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }

    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
