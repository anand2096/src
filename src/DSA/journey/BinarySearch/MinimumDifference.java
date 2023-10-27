package DSA.journey.BinarySearch;

import java.util.Arrays;

public class MinimumDifference {

    public static void main(String[] args) {

    }

    public int solve(int m, int n, int[][] mat) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            Arrays.sort(mat[i]);
        }

        for(int i=0;i<m-1;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){




                int element=mat[i][j];
                int closestElement=BS(0,mat[i+1].length-1,mat[i+1],element);
                min=Math.min(min,Math.abs(element-closestElement));

            }
            ans=Math.min(ans,min);
        }
        return ans;
    }
    public int BS(int low,int high,int []nums,int target){
        int min=Integer.MAX_VALUE;
        int index=-1;
        int mid=0;
        while(low<=high){
            mid=(low+(high-low)/2);
            int diff=Math.abs(nums[mid]-target);
            if(diff<min){
                min=diff;
                index=mid;
            }
            if(nums[mid]==target){
                return nums[mid];
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return nums[index];
    }

}
