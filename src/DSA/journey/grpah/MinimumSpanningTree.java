package DSA.journey.grpah;

import javax.xml.stream.events.EntityDeclaration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge{
    int src;
    int des;
    int wt;
    public Edge(int wt,int src,int des){
        this.src=src; this.des=des;this.wt=wt;
    }
}

public class MinimumSpanningTree {
    public static void main(String[] args) {

    }

    public int spanningTree(int V,int [][]adj){
        int mstWt=0;
        List<Edge> list=new ArrayList<>();
        for(int i=0;i<V;i++){
            int node=i;
            int adjNode=adj[i][0];
            int wt=adj[i][1];
            list.add(new Edge(wt,node,adjNode));
        }
        Collections.sort(list,(i1,i2)->i1.wt- i2.wt);
        DisjointSet dsu=new DisjointSet(V);
        for(Edge edge:list){
            int wt=edge.wt;
            int u=edge.src;
            int v=edge.des;
            if(dsu.findUParent(u)!=dsu.findUParent(v)){
                mstWt+=mstWt+wt;
                dsu.unionByRank(u,v);
            }
        }
        return  mstWt;
    }
}


//class DisjointSet{
//
//    int []rank;
//    int []parent;
//
//    public DisjointSet(int n){
//
//        rank=new int[n+1];
//        parent=new int[n+1];
//        for(int i=0;i<=n;i++){
//            parent[i]=i;
//        }
//
//
//    }
//
//    public int findUParent(int node){
//
//        if(node==parent[node]){
//            return node;
//        }
//        return parent[node]=findUParent(parent[node]);
//    }
//    public void unionByRank(int u,int v){
//
//        int ultimateParentU=findUParent(u);
//        int ultimateParentV=findUParent(v);
//        if(ultimateParentU==ultimateParentV) return;
//        if(rank[ultimateParentU]<rank[ultimateParentV]){
//            parent[ultimateParentU]=ultimateParentV;
//        }
//        else if(rank[ultimateParentV]<rank[ultimateParentU]){
//            parent[ultimateParentV]=ultimateParentU;
//        }
//        else{
//            parent[ultimateParentV]=ultimateParentU;
//            rank[ultimateParentU]++;
//
//        }
//    }
//
//
//}
