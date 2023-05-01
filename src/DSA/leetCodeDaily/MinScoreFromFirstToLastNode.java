package DSA.leetCodeDaily;


import java.util.ArrayList;
import java.util.List;

class Pairs{
    int node;
    int dis;
    Pairs(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
public class MinScoreFromFirstToLastNode {
    int min =Integer.MAX_VALUE;
    public static void main(String[] args) {


    }

    public int minScore(int n, int[][] roads) {

        List<List<Pairs>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){

            list.get(roads[i][0]-1).add(new Pairs(roads[i][1]-1,roads[i][2]));
            list.get(roads[i][1]-1).add(new Pairs(roads[i][0]-1,roads[i][2]));
        }
        boolean vis[]=new boolean[n];
        dfs(list,vis,0);
        if(vis[n-1])
            return min;
        else return -1;

    }

    private void dfs(List<List<Pairs>> list, boolean[] vis, int node) {
        if(vis[node])
            return;
        for(Pairs child:list.get(node)){
            dfs(list,vis,child.node);
            min=Math.min(min,child.dis);
        }


    }

}
