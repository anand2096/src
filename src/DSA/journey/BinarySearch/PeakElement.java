package DSA.journey.BinarySearch;

public class PeakElement {

    public static void main(String[] args) {

    }

    public int solve(int[] arr) {
        int n=arr.length;

        int mid=0;
        if(n==1)return arr[0];
        if(arr[0]>arr[1]){
            return arr[0];
        }
        if(arr[n-1]>arr[n-2]){
            return arr[n-1];
        }
        int low=1;
        int high=n-2;
        while(low<=high){
            mid=(low+(high-low)/2);
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return arr[mid];

            }
            if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return arr[mid];


    }
}
