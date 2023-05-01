package DSA.journey.BitManipulation;

import DSA.CommonFun;

import java.util.ArrayList;

public class SubArraysWithBitwiseOR1 {
    public static void main(String[] args) {
//        int a=9;
//        int arr[]={1,0,0,1,0,1,0,0,0};

        int arr[]={1, 0, 1};

        System.out.println(new SubArraysWithBitwiseOR1().solve(arr.length, CommonFun.createInput(arr)));
    }

    public Long solve(int n, ArrayList<Integer> list) {
        long possibleSubarrays=(long)(n*(n+1))/2;
        long zeroCount=0;
        //long count=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==0) {
                zeroCount++;
            }
            else{
                possibleSubarrays-=(zeroCount*(zeroCount+1))/2;
                zeroCount=0;
            }
        }
        possibleSubarrays-=(zeroCount*(zeroCount+1))/2;
        return possibleSubarrays;
    }

    public long solve(int A, int[] B) {

        long cnt = (long) A*(A+1)/2;
        long n = 0;
        for(int i=0; i<A; i++){
            if(B[i]==0){
                n++;
            }else {
                cnt -= n*(n+1)/2;
                n=0;
            }
        }
        cnt -= n*(n+1)/2;
        return cnt;
    }
        }


