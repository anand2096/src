package DSA.journey.BinarySearch;

public class SearchInRange {
    public static void main(String[] args) {
        int arr[]={ 4, 7, 7, 7, 8, 10, 10};
        int k=3;
        int ans []=new SearchInRange().searchRange(arr,k);
        System.out.println(ans[0]+" "+ans[1]);
   }


    public int[] searchRange(final int[] arr, int k) {
        int ans[]=new int[2];
        int left=-1;
        int right=-1;
        ans[0]=-1;ans[1]=-1;
        int low=0;
        int n=arr.length;
        if(n==1){
            int t[]=new int [2];
            t[0]=-1;
            t[1]=-1;
            if(arr[0]==k){
                t[0]=0;t[1]=0;
                return t;
            }
            return t;
        }
        int high=n-1;
        while(low<=high){

            int mid=(low+high)/2;

            if(arr[mid]<k){
                left=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }


        }

        low=0;
        high=n-1;
        while(low<=high){


            int mid=(low+high)/2;
            if(arr[mid]>k){
                right=mid;
                high=mid-1;

            }
            else{

                low=mid+1;

            }
        }

        if(left==-1) {

            if(arr[0]==k)
                ans[0]=0;

        }
        else{

            if (arr[left + 1] == k) {
                ans[0] = left + 1;
            }
        }
        if(right==-1) {
            if(arr[n-1]==k)
                ans[1]=n-1;

        }
        else{
            if (right-1>=0&&arr[right - 1] == k) {
                ans[1] = right - 1;
            }
        }

        return ans;

    }
}
