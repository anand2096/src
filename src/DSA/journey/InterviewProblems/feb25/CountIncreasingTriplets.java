package DSA.journey.InterviewProblems.feb25;

import DSA.CommonFun;

import java.util.ArrayList;

public class CountIncreasingTriplets {

    public static void main(String[] args) {
        int arr[]={2, 1, 2, 3};
        System.out.println(new CountIncreasingTriplets().solve(CommonFun.createInput(arr)));

    }
    public int solve(ArrayList<Integer> A) {
        int ans=0;
        for(int i=1;i<A.size()-1;i++){
            int current=A.get(i);
            int left=0;
            int right=0;
            for(int j=i-1;j>=0;j--){
                if(A.get(j)<current){
                    left++;
                }
            }
            for(int k=i+1;k<A.size();k++){
                if(A.get(k)>current){
                    right++;
                }
            }
            ans=ans+(left*right);

        }
        return ans;
    }

}
