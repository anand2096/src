package DSA.Graph;

public class NumberOfEnclaves {
    int count=0;
    int delRow[] = {-1, 0, 1, 0};
    int delCol[] = {0, 1, 0, -1};
    public static void main(String[] args) {
    // int[][]  grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

      //  int[][]  grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        int grid[][]={
                //3 6 , 3 8, 4 8
                    //0 1 2 3 4 5 6 7 8 9
             /*0*/   {0,0,0,1,1,1,0,1,0,0},
                /*1*/{1,1,0,0,0,1,0,1,1,1},
                /*2*/{0,0,0,1,1,1,0,1,0,0},

                /*3*/{0,1,1,0,0,0,1,0,1,0},

                /*4*/{0,1,1,1,1,1,0,0,1,0},

                /*5*/{0,0,1,0,1,1,1,1,0,1},
                /*6*/{0,1,1,0,0,0,1,1,1,1},
                /*7*/{0,0,1,0,0,1,0,1,0,1},
                /*8*/{1,0,1,0,1,1,0,0,0,0},
                /*9*/{0,0,0,0,1,1,0,0,0,1}};

        System.out.println(new NumberOfEnclaves().numEnclaves(grid));
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int oneCount=0;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(i==3 &&j==6 || i==3&&j==8 || i==4 && j==8)
                        System.out.println("");
                    oneCount++;
                   if (dfs(grid,vis,i,j,n,m)){
                       count++;
                   }
                }
            }
        }
        return oneCount-count;
    }
    //3 6 , 3 8, 4 8

    private boolean dfs(int[][] grid, boolean[][] vis, int i, int j, int n, int m) {
        vis[i][j]=true;
        if(i==n ||i==0 ||j==0 ||j==m){
           // count++;
            return true;
        }

        for(int a=0;a<4;a++){
        int nRow=i+delRow[a];
        int nCol=j+delCol[a];

        if(nRow>=0 &&nRow<n &&nCol>=0&&nCol<m && grid[nRow][nCol]==1 && !vis[nRow][nCol]){
            if(dfs(grid,vis,nRow,nCol,n,m)){
                vis[i][j]=false;
                return true;
            }
        }
        }
        vis[i][j]=false;
    return false;
    }


}
