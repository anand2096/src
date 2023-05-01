package DSA.journey.BinarySearch;

import java.util.Arrays;

public class AllocateBooks {
    public static void main(String[] args) {
        int A []= {73, 58, 30, 72, 44, 78, 23, 9  };
       int  B =5;
//        int A []= {12, 34, 67, 90 };
//        int  B =2;
        System.out.println(new AllocateBooks().books(A,B));
    }
    public int books(int[] arr, int b) {
        if(b > arr.length) return -1;
        int ans=-1;
        int n=arr.length;
        //  Arrays.sort(arr);
        int low=arr[0];
        int high=0;
        for(int i=0;i<n;i++){
            high=high+arr[i];
            low = Math.min(low, arr[i]);
        }
        while(low<=high){
            int mid=(low+high)/2;

            if(isPossible(arr,mid,b)){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public boolean check(int arr[],int students,int mid){
        int count =1;
        int s=0;
        for(int i=0;i<arr.length;i++){
            s=s+arr[i];
            if(s>mid){
                count++;
                s=arr[i];
            }
        }

        return count<=students;
    }
    private boolean isPossible(int arr[], int pages, int students) {
        int cnt = 1;
        int sumAllocated = 0;
        for(int i = 0;i<arr.length;i++) {
            if(sumAllocated + arr[i] > pages) {
                cnt++;
                sumAllocated = arr[i];
                if(sumAllocated > pages) return false;
            }
            else {
                sumAllocated += arr[i];
            }
        }
        return (cnt <= students);

    }
}
