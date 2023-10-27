package DSA.journey.grpah;

public class DisjointSet{

    int []rank;
    int []parent;

    public DisjointSet(int n){

        rank=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }


    }

    public int findUParent(int node){

        if(node==parent[node]){
            return node;
        }
        return parent[node]=findUParent(parent[node]);
    }
    public boolean unionByRank(int u,int v){

        int ultimateParentU=findUParent(u);
        int ultimateParentV=findUParent(v);
        if(ultimateParentU==ultimateParentV) return false;
        if(rank[ultimateParentU]<rank[ultimateParentV]){
            parent[ultimateParentU]=ultimateParentV;
        }
        else if(rank[ultimateParentV]<rank[ultimateParentU]){
            parent[ultimateParentV]=ultimateParentU;
        }
        else{
            parent[ultimateParentV]=ultimateParentU;
            rank[ultimateParentU]++;

        }
        return true;
    }


}