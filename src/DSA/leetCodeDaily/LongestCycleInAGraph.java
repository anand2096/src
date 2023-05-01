package DSA.leetCodeDaily;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LongestCycleInAGraph {


    int max=Integer.MIN_VALUE;

    public static void main(String[] args) {
       BigInteger  d= new BigInteger("678728391838182039102");
        System.out.println(d);
        int [] edges = {2,-1,3,1};
        System.out.println(new LongestCycleInAGraph().longestCycle(edges));

    }
    public int longestCycle(int[] edges) {
        int n=edges.length;
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            adj.add(new ArrayList<>());

        }
        for(int i=0;i<edges.length;i++){
            if(edges[i]!=-1)
            adj.get(i).add(edges[i]);
        }
        int vis[]=new int[edges.length];
        int pathVis[]=new int [edges.length];

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,i,0,adj,vis,pathVis);
            }

        }
        if(max==Integer.MIN_VALUE)
            return -1;
        return max;

    }

    private void dfs(int par,int index, int count, List<List<Integer>> adj, int[] vis, int[] pathVis) {

        vis[index]=1;
        pathVis[index]=1;
        for(int child:adj.get(index)){
            if(vis[child]==0){
                dfs(par,child,count+1,adj,vis,pathVis);
            }
            else if(pathVis[child]==1){
                if(child==par){
                    max=Math.max(max,count+1);
                }
                else {
                    int c=0;
                    int val=countDes(par,0,child,adj);
                    val=val-1;

                    max = Math.max(max, count-val);
                }
            }
        }
        pathVis[index]=0;
    }

    public int countDes(int node,int c,int des,List<List<Integer>> adj){
        if(node==des){
            return c;
        }
        else{
            for(int ch: adj.get(node)){
                return  countDes(ch,c+1,des,adj);
            }
        }
        return -1;
    }
}
