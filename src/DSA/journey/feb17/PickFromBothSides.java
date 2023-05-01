package DSA.journey.feb17;


import java.util.ArrayList;
import java.util.Arrays;

//https://www.scaler.com/academy/mentee-dashboard/class/61827/homework/problems/9900?navref=cl_tt_nv
public class PickFromBothSides {


    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        int arr[] ={5,-2,3,1,2};
        for(int i=0;i<arr.length;i++){
            al.add(arr[i]);
        }
        int b = 3;
//        al.add(2);al.add(3);al.add(-1);al.add(4);al.add(2);al.add(1);
//       int b = 4;
//        al.add(5);al.add(-2);al.add(3);al.add(1);al.add(2);
//        int b = 3;


//        int arr[]={2, 3, -1, 4, 2, 1};
//        int b=4;
        System.out.println(new PickFromBothSides().solve(arr, b));

    }
    public int solve(int[] arr, int k) {
        int n=arr.length;
        int ans=Integer.MIN_VALUE;
        int []prefixArray=new int[arr.length];
        prefixArray[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixArray[i]=prefixArray[i-1]+arr[i];
        }
        for(int i=0;i<=k;i++){
           // int sum=0;
            if(i==0){
                ans=Math.max(ans,prefixArray[n-1]-prefixArray[n-k-1]);
            }
//            else if(i==k){
//                sum=prefixArray[k-1];
//            }
            else{
                int start=i;
                int end=k-i;
                ans=Math.max(ans,prefixArray[start-1]+prefixArray[n-1]-prefixArray[n-end-1]);

            }
        }


        return ans;
    }
    public int solve(ArrayList<Integer> list, int k) {
        int ans = -Integer.MIN_VALUE;
        int[] prefixSumArray = new int[list.size()];
        prefixSumArray[0] = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + list.get(i);
        }

        if(k==list.size()){
            return prefixSumArray[list.size()-1];
        }

        int s=0;
        while(s<=k){
            int end=k-s;
            int  endIndex=list.size()-end;
            if(s==0){
              ans=Math.max(ans,prefixSumArray[list.size()-1]-prefixSumArray[endIndex-1]);
              //  ans=Math.max(ans,prefixSumArray[endIndex]);
            }
            else{
                int temp=prefixSumArray[s-1]+(prefixSumArray[list.size()-1]-prefixSumArray[endIndex-1]);
                ans=Math.max(ans,temp);
            }
            s++;
        }
        return ans;

    }
}
