package DSA.journey.backracking;

import java.util.ArrayList;

public class Permutations {
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
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                curr.add(nums.get(i));
                rec(nums,vis,curr,ans,n);
                curr.remove(curr.size()-1);
                vis[i]=false;
            }
        }

    }
}
