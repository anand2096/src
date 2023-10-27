package DSA.journey.grpah;

import java.util.ArrayList;
import java.util.PriorityQueue;

 class Triple
{
    int s;
    int e;
    int w;

    public Triple(int a,int b,int w)
    {
        this.s=a;
        this.e=b;
        this.w=w;
    }
}
public class KrushkalAlgo {

    public int solve(int A, int[][] B) {
        ArrayList<Triple> adl=new ArrayList<Triple>();

        for(int[] b:B)
        {
            adl.add(new Triple(b[0],b[1],b[2]));
        }

        PriorityQueue<Triple> pq=new PriorityQueue<Triple>((Triple a, Triple b)-> a.w-b.w);
        for(Triple tri:adl)
        {
            pq.add(tri);
        }

        int parent[] =new int[A+1];
        int size[] =new int[A+1];

        for(int i=1;i<=A;i++)
        {
            parent[i]=i;
            size[i]=1;
        }

        long sum=0l;

        while( !pq.isEmpty() )
        {
            Triple tri=pq.poll();

            if(union(tri.s,tri.e,parent,size))
            {
                sum=sum+tri.w;

            }
        }
        return (int) ( sum%(Math.pow(10,9)+7) );


    }
    boolean union(int s,int e,int[] parent,int[] size)
    {
        int rs=root(s,parent);
        int re=root(e,parent);

        if(rs==re)
        {
            return false;
        }
        if(size[rs]<=size[re])
        {

            parent[rs]=re;
            size[re] = size[re]+size[rs];

        }else{

            parent[re]=rs;
            size[rs] = size[rs]+size[re];
        }

        return true;
    }
    int root(int a,int[] parent )
    {
        if(parent[a]==a) return a;

        parent[a]=root(parent[a],parent);

        return parent[a];
    }
}
