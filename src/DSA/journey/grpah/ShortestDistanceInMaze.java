package DSA.journey.grpah;

public class ShortestDistanceInMaze {

    int min=Integer.MAX_VALUE;
    int dx[]={-1,0,1,0 };
    int dy[]={0,1,0,-1 };
    public int solve(int[][] A, int[] B, int[] C) {
        int n=A.length;
        int m=A[0].length;
        boolean vis[][]=new boolean[n][m];
        isPath(B[0],B[1],C[0],C[1],n,m,A,0,vis);
        return min;

    }

    public void isPath(int si,int sj,int ei,int ej,int n,int m,int [][]mat,int count,boolean[][]vis){


        if(si==ei&& sj==ej){
            min=Math.min(min,count);
            return;
        }
        vis[si][sj]=true;
        for(int i=0;i<dx.length;i++){
            int delx=si+dx[i];
            int dely=sj+dy[i];
            if(delx>=0&&delx<n&&dely>=0&&dely<m &&!vis[delx][dely]&& mat[delx][dely]!=1){
                isPath(delx,dely,ei,ej,n,m,mat,count+1,vis);
                vis[delx][dely]=false;
            }
        }
        vis[si][sj]=false;

    }

    public static void main(String[] args) {

//  int [] []mat=   {{0,1,1,0,0,0},
//                  {0,1,0,0,0,0},
//                  {0,0,0,1,0,0},
//                  {0,1,0,1,1,0},
//                  {1,1,0,1,1,1},
//                  {1,0,1,1,0,0},
//                  {1,1,1,1,1,1},
//                  {0,0,1,0,1,0},
//                  {0,1,0,0,0,0},
//                  {0,0,0,0,0,0}};

//      int b[]={7,5};
//
//      int []c={8,3};
int mat[][]={{1,1,0,1},
            {0,0,0,1},
            {1,0,0,1},
            {0,0,1,0}};
int b[]={1,1};
int c[]={2,1};
        System.out.println(new ShortestDistanceInMaze().solve(mat,b,c));


    }
}
