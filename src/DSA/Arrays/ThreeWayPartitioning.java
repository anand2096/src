package DSA.Arrays;

public class ThreeWayPartitioning {

    public static void main(String[] args) {

        int arr[]={3,4,1,6,2,8};
        int a=1;
        int b=2;
        threeWayPartition(arr,a,b);
    }
    //Function to partition the array around the range such
    //that array is divided into three parts.
    public static void threeWayPartition(int arr[], int a, int b)
    {
        int lo=0,mid=0,hi=arr.length-1;
        while(mid<=hi){
            if(arr[mid]<a){
                swap(arr,lo,mid);
                lo++;mid++;
            }else if(arr[mid]>=a &&arr[mid]<=b){
                mid++;
            }else{
                swap(arr,hi,mid);
                hi--;
            }
        }

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ,");
    }

    public static void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    }


