package DSA.leetCodeDaily;

import java.util.Collections;
import java.util.*;

class Event{
    int st;
    int et;
    int val;
    public Event(int st,int et,int val){
        this.st=st;
        this.et=et;
        this.val=val;
    }
}
public class MaximumEventsAttend {
  //  int ans=Integer.MIN_VALUE;

    public static void main(String[] args) {
      int [][]mat=  {{1,2,4},{3,4,3},{2,3,10}};
      int k=2;
        System.out.println( new MaximumEventsAttend().maxValue(mat,k));
    }
    public int maxValue(int[][] events, int k) {
        int ans=Integer.MIN_VALUE;
        List<Event> list=new ArrayList<>();
        for(int i=0;i<events.length;i++){
            list.add(new Event(events[i][0],events[i][1],events[i][2]));
        }
        int dp[]=new int[events.length+1];
        Arrays.fill(dp,-1);
        Collections.sort(list,(e1,e2)->e1.st-e2.st);

        rec(0,k,0,0,list,null,dp);
        for(int i=0;i<dp.length;i++)
            ans=Math.max(dp[i],ans);
        return ans;


    }
    public int rec(int index,int k,int pk,int profit,List<Event> list, Event lastEve,int []dp){
        // if(pk==k){
        //     ans=Math.max(ans,profit);
        //     return;
        // }
        if(index>=list.size()){
            if(pk<=k){
                // ans=Math.max(ans,profit);
                return profit;
            }
            else
                return Integer.MIN_VALUE;
        }
        //if(dp[index]!=-1)return dp[index];
        int ch1=Integer.MIN_VALUE;
        int ch2=Integer.MIN_VALUE;
        //pick
        if((lastEve==null || lastEve.et< list.get(index).st))
            ch1=rec(index+1,k,pk+1,profit+list.get(index).val,list,list.get(index),dp);
        // not pick
        ch2=rec(index+1,k,pk,profit,list,lastEve,dp);
        dp[index]=Math.max(ch1,ch2);
        return dp[index];

    }
}
