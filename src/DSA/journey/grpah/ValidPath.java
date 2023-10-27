package DSA.journey.grpah;

public class ValidPath {
    int dx[]={-1,-1,0,1,1,1,0,-1};
    int dy[]={0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) {
        int x=2;
        int y=3;
        int n=1;
        int r=1;
        int e[]={2};
        int f[]={3};
        System.out.println(new ValidPath().solve(x,y,n,r,e,f));
    }
    public String solve(int x, int y, int n, int r, int[] E, int[] F) {

        int [][]mat=new int[x+1][y+1];
        for(int i=0;i<E.length;i++){

            mat[E[i]][F[i]]=-1;

        }
        boolean vis[][]=new boolean[x+1][y+1];

        if(isPath(0,0,x,y,mat,vis))return "YES";
        return "NO";

    }
    public boolean isPath(int si,int sj,int ei,int ej,int mat[][],boolean[][]vis){


        if(si==ei&& sj==ej){
            return true;

        }
        vis[si][sj]=true;
        for(int i=0;i<dx.length;i++){
            int delx=si+dx[i];
            int dely=sj+dy[i];
            if(delx>=0 && delx<mat.length && dely>=0 && dely<mat[0].length && !vis[delx][dely] && mat[delx][dely]!=-1){
                isPath(delx,dely,ei,ej,mat,vis);
            }
        }
        // vis[si][sj]=false;
        return false;

    }
}
