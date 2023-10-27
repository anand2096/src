package DSA.journey.grpah;

import java.util.*;
class Pair{

    int des;
    int dis;
    public Pair(int dis,int des){
        this.des=des;
        this.dis=dis;
    }
}
public class Dijsktra {

    public static void main(String[] args) {
       int A = 6;
       int [][] B = {   {0, 4, 9},
                        {3, 4, 6},
                        {1, 2, 1},
                        {2, 5, 1},
                        {2, 4, 5},
                        {0, 3, 7},
                        {0, 1, 1},
                        {4, 5, 7},
                        {0, 5, 1} };
     int   C = 4;
        System.out.println(Arrays.toString(new Dijsktra().solve(A,B,C)));
    }
    public int[] solve(int A, int[][] B, int C) {
        List<List<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            int u=B[i][0];
            int v=B[i][1];
            int d=B[i][2];
            adjList.get(u).add(new Pair(d,v)); adjList.get(v).add(new Pair(d,u));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((p1,p2)->p1.dis-p2.dis);
        int dis[]=new int[A];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[C]=0;
        pq.add(new Pair(0,C));
        while(pq.size()>0){
            int distance=pq.peek().dis;
            int node=pq.peek().des;
            pq.remove();
            for(Pair pair:adjList.get(node)){
                int edgeWt=pair.dis;
                int adjNode=pair.des;
                if(distance+edgeWt<dis[adjNode]){
                    dis[adjNode]=distance+edgeWt;
                    pq.add(new Pair(dis[adjNode],adjNode));
                }


            }
            // for(int i=0;i<adjList.get(node).size();i++){
            //     int edgeWt=adjList.get(node).get(i).dis;
            //     int adjNode=adjList.get(node).get(i).des;
            //     if(distance+edgeWt<=dis[adjNode]){
            //         dis[adjNode]=distance+edgeWt;
            //         pq.add(new Pair(dis[adjNode],adjNode));
            //     }
            // }
        }
        for(int i=0;i<dis.length;i++){
            if(dis[i]==Integer.MAX_VALUE)dis[i]=-1;
        }
        return dis;
    }
}
