package DSA.journey.BinarySearch;

public class MatrixMedian {

    public static void main(String[] args) {

    }

    public int findMedian(int [][]nums){

        long low=1;
        long high=(int)Math.pow(10,9);
        int n=nums.length;
        int m=nums[0].length;
        while(low<=high){
            long mid=(low+(high-low)/2);
            int cnt=0;
            for(int i=0;i<n;i++){
                cnt=cnt+countSmallerThanMid(nums[i],mid);
            }
            if(cnt<=(n*m)/2){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return (int)low;
    }

    private int countSmallerThanMid(int[] row, long mid) {
        int l=0;
        int h=row.length-1;
        while(l<=h){
            int md=(l+(h-l)/2);
            if(row[md]<=mid){
                l=md+1;
            }
            else{
                h=md-1;
            }
        }
        return l;
    }
}
