package DSA.journey.grpah;
import  java.util.*;
public class FirstDepthFirstSearch {

    public static void main(String[] args) {
        int arr[]={1,1,1,3,3,2,2,7,6};
        int s=1;
        int d=9;
        System.out.println(new FirstDepthFirstSearch().solve(arr,d,s));
    }

    public int solve(int[] A, final int B, final int C) {
        int n=A.length;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adjList.add(new ArrayList<>());
        for(int i=1;i<A.length;i++){

            int u=A[i];
            adjList.get(u).add(i+1);

        }
     //   System.out.println(adjList);
        int src=C;
        int des=B;
        boolean vis[]=new boolean [n+1];
        isPath(C,B,adjList,vis);
        if(vis[des])return 1;return 0;
    }

    public void isPath(int src,int des,List<List<Integer>> adjList, boolean []vis){
        vis[src]=true;

        for(int i:adjList.get(src)){

            if(!vis[i]){
                isPath(i,des,adjList,vis);
            }
        }
    }
}
