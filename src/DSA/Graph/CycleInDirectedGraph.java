package DSA.Graph;

import java.util.List;

public class CycleInDirectedGraph {

    public static void main(String[] args) {

    }


    public boolean isCycle( List<List<Integer>> adj,int V){
        int vis[]=new int[V];
        int pathVis[]=new int [V];
        for(int i=0;i<V;i++){
                if(vis[i]==0) {
                    if (dfs(i, adj, vis, pathVis)) {
                        return true;
                    }
                }
        }
        return false;
    }
    private boolean dfs(int node, List<List<Integer>> adj,int vis[],int pathVis[]){
        vis[node]=1;
        pathVis[node]=1;
        for(int child:adj.get(node)){
            if(vis[child]==0){
                if(dfs(child,adj,vis,pathVis))
                    return true;
            }
            else if(pathVis[child]==1)
                return true;
        }

        pathVis[node]=0;
        return false;
    }
}
