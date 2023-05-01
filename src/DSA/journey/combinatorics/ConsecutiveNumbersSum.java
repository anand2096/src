package DSA.journey.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumbersSum {

    public static void main(String[] args) {
        System.out.println(new ConsecutiveNumbersSum().solve(53547));
    }

    public int solve(int n) {
        int count =0;
    for(int k=1;2*n>k*(k-1);k++){
        int numerator=n-(k*(k-1)/2);
        if(numerator%k==0)
            count++;
    }

    return count;
    }
    public int solve1(int num) {
        if(num==1)
            return 1;
        int count=0;
        int arr[]=new int [num];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        int sum=0;
        int i=0;
        int j=0;
        while(j<arr.length){
            if(sum<num) {
                sum = sum + arr[j];
                j++;
            }
            else {
                if(sum==num){
                    count++;
                }
                while(i<arr.length && sum>num){
                    sum=sum-arr[i];
                    if(sum==num){
                        count++;
                    }
                    i++;
                }
                sum=sum+arr[j];
                j++;

            }
        }
        while(i<arr.length && sum>num){
            sum=sum-arr[i];
            if(sum==num){
                count++;
            }
            i++;
        }

        return count;

    }
}
