package DSA.Greedy.SwapAndMaximize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapAndMaximize {
//https://www.geeksforgeeks.org/maximize-sum-consecutive-differences-circular-array/
//https://www.youtube.com/watch?v=9AdbAjmLyok

    public static void main(String[] args) {
       // int n = 4;
        long a[] = {4, 2, 1, 8};

       // long a[] = {10,12};

        System.out.println(new SwapAndMaximize().maxSum(a,a.length));
    }

    long maxSumSpaceComplex(long arr[] ,int n)
    { //1 2 4 8
        //1 8 2 4
        long sum=0;
        Arrays.sort(arr);
        List<Long> numbers=new ArrayList<>();
        int i=0,j=n;
        while(i<j){
            long first=arr[i];
            long last=arr[j-1];
            numbers.add(first);numbers.add(last);
            i++;
            j--;
        }

        for(int t=1;t<numbers.size();t++){
            long first=numbers.get(t-1);
            long second=numbers.get(t);
            sum=sum+Math.abs(first-second);
        }
        sum=sum+Math.abs(numbers.get(0)-numbers.get(numbers.size()-1));


    return sum;
    }



    long maxSum(long arr[] ,int n){
        long sum=0;
        Arrays.sort(arr);
        int i=0,j=n-1;
        while(i<j)
        {
            sum= sum+Math.abs(arr[i]-arr[j]);
            sum=sum+Math.abs(arr[i+1]-arr[j]);
            i++;
            j--;

        }
        sum=sum+Math.abs(arr[0]-arr[i]);

        return sum;
    }
}
