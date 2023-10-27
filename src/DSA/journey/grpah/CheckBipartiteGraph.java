//package DSA.journey.grpah;
//import java.util.*;
//public class CheckBipartiteGraph {
//
//    public int solve(int A, int[][] B) {
//
//        List<List<Integer>> adjList=new ArrayList<>();
//        for(int i=0;i<A;i++){
//            adjList.add(new ArrayList<>());
//        }
//        for(int i=0;i<B.length;i++){
//            int u=B[i][0];
//            int v=B[i][1];
//            adjList.get(u).add(v);
//            adjList.get(v).add(u);
//        }
//        int color[]=new int[A];
//        Arrays.fill(color,-1);
//        for(int i=0;i<A;i++){
//            if(color[i]==-1){
//                //  color[i]=0;
//                if(!dfs(i,color,adjList)) return 1;
//            }
//        }
//        return 0;
//    }
//    public boolean dfs(int node,int[]color,List<List<Integer>> adjList){
//
//        for(int i:adjList.get(node)){
//            if(color[node]==color[i]){
//                return false;
//            }
//            else if(color[i]==-1){
//                color[i]=1-color[node];
//                if(!dfs(i,color,adjList))return false;
//            }
//        }
//
//    }
//}
