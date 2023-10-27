package DSA.journey.backracking;

public class UniquePathsIII {

    int ans=0;
    int dx[]={0,1,0,-1};
    int dy[]={1,0,-1,0};

    public static void main(String[] args) {
        int [][] A =
                {{1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}   };
        System.out.println(new UniquePathsIII().solve(A));
    }
    public int solve(int[][] mat) {

        int n=mat.length;
        int m=mat[0].length;
        boolean vis[][]=new boolean[n][m];
        int zeroCount=0;
        int startI=-1;
        int startJ=-1;
        int endI=-1;
        int endJ=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    startI=i;
                    startJ=j;

                }
                else if(mat[i][j]==2){
                    endI=i;
                    endJ=j;
                }
                else if(mat[i][j]==0){
                    zeroCount++;
                }


            }
        }
      //  vis[startI][startJ]=true;
        rec(startI,startJ,endI,endJ,n,m,zeroCount,0,mat,vis);
        return ans;



    }

    public void rec(int i,int j,int endI,int endJ,int n,int m, int totalZero,int currZero,int mat[][],boolean vis[][]){

        if(i==endI && j==endJ){
            if(currZero-1==totalZero){
                ans++;
            }
            return;
        }
        for(int x=0;x<dx.length;x++){
            int delx=dx[x]+i;
            int dely=dy[x]+j;
            if(isValid(delx,dely,n,m,mat,vis)){
                vis[delx][dely]=true;
                rec(delx,dely,endI,endJ,n,m,totalZero,currZero+1,mat,vis);
                vis[delx][dely]=false;
            }
        }


    }

    public boolean isValid(int i, int j,int n,int m,int mat[][],boolean vis[][]){
        if(i<0 ||i>=n || j<0 || j>=m || mat[i][j]==-1 ||mat[i][j]==1|| vis[i][j] ){
            return false;
        }
        return true;

    }
}
