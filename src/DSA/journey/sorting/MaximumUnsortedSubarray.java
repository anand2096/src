package DSA.journey.sorting;

import java.util.Arrays;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
     //  int arr[]={ 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 };
      // int arr[]={  4, 15, 4, 4, 15, 18, 20 };
        int arr[]={ 1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20, 20 };

                 // 0   1  2  3 4  5  6  7   8  9  10  11  12  13  14  15  16  17  18
        //int arr[]={ 1,2,3,4,5};
        int ans[]=new MaximumUnsortedSubarray().subUnsort2(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public int[] subUnsort(int[] arr) {
        int ans[]=new int[2];
        int n=arr.length;
        int brr[]=new int[n];
        for(int i=0;i<n;i++){
            brr[i]=arr[i];
        }
        Arrays.sort(arr);
        int i=0;
        while(i<n&&arr[i]==brr[i]){
            i++;
        }
        if(i==n){
            int a[]=new int[1];
            a[0]=-1;
            return a;
        }
        else {
            ans[0] = i;
            int j=n-1;
            while (j >=0  && arr[j] == brr[j]) {
                j--;
            }
            ans[1] = j;
        }
        return ans;


    }


    public int[] subUnsort2(int[] arr){
        int n=arr.length;
        int ans[]=new int[2];
        int l=-1;
        int r=-1;
        int i;
        for(i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                break;
            }
        }
        if(i==n){
            int []a= new int [1];
            a[0]=-1;
            return a;
        }
        else{

            ans[0]=i-1;
            int j;
            for(j=n-2;j>=0;j--){
                if(arr[j]>=arr[j+1]){
                    break;
                }
            }

            ans[1]=j+1;
            return ans;
        }

    }
}
