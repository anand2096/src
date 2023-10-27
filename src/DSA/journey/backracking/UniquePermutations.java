package DSA.journey.backracking;

import DSA.CommonFun;

import java.util.ArrayList;

public class UniquePermutations {
    public static void main(String[] args) {
        int arr[]={1,1,2};
        System.out.println(new UniquePermutations().permute(CommonFun.createInput(arr)));
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list) {
        int n=list.size();
        boolean [] vis=new boolean[n];
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        rec(list,vis,new ArrayList<Integer>(),ans,n);
        return ans;


    }
    public void rec(ArrayList<Integer> nums,boolean[]vis,ArrayList<Integer>curr,ArrayList<ArrayList<Integer>>ans,int n){

        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        int i;
        for( i=0;i<n;i++){
            if(!vis[i] ){
//                if(i!=0){
//                    if(nums.get(i)==nums.get(i-1)){
//                        continue;
//                    }
//                }
                vis[i]=true;
                curr.add(nums.get(i));
                rec(nums,vis,curr,ans,n);
                curr.remove(curr.size()-1);
                vis[i]=false;
            }
//            while(i<n &&i+1<n && nums.get(i)==nums.get(i+1)){
//                i++;
//            }

        }


    }
}
