//package DSA.Graph;
//
//
//import java.util.*;
//
//
////space complexity  O(N) for stack + O(N) for visited
//
////time complexity   O(N+2E) +O(N)
//
//public class CycleInGraph {
//
//    public static void main(String[] args) {
//        int V =5, E = 2;
//        int[][] adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
//       // int[][] adj = {{},{2},{1,3},{2}};
//        ArrayList<ArrayList<Integer>> adjList= new ArrayList<>();
//        for(int i=0;i<adj.length;i++){
//            int arr[]=adj[i];
//            ArrayList<Integer> list=new ArrayList<>();
//            for(int j=0;j< arr.length;j++)
//            list.add(arr[j]);
//            adjList.add(list);
//        }
//
//        System.out.println(new CycleInGraph().isCycle(V,adjList));
//    }
//
//public boolean checkForCycleBFS(int src,int v, ArrayList<ArrayList<Integer>> adj,boolean []vis){
//    vis[src]=true;
//    Queue<Pair> queue=new LinkedList<>();
//    queue.add(new Pair(src,-1));
//
//    while (!queue.isEmpty()){
//        int node= queue.peek().first;
//        int parent=queue.peek().second;
//        queue.remove();
//        //1,-1
//
//        for(int adjacentNode:adj.get(node)){
//            if(vis[adjacentNode]==false){
//                vis[adjacentNode]=true;
//                queue.add(new Pair(adjacentNode,node));
//            }
//            else if(parent!=adjacentNode){
//                return true;
//            }
//        }
//
//    }
//
//    return  false;
//
//}
//
//public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj, boolean []vis){
//
//        vis[node]=true;
//        for(int adjacentNode:adj.get(node)){
//
//            if(vis[adjacentNode]==false){
//                if(dfs(adjacentNode,node,adj,vis)==true){
//                    return true;
//                }
//            }
//            else if(adjacentNode!=parent){
//                return  true;
//            }
//        }
//        return false;
//}
//    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
//        boolean vis[]=new boolean[v];
//        for(int i=0;i<v;i++){
//            vis[i]=false;
//        }
////        for(int i=0;i<v;i++){
////            if(vis[i]==false){
////                if(checkForCycleBFS(i,v,adj,vis))return true;
////            }
////        }
//
//
//        for(int i=0;i<v;i++){
//            if(vis[i]==false){
//                if(dfs(i,-1,adj,vis))return true;
//            }
//        }
//        return false;
//
//    }
//
//}
