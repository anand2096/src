package DSA.journey.Greedy;

import java.util.Comparator;
import java.util.*;
class Pair{
    int t;
    int p;
    public Pair(int t,int p){
        this.t=t;
        this.p=p;
    }
}

class MyComp implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2){

        if(p1.t<p2.t)return -1;
        else if(p1.t>p2.t)return 1;
        else{
            if(p1.p<p2.p) return 1;
            else return -1;
        }
    }
}
public class FreeCars {
    public static void main(String[] args) {
        int time[]={1,3,1,7,2,7,1,7,6,7,8,3,3,5,4,4,5};
        int p[]={2,4,6,8,4,4,4,11,8,11,8,7,7,7,6,10,4};
        System.out.println( new FreeCars().solve(time,p));
    }
    public int solve(int[] time, int[] profit) {

        List<Pair> list=new ArrayList<>();
        for(int i=0;i<time.length;i++){
            Pair p=new Pair(time[i],profit[i]);
            list.add(p);
        }

        Collections.sort(list,new MyComp());

        int currTime=0;
        int ans=0;
        for(int i=0;i<list.size();i++){
            if(currTime<=list.get(i).t-1){
                ans=ans+list.get(i).p;
                currTime++;
            }

        }
        return ans;


    }
}
