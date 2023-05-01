package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {


    public static void main(String[] args) {
        int [][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        int n=7;

        //    int n=100000;


        System.out.println(new CountUnreachablePairsOfNodesInAnUndirectedGraph().countPairs(n,edges));
    }

    public long countPairs(int n, int[][] edges) {
        long ans=0,sum=n;
        boolean visited[]=new boolean[n];
        List<List<Integer>> adjList =new ArrayList<>();
        List<List<Integer>> dfsList =new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
    for(int i=0;i<edges.length;i++){
        adjList.get(edges[i][0]).add(edges[i][1]);
        adjList.get(edges[i][1]).add(edges[i][0]);
    }
    for(int i=0;i<n;i++){
     if(!visited[i]){
         List<Integer> temp=new ArrayList<>();
        dfs(i,visited,adjList,temp);
        sum=sum-temp.size();
        ans=ans+(temp.size()*sum);
        //dfsList.add(temp);
        }
    }

    if(dfsList.size()==1)
    {
        return 0;
    }
//    for(int i=0;i<dfsList.size();i++){
//        for(int j=i+1;j<dfsList.size();j++){
//            ans=ans+(dfsList.get(i).size()*dfsList.get(j).size());
//        }
//    }

        return ans;
    }

    private void dfs(int index,boolean vis[], List<List<Integer>> adjList, List<Integer> curList) {
        vis[index]=true;
        curList.add(index);
        for(int child:adjList.get(index)){
            if(!vis[child]){
                dfs(child,vis,adjList,curList);
            }

        }
    }


}
