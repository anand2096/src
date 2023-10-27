package DSA.journey.grpah;
import  java.util.*;
public class Batches {
    int sum;
    public static void main(String[] args) {
       int A = 7;
        int [] B = {1, 6, 7, 2, 9, 4, 5};
      int [][]  C = {  {1, 2}, {2, 3},{5, 6}, {5, 7}  };
        int D = 12;
        System.out.println( new Batches().solve(A,B,C,D));
    }

    public int solve(int A, int[] B, int[][] C, int D) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }
        boolean vis[]=new boolean[A+1];
        for(int i=0;i<C.length;i++){
            int u=C[i][0];
            int v=C[i][1];
            adjList.get(u).add(v);
        }
        int ans=0;
        for(int i=1;i<=A;i++){

            if(!vis[i]){
                 sum=0;
                dfs(i,adjList,vis,B);
                if(sum>=D){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int node,List<List<Integer>> adjList,boolean []vis,int []B){
        vis[node]=true;
        sum=sum+B[node-1];

        for(int i:adjList.get(node)){
            if(!vis[i]){

                dfs(i,adjList,vis,B);
            }
        }
    }
}
