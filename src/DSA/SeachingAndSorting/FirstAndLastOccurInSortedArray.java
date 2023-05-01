package DSA.SeachingAndSorting;

import java.util.ArrayList;

public class FirstAndLastOccurInSortedArray {

    public static void main(String[] args) {
        long arr[]={ 1, 3, 5, 5, 5, 5, 7, 123, 125 };
        int k=100;

        System.out.println(new FirstAndLastOccurInSortedArray().find(arr,arr.length,k));



    }




    ArrayList<Long> find(long arr[], int n, int x)
    {
        ArrayList<Long> ans=new ArrayList<>();
        long first=0;
        long last=0;
        long icount=0;
        long jcount=0;
        int i=0;
        int j=arr.length-1;
        while(i<=j){

            if(arr[i]==x&&icount==0){
                icount=1;
                first=i;
            }
            if(arr[j]==x&&jcount==0){
                jcount=1;
                last=j;

            }
            if(icount<1)
                i++;
            if(jcount<1)
                j--;


            if(icount==1&&jcount==1)
            {ans.add(first);ans.add(last);

                break;
            }

        }
        if(icount==0&&jcount==0){
            ans.add(Long.valueOf(-1));
            ans.add(Long.valueOf(-1));
        }

        return ans;



    }



//    USIG BINARY SEARCH:
    int left_Most(int arr[],int n,int num)
    {
        int st=0,end=n-1,ans=-1;
        int mid=st+(end-st)/2;
        while(st<=end)
        {
            if(arr[mid] == num)
            {
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>num)
            {
                end=mid-1;
            }
            else
            {
                st=mid+1;
            }
            mid=st+(end-st)/2;

        }
        return ans;
    }
    // right most
    int right_Most(int arr[],int n,int num)
    {
        int st=0,end=n-1,ans=-1;
        int mid=st+(end-st)/2;
        while(st<=end)
        {
            if(arr[mid] == num)
            {
                ans=mid;
                st=mid+1;
            }
            else if(arr[mid]>num)
            {
                end=mid-1;
            }
            else
            {
                st=mid+1;
            }
            mid=st+(end-st)/2;

        }
        return ans;
    }
}
