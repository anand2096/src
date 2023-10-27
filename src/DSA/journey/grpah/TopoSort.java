package DSA.journey.grpah;
import java.util.*;
public class TopoSort {
    public static void main(String[] args) {
        int A = 6;
        int [][]B = {  {6, 3} ,
                {6, 1} ,
                {5, 1} ,
                {5, 2} ,
                {3, 4} ,
                {4, 2} };
        int ans[]=new TopoSort().solve(A,B);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public int[] solve(int A, int[][] B) {
        Stack<Integer> st=new Stack<>();
        Set<Integer> set=new TreeSet<>();
        boolean vis[]=new boolean[A+1];
        boolean pathVis[]=new boolean[A+1];
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            int u=B[i][0];
            int v=B[i][1];
            adjList.get(u).add(v);
        }


        for(int i=1;i<=A;i++){
            boolean ans=dfs(i,adjList,set,vis,pathVis);
            if(ans){
                return new int[0];
            }
        }

        int fans[]=new int[set.size()];

            int j=0;
            for(int val:set){
                fans[j++]=val;
            }

        return fans;


    }
    public boolean dfs(int node,List<List<Integer>>adjList,Set<Integer> set,boolean vis[],boolean []pathVis ){
        vis[node]=true;
        pathVis[node]=true;


        for(int ind:adjList.get(node)){

            if(!vis[ind]){
                if(dfs(ind,adjList,set,vis,pathVis))return true;
            }
            else if(pathVis[ind])
                return true;
        }
        pathVis[node]=false;
        set.add(node);
        return false;
    }


}
