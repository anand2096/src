package DSA.journey.DynamicProgramming;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class PairK{
    int wt;
    int val;
    double ratio;
    public PairK(int wt,int val,double ratio){
        this.wt=wt;
        this.val=val;
        this.ratio=ratio;
    }
}
public class FractionalKnapscak {

    public static void main(String[] args) {
        int val[]={16,3,3,6,7,8,17,13,7};
        int w[]={3,10,9,18,17,17,6,16,13};
        int k=11;
        System.out.println(new FractionalKnapscak().solve(val,w,k));
    }
    public int solve(int[] v, int[] w, int k) {
        List<PairK> list=new ArrayList<>();
        for(int i=0;i<v.length;i++){
            PairK p=new PairK(w[i],v[i],w[i]/v[i]);
            list.add(p);
        }
        Collections.sort(list,(l1, l2)-> (int) (l1.ratio-l2.ratio));
        int ans=0;
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i).wt<=k){
                ans=ans+list.get(i).val;
                k=k-list.get(i).wt;
            }
            else{
                ans= (int) (ans+(k*(list.get(i).ratio)));
                break;
            }
        }
        return ans*100;


    }
}


