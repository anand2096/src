package DSA.journey.grpah;
import java.util.*;
class EdgeWeight{

    public int source;
    public int des;
    public int wt;
    public EdgeWeight(int source,int des,int wt){
        this.source=source;
        this.des=des;
        this.wt=wt;
    }
}
public class ConstructionCost {


    public int solve(int A, int[][] B) {
        int ans=0;
        int mod=(int)Math.pow(10,9)+7;
        DisjointSet dsu=new DisjointSet(A);
        List<EdgeWeight> adjList=new ArrayList<>();

        for(int i=0;i<B.length;i++){
            int u=B[i][0];
            int v=B[i][1];
            adjList.add(new EdgeWeight(u,v,B[i][2]));
        }
        Collections.sort(adjList,(i1,i2)->i1.wt- i2.wt);
        for(int i=0;i<adjList.size();i++){
            EdgeWeight edge=adjList.get(i);
            int u=edge.source;
            int v=edge.des;
            if(dsu.unionByRank(u,v)){
                ans=ans+edge.wt;
            }
        }
        return ans;
    }
}
