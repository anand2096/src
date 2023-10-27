package DSA.journey.backracking;

import DSA.CommonFun;

import java.util.*;


public class subsets {
    public static void main(String[] args) {

        int arr[]={9,-20,-11,-8,-4,2,-12,14,1,-18};
        System.out.println(new subsets().subsets(CommonFun.createInput(arr)));
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {
        Collections.sort(list);

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> curr=new ArrayList<Integer>();
        rec(0,list,list.size(),curr,ans);
        Collections.sort(ans, new LexicographicComparator());
        return ans;


    }

    public void rec(int index,ArrayList<Integer> list,int n,ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> ans){

        if(index>=n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        rec(index+1,list,n,curr,ans);
        curr.add(list.get(index));
        rec(index+1,list,n,curr,ans);
        curr.remove(curr.size()-1);


    }
}
class LexicographicComparator implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0)
                return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}