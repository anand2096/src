package DSA.SeachingAndSorting;

import java.util.Arrays;

public class FindPairWithGivenDiff {
    public static void main(String[] args) {
        int arr[] = {5, 20, 3, 2, 5, 80};
        //2,3,5,5,20,80   78
        System.out.println(new FindPairWithGivenDiff().findPair(arr,arr.length,45));
    }
//    public int findPairUsing2Pointers(int arr[], int size, int n)
//    {
//        DSA.Arrays.sort(arr);
//        int output=-1;
//        for(int i=0;i<size;i++)
//        {int temp=arr[i];
//            int eleSe=n+temp;
//
//
//        }
//
//    }

    public int findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int output=-1;
        for(int i=0;i<size;i++)
        {int temp=arr[i];
            int eleSe=n+temp;
            int ans=binarySearch(arr,i+1,size-1,eleSe);
            if(ans!=-1)
            {
                output=1;
                return output;
            }


        }
    return output;
    }
    public static int binarySearch(int arr[],int low,int high,int key){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==key)
                return mid;
            if(key>arr[mid]){
               return binarySearch(arr,mid+1,high,key);
            }
            else
               return binarySearch(arr,low,mid-1,key);
        }
        return -1;


    }
}